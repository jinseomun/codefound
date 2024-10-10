package com.example.coneeze.HomePage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coneeze.R


@Composable
fun ExplainBanner() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.grandma),  // 이미지 리소스 설정
            contentDescription = "배너 사진",
            modifier = Modifier
                .fillMaxWidth() //가로 꽉 채우면 늘어나서
                .aspectRatio(2942f / 1961f) // 그에 맞춰서 세로 크기도 늘리기
        )
        Text(
            text = "에티오피아 고산지대의\n향기로움을 맛보세요",
            style = TextStyle(
                fontSize = 22.sp,
                lineHeight = 28.sp,
                fontWeight = FontWeight(800),
                color = Color.White,
            ),
            modifier = Modifier
                .padding(start = 28.dp, top = 130.dp)
        )
        Text(
            text = "에티오피아 예가체프 G1",
// Body/Body3 14 R
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 18.sp,
                fontWeight = FontWeight(400),
                color = Color.White,
            ),
            modifier = Modifier
                .padding(start = 28.dp, top = 190.dp)
        )
    }
}

@Preview
@Composable
fun ExplainBannerPreview(){
    ExplainBanner()
}