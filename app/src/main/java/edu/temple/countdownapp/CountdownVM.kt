package edu.temple.countdownapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds

class CountdownVM : ViewModel() {
    var counter by mutableIntStateOf(0)
    val counterStart = 100

    fun startCountdown() {
        viewModelScope.launch {
            repeat(counterStart) {
                counter = counterStart - it
                delay(1000.milliseconds)
            }
        }
    }
}