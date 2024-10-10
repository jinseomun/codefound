package com.example.coneeze.ReviewPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coneeze.R
import com.example.coneeze.ui.theme.Black22
import com.example.coneeze.ui.theme.Gray600
import com.example.coneeze.ui.theme.NumberGray
import com.example.coneeze.ui.theme.suit

@Composable
fun ReviewHeader(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 24.dp)
            .height(21.dp)
    ){
        Text(
            text = "리뷰",

            // Headline/Subtitle2 16 SB
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 20.sp,
                fontFamily = suit,
                fontWeight = FontWeight(600),
                color = Black22,
            ),

            modifier = Modifier.padding(end=4.dp)
        )

        Text(
            text = "12",

            // Headline/Subtitle2 16 SB
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 20.sp,
                fontFamily = suit,
                fontWeight = FontWeight(600),
                color = NumberGray,
            )
        )

        Spacer(modifier = Modifier.weight(1f))

        Button(
            contentPadding = PaddingValues(0.dp),
            onClick = {},
            // 내용에 맞게 버튼 크기 조정
            colors = ButtonDefaults.buttonColors(
                Color.Transparent,  // 버튼 배경을 투명하게 설정
                contentColor = Color.Unspecified ),
            // 기본 텍스트 색상 사용
            shape = RectangleShape

        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                ,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Row() {
                    Text(
                        text = "최신순",

                        // Body/Body3 14 R
                        style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 18.sp,
                            fontFamily = suit,
                            fontWeight = FontWeight(400),
                            color = Gray600,
                        )
                    )
                    Image(
                        painterResource(id = R.drawable.downicon),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(1.dp)
                            .width(18.dp)
                            .height(18.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReviewHeaderPreview(){
    ReviewHeader()
}