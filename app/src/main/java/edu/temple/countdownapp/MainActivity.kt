package edu.temple.countdownapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import edu.temple.countdownapp.ui.theme.CountdownAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CountdownAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Countdown(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Countdown(cvm: CountdownVM = viewModel(), modifier: Modifier = Modifier) {
    Column(Modifier.fillMaxSize(), Arrangement.Center, Alignment.CenterHorizontally) {
        Text(text = cvm.counter.toString(), modifier = modifier, fontSize = 98.sp)

        Button({ cvm.startCountdown() }) {
            Image(
                painterResource(android.R.drawable.ic_media_play), "Start"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CountdownPreview() {
    CountdownAppTheme {
        Countdown()
    }
}