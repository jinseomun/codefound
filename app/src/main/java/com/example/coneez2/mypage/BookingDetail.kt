package com.example.coneez2.mypage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
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
import com.example.coneez2.components.Info

@OptIn(ExperimentalMaterial3Api::class)  // 실험적 API 사용을 명시적으로 허용
@Composable
fun BookingDetailScreen(navController: NavController) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CustomTopBar(
                title = "예약 상세",
                showNavigationIcon = true, // 네비게이션 아이콘을 보여줌
                showActionIcon = false,    // 액션 아이콘을 숨김
                onNavigationClick = { /* 네비게이션 클릭 동작 */ },
                onActionClick = { /* 액션 버튼 클릭 동작 */ }
            )
        },
        content = { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                // 메인 콘텐츠
                BookingDetailContent()
            }
        },
        bottomBar = {
            // 하단 바에 NextButton 추가
        }
    )
}

@Composable
fun BookingDetailContent() {
    Column {
        //첫 박스
        Box(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .padding(vertical = 24.dp)
                .fillMaxWidth(),
        ) {
            Column {
                Box(
                    modifier = Modifier
                ) {
                    Text(
                        text = "기본 정보",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Bookinginfo(front = "예약 번호", back = "123456789")
                Bookinginfo(front = "예약 상태", back = "예약 신청")
            }
        }
        Divider(color = Color(0xFFF1F2F3), thickness = 1.dp)  // 하단에 회색 구분선 추가

        //둘째 박스
        Box(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .padding(vertical = 24.dp)
                .fillMaxWidth(),
        ) {
            Column {
                Box(
                    modifier = Modifier
                ) {
                    Text(
                        text = "예약 상세 정보",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Bookinginfo(front = "예약 서비스명", back = "향기로운 커피 원데이 클래스")
                Bookinginfo(front = "예약 일자", back = "2026.11.11")
                Bookinginfo(front = "진행 방식", back = "오프라인")
                Bookinginfo(front = "예약 인원수", back = "6명")
            }
        }

        Divider(color = Color(0xFFF1F2F3), thickness = 1.dp)  // 하단에 회색 구분선 추가

        Box(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .padding(vertical = 24.dp)
                .fillMaxWidth(),
        ) {
            Column {
                Box(
                    modifier = Modifier
                ) {
                    Text(
                        text = "결제 정보",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Info(front = "결제 수단", back = "가상 계좌")
                Info(front = "결제 상태", back = "결제 완료")
                Info(front = "결제 일시", back = "2026.11.11")

                // 총금액
                Row(
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "최종 결제 금액",
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 20.sp,
                            fontWeight = FontWeight.Medium
                        ),
                        color = Color.Black
                    )

                    Text(
                        text = "20,000원",
                        style = TextStyle(
                            fontSize = 22.sp,
                            lineHeight = 20.sp,
                            fontWeight = FontWeight.Medium
                        ),
                        color = Color.Black
                    )

                }
            }

        }
    }
}

@Composable
fun BookingDetailCard() {

}

@Preview(showBackground = true)
@Composable
fun Previewbookingdetail() {
    val navController = rememberNavController()
    BookingDetailScreen(navController)
}
