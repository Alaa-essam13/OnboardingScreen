package com.example.onboardingscreen

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.example.onboardingscreen.ui.theme.FirstPageColor
import com.example.onboardingscreen.ui.theme.ForthPageColor
import com.example.onboardingscreen.ui.theme.SecondPageColor
import com.example.onboardingscreen.ui.theme.ThirdPageColor

sealed class Onboardingdata(
    val title: String,
    val description: String,
    @DrawableRes val image: Int,
    val curve: Float,
    val color: Color
){
    data object FirstPage:Onboardingdata(
        "Your first car without \n" +
                "a driver's license",
        "Goes to meet people who just got their license",
        R.drawable.first,
        0.25f,
        FirstPageColor
    )
    data object SecondPage:Onboardingdata(
        "Always there: more than 1000 cars in Tbilisi",
        "Our company is a leader by the number of cars in the fleet",
        R.drawable.second,
        0.5f,
        SecondPageColor
    )
    data object ThirdPage:Onboardingdata(
        "Do not pay for parking,\n maintenance and gasoline",
        "We will pay for you, all expenses related to the car",
        R.drawable.third,
        0.75f,
        ThirdPageColor
    )
    data object ForthPage:Onboardingdata(
        "29 car models: from Skoda\n Octavia to Porsche 911",
        "Choose between regular car models \n" +
                "or exclusive ones",
        R.drawable.forth,
        1.0f,
        ForthPageColor
    )
}
