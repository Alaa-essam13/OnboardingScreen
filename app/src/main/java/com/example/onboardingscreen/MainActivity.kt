package com.example.onboardingscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.onboardingscreen.ui.theme.OnboardingScreenTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val onboadingUtils by lazy {OnboardingUtils(this)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OnboardingScreenTheme {
                Surface(color = MaterialTheme.colorScheme.background){
                    if (onboadingUtils.isOnboardingCompleted()){
                        ShowHomeScreen()
                    }else{
                     ShowOnboardingScreen()
                    }
                }
            }
        }
    }
@Composable
private fun ShowHomeScreen() {

    Column {
        Text(text = "Home Screen", style = MaterialTheme.typography.headlineLarge)
    }


}
@Composable
private fun ShowOnboardingScreen() {
    val scope = rememberCoroutineScope()
    Onboardingcreen {
        onboadingUtils.setOnboardingCompleted()
        scope.launch {
            setContent {
                ShowHomeScreen()
            }
        }
    }
}
}

