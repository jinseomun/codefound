package com.example.coneeze.HomePage

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.coneeze.R

@Composable
fun BottomIconRow() {
    // 상태 변수로 현재 선택된 버튼의 인덱스를 저장 (초기값은 0 -> 첫 번째 버튼이 선택된 상태)
    var selectedIndex by remember { mutableStateOf(0) }

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // 하단 아이콘들 배치
        Spacer(modifier = Modifier.weight(1f))
        BottomIcon(
            image = painterResource(id = R.drawable.home),
            text = "홈",
            selected = selectedIndex == 0, // 첫 번째 버튼이 선택되어 있는지 확인
            action = { selectedIndex = 0 } // 클릭하면 첫 번째 버튼이 선택됨
        )
        Spacer(modifier = Modifier.weight(1f))
        BottomIcon(
            image = painterResource(id = R.drawable.coffee),
            text = "예약",
            selected = selectedIndex == 1, // 두 번째 버튼이 선택되어 있는지 확인
            action = { selectedIndex = 1 } // 클릭하면 두 번째 버튼이 선택됨
        )
        Spacer(modifier = Modifier.weight(1f))
        BottomIcon(
            image = painterResource(id = R.drawable.my),
            text = "마이페이지",
            selected = selectedIndex == 2, // 세 번째 버튼이 선택되어 있는지 확인
            action = { selectedIndex = 2 } // 클릭하면 세 번째 버튼이 선택됨
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Preview(showBackground = true)
@Composable
fun BottomIconRowPreview() {
    BottomIconRow()
}