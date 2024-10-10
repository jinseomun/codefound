package com.example.coneeze.HomePage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coneeze.ui.theme.Main600
import com.example.coneeze.ui.theme.suit
import com.example.coneeze.ui.theme.surround

@Composable
fun ReviewBanner() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, bottom = 20.dp)
                .height(100.dp)
                .background(Color(0xFFEBE5E0))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, bottom = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally


            ) {
                Row() {
                    Text(
                        text = "커니즈 런칭 리뷰 이벤트",
// Headline/Title2 20 EB
                        style = TextStyle(
                            fontSize = 20.sp,
                            lineHeight = 24.sp,
                            fontFamily = surround,
                            fontWeight = FontWeight(700),
                            color = Main600

                            )
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Row() {
                    Text(
                        text = "전상품 구매 후 리뷰 작성 시 5% 적립금 증정!",
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 20.sp,
                            fontFamily = suit,
                            fontWeight = FontWeight(400),
                            textAlign = TextAlign.Center,
                        )
                    )
                }


            }
        }
    }
}

@Preview
@Composable
fun ReviewBannerPreview(){
    ReviewBanner()}