package com.example.coneeze.HomePage

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.coneeze.R

@Composable
fun BottomIconRow() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // 하단 아이콘들 배치
        Spacer(modifier = Modifier.weight(1f))
        BottomIcon(
            image = painterResource(id = R.drawable.home),
            text = "홈",
            action = {}
        )
        Spacer(modifier = Modifier.weight(1f))
        BottomIcon(
            image = painterResource(id = R.drawable.coffee),
            text = "예약",
            action = {}
        )
        Spacer(modifier = Modifier.weight(1f))
        BottomIcon(
            image = painterResource(id = R.drawable.my),
            text = "마이페이지",
            action = {}
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Preview
@Composable
fun BottomIconRowPreview(){
    BottomIconRow()
}