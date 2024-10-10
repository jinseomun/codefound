package com.example.coneeze.ReviewPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coneeze.R
import com.example.coneeze.ui.theme.Main600
import com.example.coneeze.ui.theme.suit

@Composable
fun Rating() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "5.0",
            style = TextStyle(
                fontSize = 32.sp,
                fontFamily = suit,
                fontWeight = FontWeight(800),
                color = Main600,
            ),
            modifier = Modifier.padding(end=4.dp)
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
            // 세로 중앙 정렬
        ) {
            repeat(5) {
                Image(
                    painter = painterResource(id = R.drawable.yellow_star),
                    contentDescription = "star",
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp)
                        .padding(1.dp)  // 별 사이에 간격 추가
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RatingPreview(){
    Rating()
}