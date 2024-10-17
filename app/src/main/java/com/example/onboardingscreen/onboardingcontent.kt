package com.example.onboardingscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onboardingscreen.ui.theme.FirstPageColor

@Composable
fun OnboardingUi(onboardingdata: Onboardingdata) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier =
        Modifier
            .fillMaxWidth()

    ) {
        Spacer(modifier = Modifier.height(35.dp))
        Text(
            text = onboardingdata.title,
            modifier = Modifier.fillMaxWidth(.95f),
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 30.sp,
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = onboardingdata.description,
            modifier = Modifier.fillMaxWidth(.95f),
            fontFamily = FontFamily.SansSerif,
            color = Color.White,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(25.dp))
        Image(
            painter = painterResource(onboardingdata.image),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillBounds
        )
    }

}


@Preview(showSystemUi = true)
@Composable
fun OnboardingGraphUIPreview1() {
    OnboardingUi(Onboardingdata.FirstPage)
}

@Preview(showSystemUi = true)
@Composable
fun OnboardingGraphUIPreview2() {
    OnboardingUi(Onboardingdata.SecondPage)
}

@Preview(showSystemUi = true)
@Composable
fun OnboardingGraphUIPreview3() {
    OnboardingUi(Onboardingdata.ThirdPage)
}

@Preview(showSystemUi = true)
@Composable
fun OnboardingGraphUIPreview4() {
    OnboardingUi(Onboardingdata.ForthPage)
}