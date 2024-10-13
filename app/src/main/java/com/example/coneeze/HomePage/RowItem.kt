package com.example.coneeze.HomePage

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coneeze.R
import com.example.coneeze.ui.theme.suit

@Composable
fun RowItem(
    navController: NavController,
    name: String,
    image: Int,
    feature: String,
    price: String,
    modifier: Modifier =Modifier
) {
    Row(
        modifier = modifier
    ) {
        Card(
            modifier = Modifier
                .padding(end = 10.dp)
                .width(122.dp)
                .clickable {
                    // Int 타입 이미지 리소스 ID를 그대로 전달
                    navController.navigate("디테일/$image/$name/$price")
                },
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            shape = RoundedCornerShape(
                topStart = 16.dp,
                topEnd = 16.dp,
                bottomEnd = 0.dp,
                bottomStart = 0.dp
            )
        ) {
            Column {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = "배너 사진",
                    modifier = Modifier
                        .width(122.dp)
                        .height(122.dp)
                        .clip(RoundedCornerShape(6.dp))
                )
                Text(
                    text = name,
                    modifier = Modifier.padding(top = 8.dp),
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 18.sp,
                        fontWeight = FontWeight(600),
                        fontFamily = suit
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = feature,
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF60646C),
                        fontFamily = suit
                    )
                )
                Text(
                    text = price,
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight(600),
                        fontFamily = suit
                    )
                )
            }
        }
    }
}