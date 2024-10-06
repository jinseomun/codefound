package com.example.coneez2.page

import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coneez2.components.CustomTopBar
import com.example.coneez2.ui.theme.Main600

@OptIn(ExperimentalMaterial3Api::class)  // 실험적 API 사용을 명시적으로 허용
@Composable
fun OrderDetailScreen() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CustomTopBar(
                title = "주문 내역",
                showNavigationIcon = true, // 네비게이션 아이콘을 보여줌
                showActionIcon = false,    // 액션 아이콘을 숨김
                onNavigationClick = { /* 네비게이션 클릭 동작 */ },
                onActionClick = { /* 액션 버튼 클릭 동작 */ }
            )
        },
        content = { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                // 메인 콘텐츠
                OrderDetailContent()
            }
        },
        bottomBar = {
            // 하단 바에 NextButton 추가
        }
    )
}

@Composable
fun OrderDetailContent(){
    Column {
        ScrollableButtonRow()

        OrderCard("2026.11.11")
    }
}

@Composable
fun ScrollableButtonRow() {
    val selectedButton = remember { mutableStateOf("전체") }

    // Horizontal scroll state
    val scrollState = rememberScrollState()

    // Row with horizontal scroll enabled
    Row(
        modifier = Modifier
            .horizontalScroll(scrollState) // Row가 좌우로 스크롤 가능하도록 설정
            .padding(horizontal = 20.dp, vertical = 8.dp)
    ) {
        ScrollableButton("전체", selectedButton)
        Spacer(modifier = Modifier.width(8.dp))
        ScrollableButton("구매 확정", selectedButton)
        Spacer(modifier = Modifier.width(8.dp))
        ScrollableButton("배송 완료", selectedButton)
        Spacer(modifier = Modifier.width(8.dp))
        ScrollableButton("배송중", selectedButton)
        Spacer(modifier = Modifier.width(8.dp))
        ScrollableButton("출고 완료", selectedButton)
    }
}

@Composable
fun ScrollableButton(text: String, selectedButton: MutableState<String>) {

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
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
        }
    )
}

@Composable
fun OrderCard(Date : String){
    Box(
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 24.dp)
            .height(200.dp)
            .fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = Date,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "주문상세",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    ),
                    color = Color.Gray
                )
                IconButton(
                    onClick = { },
                    modifier = Modifier.size(24.dp),  // 버튼 크기를 명시적으로 설정

                ) {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowRight,  // 네비게이션 아이콘 (왼쪽 아이콘)
                        contentDescription = "Back",
                        modifier = Modifier.size(24.dp),
                        tint = Color.LightGray
                    )
                }

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Previeworderdetail() {
    OrderDetailScreen()
}

