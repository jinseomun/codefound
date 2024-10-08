package com.example.coneez2.mypage

import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coneez2.components.BookingRepository
import com.example.coneez2.components.Bookinginfo
import com.example.coneez2.components.CustomTopBar
import com.example.coneez2.components.ScrollableButton

data class Booking(
    val bookingId: String,
    val date: String,
    val serviceName: String,
    val bookingDate: String,
    val progressMethod: String,        // 진행 방식 (e.g., "오프라인", "온라인")
    val numberOfReservations: String   // 예약 인원수 (e.g., "6명")
)

const val PAYMENT_METHOD = "가상 계좌"
const val PAYMENT_STATUS = "결제 완료"
const val BOOKING_STATE = "예약 신청"
const val TOTAL_AMOUNT = "20,000원"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookingHistoryScreen(navController: NavController) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    // 선택된 버튼 상태를 관리합니다.
    val selectedButton = remember { mutableStateOf("전체") }

    val bookings = BookingRepository.bookings


    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CustomTopBar(
                title = "예약 내역",
                showNavigationIcon = true,
                showActionIcon = false,
                onNavigationClick = { navController.navigate("마이페이지") },
                onActionClick = { /* 액션 버튼 클릭 동작 */ }
            )
        },
        content = { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                // 예약 내역 콘텐츠를 표시합니다.
                BookingHistoryContent(navController, bookings, selectedButton)
            }
        },
        bottomBar = {
            // 하단 바 추가 가능
        }
    )
}

@Composable
fun BookingHistoryContent(navController: NavController, bookings: List<Booking>, selectedButton: MutableState<String>) {
    Column {
        ScrollableButtonRow2(selectedButton)

        val filteredBookings = if (selectedButton.value == "전체") {
            bookings
        } else {
            bookings.filter { BOOKING_STATE == selectedButton.value }
        }

        LazyColumn {
            items(filteredBookings) { booking ->
                BookingCard(booking, navController)
                Divider(color = Color(0xFFF1F2F3), thickness = 1.dp)
            }
        }
    }
}

@Composable
fun BookingCard(booking: Booking, navController: NavController) {
    Box(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .padding(top = 24.dp)
            .fillMaxWidth(),
    ) {
        Column {
            // 첫 줄
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = booking.date,
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                )

                // 예약 상세 버튼
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable(onClick = {
                        navController.navigate("예약상세/${booking.bookingId}")
                    })
                ) {
                    Text(
                        text = "예약 상세",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium
                        ),
                        color = Color.Gray
                    )
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowRight,
                        contentDescription = "Next",
                        modifier = Modifier.size(24.dp),
                        tint = Color.LightGray
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp)
            ) {
                Bookinginfo(front = "예약 상태", back = BOOKING_STATE)
                Bookinginfo(front = "예약 서비스명", back = booking.serviceName)
                Bookinginfo(front = "예약 일자", back = booking.bookingDate)
            }
        }
    }
}

@Composable
fun ScrollableButtonRow2(selectedButton: MutableState<String>) {
    val scrollState = rememberScrollState()

    Row(
        modifier = Modifier
            .horizontalScroll(scrollState)
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
