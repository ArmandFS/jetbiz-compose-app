package com.example.jetbiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetbiz.ui.theme.JetBizTheme


//main activity
class MainActivity : ComponentActivity() {
    //main entry point creation of android app
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetBizTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Composable
fun CreateBizCard() {
    //click and show portfolio button
    val buttonClickedState = remember{
        mutableStateOf(false)
    }
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
    ) {
        Card(
            modifier = Modifier
                .width(200.dp)
                .height(390.dp)
                .padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            // Center the profile picture
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CreateImageProfile()
                //call divider function & add modifiers
                CreateInfo()
                Button(
                    onClick = {
                        //change button to toggle portfolio list
                        //toggle back and forth on true and false values
                        buttonClickedState.value = !buttonClickedState.value
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta),
                ) {
                    Text(
                        text = "Portfolio",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.White // Set text color to match button color
                    )
                }
                if(buttonClickedState.value) {
                    Content()
                } else {
                    Box (){
                    }
                }
            }
        }
    }
}

@Composable
fun Content(){
      Box(modifier = Modifier
          .fillMaxHeight()
          .fillMaxWidth()
          .padding(5.dp)) {
          Surface(modifier = Modifier
              .padding(3.dp)
              .fillMaxWidth()
              .fillMaxHeight(),
                   shape = RoundedCornerShape(corner = CornerSize(6.dp)),
                   border = BorderStroke(width = 2.dp, color = Color.LightGray))
          {
              Portfolio(data = listOf("Project 1", "Project 2", "Project 3"))
          }
      }
}

@Composable
fun Portfolio(data: List<String>) {
    //add LazyColumn for scrollable and stackable lists
    LazyColumn{
         items(data){item ->
             Card(
                 modifier = Modifier
                     .padding(13.dp)
                     .fillMaxWidth(),
                 shape = RectangleShape,
                 elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
             ) {
                 Row(
                     modifier = Modifier
                         .padding(8.dp)
                         .background(color = Color.White)
                         .padding(7.dp)
                 ) {
                     CreateImageProfile(modifier = Modifier.size(100.dp))
                     Column(modifier = Modifier
                         .padding(7.dp)
                         .align(alignment = Alignment.CenterVertically)) {
                         Text(text = item, fontWeight = FontWeight.Bold)
                         Text(text = "a Machine Learning Project", style = MaterialTheme.typography.bodyMedium)
                         }

                     }
                 }
             }

         }
    }


@Composable
private fun CreateInfo() {
    Divider()
    Text(
        text = "Armand F.S",
        style = MaterialTheme.typography.headlineMedium,
        color = Color(106, 41, 236),
        modifier = Modifier.padding(5.dp)
    )
    Text(
        text = "Software Developer",
        style = MaterialTheme.typography.bodyLarge,
        color = Color.Black,
        modifier = Modifier.padding(5.dp)
    )
    Text(
        text = "@armandfs",
        style = MaterialTheme.typography.bodyLarge,
        color = Color.Black,
        modifier = Modifier.padding(5.dp)
    )
}
@Composable
fun CreateImageProfile(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier,
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        shadowElevation = 4.dp,
        color = Color.White.copy(alpha = 0.5f)
    ) {
        // Kotlin code to put image in
        Image(
            painter = painterResource(id = R.drawable.pinkdefault),
            contentDescription = "profile image",
            modifier = Modifier.size(100.dp)
        )
    }
}
//default greeting preview
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetBizTheme {
       CreateBizCard()
    }
}
