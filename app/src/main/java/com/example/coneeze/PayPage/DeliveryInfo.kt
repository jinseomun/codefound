package com.example.coneeze.PayPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coneeze.R
import com.example.coneeze.ui.theme.All
import com.example.coneeze.ui.theme.Black22
import com.example.coneeze.ui.theme.FeatureColor
import com.example.coneeze.ui.theme.GrayLine
import com.example.coneeze.ui.theme.suit

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeliveryInfo(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 24.dp)
    ){
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
        ){
            Text(
                text = "홍길동",

                // Headline/Subtitle2 16 SB
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    fontFamily = suit,
                    fontWeight = FontWeight(600),
                    color = Black22,
                )
            )
            
            Spacer(modifier = Modifier.width(8.dp))

            Row(
                modifier = Modifier
                    .width(61.dp)
                    .height(20.dp)
                    .background(color = GrayLine, shape = RoundedCornerShape(size = 4.dp)),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                Text(
                    text = "기본 배송지",
                    style = TextStyle(
                        fontSize = 10.sp,
                        lineHeight = 16.sp,
                        fontFamily = suit,
                        fontWeight = FontWeight(400),
                        color = FeatureColor,
                    ),

                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "[05210] 서울시 강동구 아리수로97길 19 405동 202호",

            // Body/Body3 14 R
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 18.sp,
                fontFamily = suit,
                fontWeight = FontWeight(400),
                color = All,
            )
        )
        
        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "010-7541-0012",

            // Body/Body3 14 R
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 18.sp,
                fontFamily = suit,
                fontWeight = FontWeight(400),
                color = All,
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        val textState = remember { mutableStateOf("") }

        TextField(
            value = textState.value,
            onValueChange = { textState.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(82.dp)
                .border(width = 1.dp, color = GrayLine, shape = RoundedCornerShape(size = 4.dp))
                .padding(start = 16.dp, top = 14.dp, end = 16.dp, bottom = 14.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                focusedIndicatorColor = Color.Transparent, // 포커스 시 하단 선 제거
                unfocusedIndicatorColor = Color.Transparent, // 비포커스 시 하단 선 제거
                disabledIndicatorColor = Color.Transparent, // 비활성화 시 하단 선 제거
                errorIndicatorColor = Color.Transparent,
            ),
            label = {
                Text(
                    text = "배송 메시지를 입력해 주세요.\n\n",
// Body/Body3 14 R
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 18.sp,
                        fontFamily = suit,
                        fontWeight = FontWeight(400),
                        color = All,
                    )
                )
            } // 텍스트 필드에 레이블 추가
        )
    }
}



@Composable
@Preview(showBackground = true)
fun DeliveryInfoPreview(){
DeliveryInfo()
}