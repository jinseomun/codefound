package com.example.coneeze.ReviewPage

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
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coneeze.R
import com.example.coneeze.ui.theme.All
import com.example.coneeze.ui.theme.Gray600
import com.example.coneeze.ui.theme.GrayLine
import com.example.coneeze.ui.theme.NumberGray
import com.example.coneeze.ui.theme.suit

@Composable
fun CustomerReview(
    name: String,
    review: String,
    date: String
){
Row(
    modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 20.dp, vertical = 24.dp)

) {

Column() {

    Row() {
        Image(
            painterResource(id = R.drawable.profile),
            contentDescription = null,
            modifier = Modifier
                .padding(1.dp)
                .width(36.dp)
                .height(36.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Column() {
                Text(
                    text = name,

                    // Headline/Subtitle 14 SB
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 18.sp,
                        fontFamily = suit,
                        fontWeight = FontWeight(600),
                        color = Gray600,
                    )
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
                                .padding(1.dp)
                                .width(12.dp)
                                .height(12.dp)
                            // 별 사이에 간격 추가
                        )
                    }
                }


            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Absolute.Right
        ) {
            Text(
                text = date,

                // Body/Caption 12 R
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    fontFamily = suit,
                    fontWeight = FontWeight(400),
                    color = NumberGray,
                    textAlign = TextAlign.Right,
                )
            )
        }
    }
    Spacer(modifier = Modifier.height(20.dp))



    Text(
        text = review,

        // Body/Body3 14 R
        style = TextStyle(
            fontSize = 14.sp,
            lineHeight = 18.sp,
            fontFamily = suit,
            fontWeight = FontWeight(400),
            color = All,
        )
    )}}
}

@Preview(showBackground = true)
@Composable
fun CustomerReviewPreview(){
    CustomerReview(
        name= "fp******",
        review= "올 추석은 온가족이 케냐AA 커피의 맛과 향에 빠지겠네요. 맞춤 배송에 감사를 표합니다~!",
        date= "2024.09.11"
    )
}