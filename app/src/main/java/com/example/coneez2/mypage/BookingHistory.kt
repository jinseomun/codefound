package com.example.coneez2.mypage

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coneez2.components.Bookinginfo
import com.example.coneez2.components.CustomTopBar
import com.example.coneez2.components.ScrollableButton


@OptIn(ExperimentalMaterial3Api::class)  // 실험적 API 사용을 명시적으로 허용
@Composable
fun BookingHistoryScreen(navController: NavController) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CustomTopBar(
                title = "예약 내역",
                showNavigationIcon = true, // 네비게이션 아이콘을 보여줌
                showActionIcon = false,    // 액션 아이콘을 숨김
                onNavigationClick = { /* 네비게이션 클릭 동작 */ },
                onActionClick = { /* 액션 버튼 클릭 동작 */ }
            )
        },
        content = { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                // 메인 콘텐츠
                BookingHistoryContent()
            }
        },
        bottomBar = {
            // 하단 바에 NextButton 추가
        }
    )
}

@Composable
fun BookingHistoryContent() {
    Column {

        ScrollableButtonRow2()

        BookingCard(date = "2026.11.11")

        Divider(color = Color(0xFFF1F2F3), thickness = 1.dp)  // 하단에 회색 구분선 추가

        BookingCard(date = "2026.11.11")

        Divider(color = Color(0xFFF1F2F3), thickness = 1.dp)  // 하단에 회색 구분선 추가

    }
}

@Composable
fun BookingCard(date:String){
    Box(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .padding(top = 24.dp)
            .fillMaxWidth(),
    ) {
        Column {
            //첫줄
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = date,
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                )

                //주문상세
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "예약 상세",
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

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp)
            ) {
                Bookinginfo(front = "예약 상태", back = "예약신청" )

                Bookinginfo(front = "예약 서비스명", back = "향기로운 머피 원데이 클래스" )

                Bookinginfo(front = "예약 일자", back = "2026.12.11" )
            }

        }
    }
}

@Composable
fun ScrollableButtonRow2() {
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
        ScrollableButton("완료", selectedButton)
        Spacer(modifier = Modifier.width(8.dp))
        ScrollableButton("예약 확정", selectedButton)
        Spacer(modifier = Modifier.width(8.dp))
        ScrollableButton("접수 완료", selectedButton)
        Spacer(modifier = Modifier.width(8.dp))
        ScrollableButton("예약 신청", selectedButton)
    }
}



@Preview(showBackground = true)
@Composable
fun Previewbooking() {
    val navController = rememberNavController()
    BookingHistoryScreen(navController)
}
