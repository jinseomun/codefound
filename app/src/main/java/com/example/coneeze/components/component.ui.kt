package com.example.coneeze.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coneeze.ui.theme.Main600

@Composable
fun ScrollableButton(
    text: String,
    selectedButton: MutableState<String>,
    fontSize: Int = 14 // 기본 폰트 크기를 14sp로 설정
) {

    Button(
        modifier = Modifier
            .height(36.dp)
            .border(
                width = 1.dp,
                color = Color(0xFFE4E5E7),
                shape = RoundedCornerShape(44.dp)
            )  // 회색 테두리 추가
            .height(36.dp),  // 버튼 높이를 명시적으로 36dp로 설정
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 0.dp),  // 기본 패딩 제거
        colors = ButtonDefaults.buttonColors(
            containerColor = if (selectedButton.value == text) Main600 else Color.White,
            contentColor = if (selectedButton.value == text) Color.White else Color.Black

        ),
        onClick = { selectedButton.value = text },
        shape = RoundedCornerShape(44.dp),
        content = {
            Text(
                text = text,
                style = TextStyle(
                    fontSize = fontSize.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
        }
    )
}

@Composable
fun Info(front : String, back : String){
    Row(
        modifier = Modifier
            .padding(vertical = 4.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = front,
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight.Medium
            ),
            color = Color.Gray
        )

        Text(
            text = back,
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight.Medium
            ),
            color = Color.Gray
        )

    }
}

@Composable
fun Bookinginfo(front : String, back : String){
    Row(
        modifier = Modifier
            .padding(vertical = 4.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = front,
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight.Medium
            ),
            color = Color.Gray
        )

        Text(
            text = back,
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight.Medium
            ),
            color = Color.Black
        )

    }
}

@Composable
fun RoundButton(onClick: () -> Unit, text: String) {
    Button(
        onClick = onClick,  // 클릭 시 동작할 함수
        modifier = Modifier
            .width(320.dp)  // 너비 설정
            .height(48.dp),  // 높이 설정
        shape = RoundedCornerShape(44.dp),  // 둥근 모서리 처리
        colors = ButtonDefaults.buttonColors(containerColor = Main600)  // 배경색 설정
    ) {
        Text(
            text = text,  // 버튼 텍스트
            style = TextStyle(
                color = Color.White,  // 텍스트 색상
                fontSize = 16.sp  // 텍스트 크기
            )
        )
    }
}
