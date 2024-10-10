package com.example.coneeze.ReviewPage

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coneeze.ui.theme.Black22
import com.example.coneeze.ui.theme.GrayLine
import com.example.coneeze.ui.theme.Main600
import com.example.coneeze.ui.theme.gray17
import com.example.coneeze.ui.theme.suit

@Composable
fun MoreReview(){
Row(
    modifier = Modifier.padding(bottom=24.dp)
) {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            Color.Transparent,  // 버튼 배경을 투명하게 설정
            contentColor = Color.Unspecified
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .border(width = 1.dp, color = gray17, shape = RoundedCornerShape(size = 44.dp))
            .background(color = Color.White, shape = RoundedCornerShape(size = 44.dp)),

        ) {
        Text(
            text = "리뷰 더보기 (5/12)",

            // Button/Button2 14 B
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 18.sp,
                fontFamily = suit,
                fontWeight = FontWeight(700),
                color = Black22,
                textAlign = TextAlign.Center,
            )
        )
    }
}
}


@Preview
@Composable
fun MoreReviewPreview(){
    MoreReview()
}