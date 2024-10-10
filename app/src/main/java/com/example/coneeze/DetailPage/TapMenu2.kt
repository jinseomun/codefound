package com.example.coneeze.DetailPage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coneeze.data.TapNames1
import com.example.coneeze.data.TapNames2
import com.example.coneeze.ui.theme.Main600
import com.example.coneeze.ui.theme.TapGray
import com.example.coneeze.ui.theme.suit

@Composable
fun TapMenu2(
    datas: List<String>
) {
    // 누른 버튼의 인덱스를 기억하는 상태
    var selectedIndex by remember { mutableStateOf(0) }  // 초기값은 선택되지 않은 상태 (-1)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
            .background(color = Color.White)
            .padding(start = 16.dp, end = 16.dp)
    ) {
        Spacer(modifier = Modifier.weight(1f))


            // 각 버튼을 Row 안에서 균등하게 배치하기 위해 weight(1f)를 적용
            TapMenuButton(
                index = 0,
                MenuName = datas[0],
                isSelected = (0 == selectedIndex), // 현재 인덱스가 선택된 인덱스와 같은지 확인
            ) {
                selectedIndex = 0 // 버튼을 클릭하면 선택된 인덱스 변경
            }
        Spacer(modifier = Modifier.weight(1f))

        TapMenuButton(
            index = 1,
            MenuName = datas[1],
            isSelected = (1 == selectedIndex), // 현재 인덱스가 선택된 인덱스와 같은지 확인
        ) {
            selectedIndex = 1 // 버튼을 클릭하면 선택된 인덱스 변경
        }
        Spacer(modifier = Modifier.weight(1f))
        TapMenuButton(
            index = 2,
            MenuName = datas[2],
            isSelected = (2 == selectedIndex), // 현재 인덱스가 선택된 인덱스와 같은지 확인
        ) {
            selectedIndex = 2 // 버튼을 클릭하면 선택된 인덱스 변경
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun TapMenuButton(
    index: Int,
    MenuName: String,
    isSelected: Boolean,  // 선택 여부를 받음
    onClick: () -> Unit,
    // 버튼 클릭 이벤트 처리
) {
    Row() {
        Button(
            contentPadding = PaddingValues(0.dp),
            onClick = onClick,
            modifier = Modifier
                .width(109.dp)
                  // 각 버튼이 Row 내에서 동일하게 공간을 차지하도록 설정
                .height(52.dp),
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,  // 선택된 경우 Main600, 기본 상태는 Gray
                contentColor = if (isSelected) Main600 else TapGray // 선택된 경우 글자색은 Main600, 기본은 TapGray
            )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(109.dp)
                    .drawBehind {
                        // 텍스트 하단에 선 그리기
                        val lineY = size.height // 선을 그릴 y 좌표 (텍스트 하단)
                        drawLine(
                            color = if (isSelected) Main600 else Color.White, // 선 색상
                            start = Offset(0f, lineY), // 시작점 좌표
                            end = Offset(size.width, lineY), // 끝점 좌표
                            strokeWidth = 2.dp.toPx() // 2dp 굵기 적용
                        )
                    }
                    .padding(start = 4.dp, end = 4.dp),
                contentAlignment = Alignment.Center // Box 내부에서 텍스트를 중앙에 배치
            ) {
                Text(
                    text = MenuName,
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 20.sp,
                        fontFamily = suit,
                        fontWeight = FontWeight(700),
                    ),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview
@Composable
fun TapMenu2Preview() {
    TapMenu2(
        datas = TapNames2 // 예시 데이터로 TapNames2 사용
    )
}
