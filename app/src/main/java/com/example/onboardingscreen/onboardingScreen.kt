package com.example.onboardingscreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@Composable
fun Onboardingcreen(onFinished: () -> Unit) {
    val pages = listOf(
        Onboardingdata.FirstPage,
        Onboardingdata.SecondPage,
        Onboardingdata.ThirdPage,
        Onboardingdata.ForthPage
    )
    val pageState = rememberPagerState(initialPage = 0) {
        pages.size
    }
    val scope = rememberCoroutineScope()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = pages[pageState.currentPage].color,
        bottomBar = {
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.fillMaxWidth().padding(10.dp)
            ) {
                Column(
                    Modifier
                        .fillMaxWidth(.7f)
                        .padding(10.dp)) {
                    Indicator(pagesSize = pages.size, currentPage = pageState.currentPage)
                    Spacer(modifier = Modifier.height(10.dp))
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(50.dp)
                            .clickable { onFinished() }) {
                        Text(text = "Skip", fontWeight = FontWeight.Medium, fontSize = 20.sp)
                    }
                }
                OnboadingButton(progress = pages[pageState.currentPage].curve) {
                    scope.launch {
                        if (pageState.currentPage < pages.size - 1) {
                            pageState.animateScrollToPage(pageState.currentPage + 1)
                        } else {
                            onFinished()
                        }
                    }
                }
            }
        },
        content = {
            Column(Modifier.padding(it)) {
                HorizontalPager(state = pageState) { index ->
                    OnboardingUi(onboardingdata = pages[index])
                }
            }

        }
    )
}