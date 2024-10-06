package com.example.coneez2.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NextButton() {
    Divider(color = Color(0xFFF1F2F3), thickness = 1.dp)  // 하단에 회색 구분선 추가

    // 버튼을 중앙에 정렬하기 위해 Box와 fillMaxWidth() 사용
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp), // 상하 패딩 추가
        contentAlignment = Alignment.Center // 중앙 정렬
    ) {
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .width(320.dp)
                .height(48.dp),
            shape = RoundedCornerShape(size = 4.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF644E46)) // 버튼 배경 흰색
        ) {
            Text(
                text = "다음",
                color = Color.White,
                style = TextStyle(fontWeight = FontWeight.Bold),
                fontSize = 14.sp // 제목 텍스트 크기 설정
            )
        }
    }
}
