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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat.enableEdgeToEdge
import edu.temple.countdownapp.ui.theme.CountdownAppTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds

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
fun Countdown(modifier: Modifier = Modifier) {
    val scope = rememberCoroutineScope()

    var counter by rememberSaveable { mutableIntStateOf(0) }
    val counterStart = 100

    Column(Modifier.fillMaxSize(), Arrangement.Center, Alignment.CenterHorizontally) {
        Text(text = counter.toString(), modifier = modifier, fontSize = 98.sp)

        Button({
            scope.launch {
                repeat(counterStart) {
                    counter = counterStart - it
                    delay(1000.milliseconds)
                }
            }
        }) { Image(painterResource(android.R.drawable.ic_media_play), "Start") }
    }
}

@Preview(showBackground = true)
@Composable
fun CountdownPreview() {
    CountdownAppTheme {
        Countdown()
    }
}