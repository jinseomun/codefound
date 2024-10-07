package com.example.coneez2.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import com.example.coneez2.ui.theme.Main600


@Composable
fun NextButton(text : String) {
    Divider(color = Color(0xFFF1F2F3), thickness = 1.dp)  // 하단에 회색 구분선 추가

    // 버튼을 중앙에 정렬하기 위해 Box와 fillMaxWidth() 사용
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 20.dp), // 상하 좌우 패딩 추가
        contentAlignment = Alignment.Center // 중앙 정렬
    ) {
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(size = 4.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Main600)
        ) {
            Text(
                text = text,
                color = Color.White,
                style = TextStyle(fontWeight = FontWeight.Bold),
                fontSize = 14.sp // 제목 텍스트 크기 설정
            )
        }
    }
}

/*
@Composable
fun PrevNextButton() {
    Divider(color = Color(0xFFF1F2F3), thickness = 1.dp)  // 하단에 회색 구분선 추가

    // 버튼을 중앙에 정렬하기 위해 Box와 fillMaxWidth() 사용
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 20.dp), // 상하 좌우 패딩 추가
        contentAlignment = Alignment.Center // 중앙 정렬
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(), // Row가 가득 차도록 설정
            horizontalArrangement = Arrangement.SpaceBetween // 버튼들 사이 간격
        ) {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .weight(1f) // 버튼의 너비가 화면 너비의 1 비율
                    .height(48.dp),
                shape = RoundedCornerShape(size = 4.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF7F5F3))
            ) {
                Text(
                    text = "이전",
                    color = Main600,
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    fontSize = 14.sp // 텍스트 크기 설정
                )
            }

            Spacer(modifier = Modifier.width(8.dp)) // 두 버튼 사이 간격

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .weight(2.5f) // 두 번째 버튼이 첫 번째 버튼의 두 배 너비
                    .height(48.dp),
                shape = RoundedCornerShape(size = 4.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Main600)
            ) {
                Text(
                    text = "다음",
                    color = Color.White,
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    fontSize = 14.sp // 텍스트 크기 설정
                )
            }
        }
    }
}
*/

@Composable
fun PrevNextButton(
    onPrevClick: () -> Unit,
    onNextClick: () -> Unit,
    isPrevEnabled: Boolean = true,
    isNextEnabled: Boolean = true
) {
    Divider(color = Color(0xFFF1F2F3), thickness = 1.dp)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 20.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = onPrevClick,
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp),
                shape = RoundedCornerShape(size = 4.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF7F5F3)),
                enabled = isPrevEnabled
            ) {
                Text(
                    text = "이전",
                    color = Main600,
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    fontSize = 14.sp
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = onNextClick,
                modifier = Modifier
                    .weight(2.5f)
                    .height(48.dp),
                shape = RoundedCornerShape(size = 4.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Main600),
                enabled = isNextEnabled
            ) {
                Text(
                    text = "다음",
                    color = Color.White,
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    fontSize = 14.sp
                )
            }
        }
    }
}