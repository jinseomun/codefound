package com.example.coneeze.HomePage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coneeze.R

@Composable
fun OnedayBanner(){

        Row(
            modifier= Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, bottom = 20.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.onedaybanner),  // 이미지 리소스 설정
                contentDescription = "원데이 배너 사진",
                modifier = Modifier
                    .fillMaxWidth() //가로 꽉 채우면 늘어나서
                    .aspectRatio(4096f / 3151f)

            )
        }
    }


@Preview(showBackground = true)
@Composable
fun OnedayBannerPreview(){
    OnedayBanner()
}
