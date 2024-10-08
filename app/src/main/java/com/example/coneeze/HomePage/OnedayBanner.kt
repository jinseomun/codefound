package com.example.coneeze.HomePage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coneeze.R
import com.example.coneeze.ui.theme.ConeezLaunching
import com.example.coneeze.ui.theme.Main050
import com.example.coneeze.ui.theme.gowun_batang
import com.example.coneeze.ui.theme.suit

@Composable
fun OnedayBanner() {


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(230.dp)

        ) {
            Image(
                painter = painterResource(id = R.drawable.onedaybanner),  // 이미지 리소스 설정
                contentDescription = "원데이 배너 사진",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(386f / 297f),

            )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, top = 75.dp),

                ) {
                    Text(
                        text = "커피 테스트하고!\n원데이 클래스 듣고!",
                        style = TextStyle(
                            fontSize = 20.sp,
                            lineHeight = 24.sp,
                            fontFamily = gowun_batang,
                            fontWeight = FontWeight(700),
                            color = Main050,
                        ),
                        modifier = Modifier
                            .padding(bottom=6.dp)

                    )

                    Text(
                        text = "큐레이션 예약하기",
// Body/Caption 12 R
                        style = TextStyle(
                            fontSize = 12.sp,
                            lineHeight = 16.sp,
                            fontFamily = suit,
                            fontWeight = FontWeight(400),
                            color = ConeezLaunching,
                        )
                    )
                }
        }
    }


@Preview(showBackground = true)
@Composable
fun OnedayBannerPreview(){
    OnedayBanner()
}
