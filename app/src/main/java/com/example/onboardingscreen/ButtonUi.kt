package com.example.onboardingscreen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.onboardingscreen.ui.theme.Selectedindecatorcolor

@Composable
fun OnboadingButton(
    progress: Float,
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(90.dp)
            .padding(5.dp)
            .clickable { onClick() }) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val strokeWidth = 6.dp.toPx()
            drawCircle(
                alpha = .5f,
                color = Selectedindecatorcolor,
                style = Stroke(strokeWidth),
            )

            drawArc(
                color = Selectedindecatorcolor,
                startAngle = -90f,
                sweepAngle = 360 * progress,
                useCenter = false,
                style = Stroke(strokeWidth)
            )

        }
        Button(
            onClick = onClick,
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            modifier = Modifier.size(60.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.arrow), contentDescription =null)
        }
    }
}

@Preview
@Composable
private fun btn1() {
    OnboadingButton(progress = .25f) {

    }
}

@Preview
@Composable
private fun btn2() {
    OnboadingButton(progress = .5f) {

    }
}

@Preview
@Composable
private fun btn3() {
    OnboadingButton(progress = .75f) {

    }
}

@Preview
@Composable
private fun btn4() {
    OnboadingButton(progress = 1f) {

    }
}