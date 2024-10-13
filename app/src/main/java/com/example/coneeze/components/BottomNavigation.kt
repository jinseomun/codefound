package com.example.coneeze.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coneeze.R
import com.example.coneeze.ui.theme.Gray10
import com.example.coneeze.ui.theme.GrayLine
import com.example.coneeze.ui.theme.Main600
import com.example.coneeze.ui.theme.suit

@Composable
fun BottomIconRow(
    navController: NavController,
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit
) {
    // 상태 변수로 현재 선택된 버튼의 인덱스를 저장 (초기값은 0 -> 첫 번째 버튼이 선택된 상태)
    Column {

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
                action = {
                    onItemSelected(0)
                    navController.navigate("홈") {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                } // 클릭하면 첫 번째 버튼이 선택됨
            )
            Spacer(modifier = Modifier.weight(1f))
            BottomIcon(
                image = painterResource(id = R.drawable.coffee),
                text = "예약",
                selected = selectedIndex == 1, // 두 번째 버튼이 선택되어 있는지 확인
                action = {
                    onItemSelected(1)
                    navController.navigate("예약하기") {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                } // 클릭하면 두 번째 버튼이 선택됨
            )
            Spacer(modifier = Modifier.weight(1f))
            BottomIcon(
                image = painterResource(id = R.drawable.my),
                text = "마이페이지",
                selected = selectedIndex == 2, // 세 번째 버튼이 선택되어 있는지 확인
                action = {
                    onItemSelected(2)
                    navController.navigate("마이페이지") {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                } // 클릭하면 세 번째 버튼이 선택됨
            )
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun BottomIcon(
    image: Painter,
    text: String,
    selected: Boolean,
    action: () -> Unit
) {
    Button(
        contentPadding = PaddingValues(0.dp),
        onClick = action,
        // 내용에 맞게 버튼 크기 조정
        colors = ButtonDefaults.buttonColors(
            Color.Transparent,  // 버튼 배경을 투명하게 설정
            contentColor = Color.Unspecified
        ),
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
                    .height(32.dp),

                colorFilter = if (selected) {
                    ColorFilter.tint(Main600)
                } else {
                    null
                }

            )

            Text(
                text = text,

                // Body/Caption 12 R
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    fontFamily = suit,
                    fontWeight = FontWeight(400),
                    color = if (selected) Main600 else Gray10,
                    textAlign = TextAlign.Center,
                )
            )
        }
    }
}

