package com.example.onboardingscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.onboardingscreen.ui.theme.Selectedindecatorcolor
import com.example.onboardingscreen.ui.theme.Unselectedindecatorcolor

@Composable
fun Indicator(
    pagesSize: Int,
    currentPage: Int,
    selectedindicatorColor: Color = Selectedindecatorcolor,
) {
    Row(horizontalArrangement = Arrangement.SpaceAround) {
        repeat(pagesSize) {
            Spacer(modifier = Modifier.width(15.dp))
            Box(
                modifier = Modifier
                    .height(14.dp)
                    .width(width = (if (it == currentPage) 40.dp else 16.dp))
                    .clip(
                        RoundedCornerShape(10.dp)
                    )
                    .alpha(if (it == currentPage) 1f else .85f)
                    .background(color = selectedindicatorColor )
            )

        }
    }

}


@Preview(showBackground = true)
@Composable
fun IndicatorUIPreview1() {

    Indicator(pagesSize = 4, currentPage = 0)

}

@Preview(showBackground = true)
@Composable
fun IndicatorUIPreview2() {

    Indicator(pagesSize = 4, currentPage = 1)

}

@Preview(showBackground = true)
@Composable
fun IndicatorUIPreview3() {

    Indicator(pagesSize = 4, currentPage = 2)

}