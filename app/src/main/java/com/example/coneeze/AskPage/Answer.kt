package com.example.coneeze.AskPage

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coneeze.ui.theme.All
import com.example.coneeze.ui.theme.NumberGray
import com.example.coneeze.ui.theme.suit

@Composable
fun Answer(
    name: String,
    question: String,
    questionDate: String,
    answer:String,
    answerDate: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 24.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = name,

                // Headline/Subtitle 14 SB
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 18.sp,
                    fontFamily = suit,
                    fontWeight = FontWeight(600),
                    color = NumberGray,
                )
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Absolute.Right
            ) {
                Text(
                    text = "답변 완료",

                    // Headline/Subtitle 14 SB
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 18.sp,
                        fontFamily = suit,
                        fontWeight = FontWeight(600),
                        color = All,
                        textAlign = TextAlign.Right,
                    )
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))


        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Q.",

                // Body/Body3 14 R
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 18.sp,
                    fontFamily = suit,
                    fontWeight = FontWeight(400),
                    color = All,
                )
            )
            Spacer(modifier = Modifier.width(4.dp))
Column() {
    Text(
        text = question,

        // Body/Body3 14 R
        style = TextStyle(
            fontSize = 14.sp,
            lineHeight = 18.sp,
            fontFamily = suit,
            fontWeight = FontWeight(400),
            color = All,
        )
    )

    Spacer(modifier = Modifier.width(2.dp))

    Text(
        text = questionDate,

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

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "A.",

                // Body/Body3 14 R
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 18.sp,
                    fontFamily = suit,
                    fontWeight = FontWeight(400),
                    color = All,
                )
            )
            Spacer(modifier = Modifier.width(4.dp))
            Column() {
                Text(
                    text = answer,

                    // Body/Body3 14 R
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 18.sp,
                        fontFamily = suit,
                        fontWeight = FontWeight(400),
                        color = All,
                    )
                )

                Spacer(modifier = Modifier.width(2.dp))

                Text(
                    text = answerDate,

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
    }

}
@Preview(showBackground = true)
@Composable
fun AnswerPreview(){
Answer(
    name= "luv******",
    question= "양이 조금 모자라는 것 같아요.",
    questionDate= "2024.11.11",
    answer="안녕하세요! 커니즈입니다.\n" +
            "처음 소분 할 때 기계로 정확히 무게를 재어 소분하는데, 이 과정에서 수분이 조금 빠져나가 무게가 상이할 수 있습니다. 이 점 참고 부탁드립니다. 감사합니다.",
    answerDate= "2024.11.11"
)

}