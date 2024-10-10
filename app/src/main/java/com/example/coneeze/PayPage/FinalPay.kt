package com.example.coneeze.PayPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coneeze.R
import com.example.coneeze.ui.theme.All
import com.example.coneeze.ui.theme.FeatureColor
import com.example.coneeze.ui.theme.GrayLine
import com.example.coneeze.ui.theme.Main600
import com.example.coneeze.ui.theme.suit

@Composable
fun FinalPay(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 24.dp),

    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically

        ){
            Text(
                text = "최종 결제 정보",

                // Headline/Subtitle2 16 SB
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    fontFamily = suit,
                    fontWeight = FontWeight(600),
                    color = All,
                )
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "12,700원",

                // Headline/Subtitle2 16 SB
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    fontFamily = suit,
                    fontWeight = FontWeight(600),
                    color = All,

                ),
            )
            Image(
                painterResource(id = R.drawable.up),
                contentDescription = null,
                modifier = Modifier
                    .padding(1.dp)
                    .width(24.dp)
                    .height(24.dp)
            )
        }
        Spacer(modifier = Modifier.height(24.dp))

        FinalPayDetail(
            text="총 상품 금액",
            money= "12,700원"
        )
        Spacer(modifier = Modifier.height(8.dp))

        FinalPayDetail(
            text="배송비",
            money= "0원"
        )

        Spacer(modifier = Modifier.height(8.dp))

        FinalPayDetail(
            text="할인 쿠폰",
            money= "-0원"
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .border(width = 1.dp, color = GrayLine)
                .padding(1.dp)
                .width(320.dp)
                .height(0.dp)
        ){}

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier= Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "총 결제 금액",

                // Headline/Subtitle 14 SB
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 18.sp,
                    fontFamily = suit,
                    fontWeight = FontWeight(600),
                    color = All,
                )
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "12,700원",
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 22.sp,
                    fontFamily = suit,
                    fontWeight = FontWeight(700),
                    color = Main600,
                    textAlign = TextAlign.Right,
                )
            )
        }
    }
}



@Composable
fun FinalPayDetail(
    text: String,
    money: String
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ){
        Text(
            text = text,

            // Body/Body3 14 R
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 18.sp,
                fontFamily = suit,
                fontWeight = FontWeight(400),
                color = FeatureColor,
            )
        )
        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = money,

            // Body/Body3 14 R
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 18.sp,
                fontFamily = suit),
            fontWeight = FontWeight(400),
            color = FeatureColor,
            textAlign = TextAlign.Right,
        )

    }
}

@Preview(showBackground = true)
@Composable
fun FinalPayPreview(){
    FinalPay()
}