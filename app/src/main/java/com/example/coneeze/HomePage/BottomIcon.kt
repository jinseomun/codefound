package com.example.coneeze.HomePage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coneeze.R
import com.example.coneeze.ui.theme.Gray10
import com.example.coneeze.ui.theme.suit

@Composable
fun BottomIcon(
    image: Painter,
    text: String,
    action: () -> Unit
) {
    Button(
        contentPadding = PaddingValues(0.dp),
        onClick = action,
        // 내용에 맞게 버튼 크기 조정
        colors = ButtonDefaults.buttonColors(
            Color.Transparent,  // 버튼 배경을 투명하게 설정
            contentColor = Color.Unspecified ),
        // 기본 텍스트 색상 사용
        shape = RectangleShape
    ) {


        Column(
            modifier = Modifier
                .width(120.dp)
                .height(60.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = image,
                contentDescription = "image description",

                modifier = Modifier
                    .width(32.dp)
                    .height(32.dp)

            )

            Text(
                text = text,

                // Body/Caption 12 R
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    fontFamily = suit,
                    fontWeight = FontWeight(400),
                    color = Gray10,
                    textAlign = TextAlign.Center,
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomIconPreview(){
    BottomIcon(
        image = painterResource(id = R.drawable.coffee),
        text = "예약",
        action = {}
    )
}