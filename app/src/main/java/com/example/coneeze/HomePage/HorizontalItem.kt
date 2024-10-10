package com.example.coneeze.HomePage

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.coneeze.R


@Composable
fun HorizontalItem(
    navController: NavController,
    name: String,
    image: Int,
    feature: String,
    price: String
) {
    Card(
        modifier = Modifier
            .width(155.dp)
            .height(219.dp)
            .clickable {
                navController.navigate("디테일/$image/$name/$price")
            },  // 각 항목의 너비를 고정
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(
            topStart = 16.dp,  // 상단 왼쪽 모서리 둥글게
            topEnd = 16.dp,    // 상단 오른쪽 모서리 둥글게
            bottomEnd = 0.dp,  // 하단 오른쪽 모서리는 뾰족하게
            bottomStart = 0.dp // 하단 왼쪽 모서리는 뾰족하게
        )

        ) {
        Column(
        ) {
            Image(
                painter = painterResource(id = image),  // 이미지 리소스 설정
                contentDescription = "배너 사진",
                modifier = Modifier
                    .width(155.dp)
                    .height(155.dp)
                    .clip(RoundedCornerShape(6.dp))
            )
            Text(
                text = name,
                modifier = Modifier
                    .padding(top=8.dp),
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 18.sp,
                    fontWeight = FontWeight(600),
                ),
                maxLines = 1,  // 한 줄로 제한
                overflow = TextOverflow.Ellipsis)

            Text(
                text = feature,

                // Body/Caption 12 R
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF60646C)
                )
            )

            Text(
                text = price,

                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight(600),

                    )
            )
        }
    }
}

