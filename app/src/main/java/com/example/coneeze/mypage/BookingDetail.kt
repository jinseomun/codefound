package com.example.coneeze.mypage

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
import com.example.coneeze.components.BookingRepository
import com.example.coneeze.components.Bookinginfo
import com.example.coneeze.components.CustomTopBar
import com.example.coneeze.components.Info

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookingDetailScreen(navController: NavController, bookingId: String?) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    // 예약 목록 (실제로는 ViewModel이나 Repository에서 데이터를 가져옵니다)
    val bookings = BookingRepository.bookings


    // 예약 ID로 해당 예약을 찾습니다.
    val booking = bookings.find { it.bookingId == bookingId }

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CustomTopBar(
                title = "예약 상세",
                showNavigationIcon = true,
                showActionIcon = false,
                onNavigationClick = { navController.navigate("예약내역") },
                onActionClick = { /* 액션 버튼 클릭 동작 */ }
            )
        },
        content = { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                booking?.let {
                    // 예약 상세 정보를 표시합니다.
                    BookingDetailContent(it)
                } ?: run {
                    // 예약 정보를 찾을 수 없는 경우 메시지를 표시합니다.
                    Text("예약 정보를 찾을 수 없습니다.")
                }
            }
        },
        bottomBar = {
            // 하단 바 추가 가능
        }
    )
}

@Composable
fun BookingDetailContent(booking: Booking) {
    Column {
        // 첫 번째 박스
        Box(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .padding(vertical = 24.dp)
                .fillMaxWidth(),
        ) {
            Column {
                Text(
                    text = "기본 정보",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                Bookinginfo(front = "예약 번호", back = booking.bookingId)
                Bookinginfo(front = "예약 상태", back = BOOKING_STATE)
            }
        }
        Divider(color = Color(0xFFF1F2F3), thickness = 1.dp)

        // 두 번째 박스
        Box(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .padding(vertical = 24.dp)
                .fillMaxWidth(),
        ) {
            Column {
                Text(
                    text = "예약 상세 정보",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                Bookinginfo(front = "예약 서비스명", back = booking.serviceName)
                Bookinginfo(front = "예약 일자", back = booking.bookingDate)
                Bookinginfo(front = "진행 방식", back = booking.progressMethod) // 필요한 경우 Booking 클래스에 추가
                Bookinginfo(front = "예약 인원수", back = booking.numberOfReservations)
            }
        }

        Divider(color = Color(0xFFF1F2F3), thickness = 1.dp)

        // 세 번째 박스
        Box(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .padding(vertical = 24.dp)
                .fillMaxWidth(),
        ) {
            Column {
                Text(
                    text = "결제 정보",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                Info(front = "결제 수단", back = PAYMENT_METHOD)
                Info(front = "결제 상태", back = PAYMENT_STATUS)
                Info(front = "결제 일시", back = booking.date)

                // 총 결제 금액
                Row(
                    modifier = Modifier
                        .padding(vertical = 0.dp)
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
                        text = TOTAL_AMOUNT,
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

@Preview(showBackground = true)
@Composable
fun PreviewBookingDetail() {
    val navController = rememberNavController()
    val sampleBookingId = "123456789" // 실제 예약 데이터에 있는 bookingId를 사용하세요
    BookingDetailScreen(navController = navController, bookingId = sampleBookingId)
}