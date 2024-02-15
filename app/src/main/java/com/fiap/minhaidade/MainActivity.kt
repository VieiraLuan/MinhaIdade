package com.fiap.minhaidade

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fiap.minhaidade.ui.theme.MinhaIdadeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MinhaIdadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    MyCounterScreen()
                }
            }
        }
    }
}

@Composable
fun MyCounterScreen() {

    var age: Int by remember {
        mutableIntStateOf(0)
    }


    //Header with the age and instructions for the users
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ){
        Text(
            text = "What is your age?",
            color = Color(0xFFFF0084),
            fontSize = 24.sp,
            fontWeight = FontWeight.Black,
            textAlign = TextAlign.Center,
           // modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(25.dp))
        Text(
            text = "Press the buttons to inform your age.",
            fontSize = 20.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(25.dp))

        //Show the age

        Text(
            text = "$age",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold
        )

        Spacer(modifier = Modifier.height(25.dp))

        //Actions Buttons
        Row(

            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()


            ){
            //-1 to your age
            Button(
                onClick = {
                          //Updating the age
                          if(age!=0){
                              age--
                              Log.i("FIAP","Valor $age")
                          }

                },

                colors = ButtonDefaults.buttonColors(Color(0xFFFF0084)),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.size(84.dp)

            ){
                Text(text = "-")
            }




            // + 1 to your age
            Button(
                onClick = {
                          //Updating the age
                        if(age in 0..129) {
                            age++
                            Log.i("FIAP", "Valor $age")
                        }

                },
                colors = ButtonDefaults.buttonColors(Color(0xFFFF0084)),
                modifier = Modifier.size(84.dp),
                shape = RoundedCornerShape(8.dp)

            ){
                Text(text = "+")
            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        Column {
            if(age>=18){
                Text(
                    text = "you are an adult.",
                    fontSize = 20.sp,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }else{
                Text(
                    text = "you are just a child.",
                    fontSize = 20.sp,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        Row {
            Button(
                onClick = {
                    //Updating the age

                        age=0
                        Log.i("FIAP","Valor $age")

                },

                colors = ButtonDefaults.buttonColors(Color(0xFFFF0084)),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.size(100.dp),


            ){
                Text(text = "Restart")
            }
        }

    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyCounterScreenPreview() {
    MyCounterScreen()
}