package com.example.coneeze.mypage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coneeze.R
import com.example.coneeze.components.CustomTopBar
import com.example.coneeze.components.Info
import com.example.coneeze.components.Order
import com.example.coneeze.components.OrderRepository
import com.example.coneeze.ui.theme.suit

@OptIn(ExperimentalMaterial3Api::class)  // 실험적 API 사용을 명시적으로 허용
@Composable
fun MoreDetailScreen(navController: NavController, orderId: String?) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val order = OrderRepository.orders.find { it.orderId == orderId }

    val orders = listOf(
        Order(
            orderId = "2024111109162123456",
            date = "2026.11.11",
            orderState = "구매확정",
            name = "100% 아라비카 블렌드 바라던허니 스페셜티",
            price = "13,800원",
            imageRes = R.drawable.coffee1
        ),
        Order(
            orderId = "2024111109162123457",
            date = "2026.11.02",
            orderState = "배송완료",
            name = "에티오피아 코케허니 예가체프G1 스페셜티",
            price = "12,200원",
            imageRes = R.drawable.coffee2
        ),
    )

    Scaffold(modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection), topBar = {
        CustomTopBar(title = "주문 상세",
            showNavigationIcon = true, // 네비게이션 아이콘을 보여줌
            showActionIcon = false,    // 액션 아이콘을 숨김
            onNavigationClick = { navController.navigate("주문내역") },
            onActionClick = { /* 액션 버튼 클릭 동작 */ })
    }, content = { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(color = Color.White)
        ) {
            order?.let {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(8.dp) // 아이템 간의 간격 설정
                ) {
                    item {
                        MoreDetailContent(it)
                    }
                }
            } ?: run {
                Text("주문 정보를 찾을 수 없습니다.", modifier = Modifier.padding(16.dp))
            }
        }
    }, bottomBar = {
        // 하단 바에 NextButton 추가
    })
}

@Composable
fun MoreDetailContent(order: Order) {
    Column() {

        //첫 박스
        Box(
            modifier = Modifier.fillMaxWidth()

        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 24.dp)
            ) {
                Text(
                    text = order.date, style = TextStyle(
                        fontSize = 22.sp, fontWeight = FontWeight.Bold, fontFamily = suit
                    )
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "주문번호 ${order.orderId}", style = TextStyle(
                        fontSize = 14.sp, fontWeight = FontWeight.Medium, fontFamily = suit
                    ), color = Color.Gray
                )
            }
        }

        Divider(color = Color(0xFFF1F2F3), thickness = 1.dp)  // 하단에 회색 구분선 추가

        //두번째 박스
        Box(
            modifier = Modifier.fillMaxWidth()

        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 24.dp)
            ) {
                Text(
                    text = "배송정보", style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = suit
                    )
                )

                Spacer(modifier = Modifier.height(14.dp))

                Text(
                    text = order.name, style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight.Medium,
                        fontFamily = suit
                    ), color = Color.Gray
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "[05210] 서울시 강동구 아리수로97길 19 405동 202호", style = TextStyle(
                        fontSize = 14.sp, fontWeight = FontWeight.Medium, fontFamily = suit
                    ), color = Color.Gray
                )
                Text(
                    text = "010-7541-0012   ", style = TextStyle(
                        fontSize = 14.sp, fontWeight = FontWeight.Medium, fontFamily = suit
                    ), color = Color.Gray
                )

            }
        }

        Divider(color = Color(0xFFF1F2F3), thickness = 1.dp)  // 하단에 회색 구분선 추가

        //세번째 박스
        Box(
            modifier = Modifier.fillMaxWidth()

        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 24.dp)
            ) {
                Text(
                    text = "주문 상품 정보", style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = suit
                    )
                )


                Spacer(modifier = Modifier.height(16.dp))

                Row {
                    Image(
                        painter = painterResource(id = order.imageRes),
                        contentDescription = "oreder1",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(85.dp)
                            .clip(RoundedCornerShape(16.dp)),
                    )

                    Spacer(modifier = Modifier.width(12.dp))

                    Column {
                        Text(
                            text = order.name, style = TextStyle(
                                fontSize = 15.sp,
                                lineHeight = 18.sp,
                                fontWeight = FontWeight(400),
                                color = Color(0xFF303236),
                                fontFamily = suit
                            ), maxLines = 1, overflow = TextOverflow.Ellipsis
                        )

                        Spacer(modifier = Modifier.height(1.dp))


                        Text(
                            text = "100g / 1개", style = TextStyle(
                                fontSize = 13.sp,
                                lineHeight = 16.sp,
                                fontWeight = FontWeight(400),
                                color = Color(0xFF60646C),
                                fontFamily = suit
                            )
                        )

                        Spacer(modifier = Modifier.height(1.dp))

                        Text(
                            text = order.price,
                            style = TextStyle(
                                fontSize = 15.sp,
                                lineHeight = 18.sp,
                                fontWeight = FontWeight(400),
                                color = Color(0xFF303236),
                                fontFamily = suit
                            ),

                            )

                    }

                }
            }
        }

        Divider(color = Color(0xFFF1F2F3), thickness = 1.dp)  // 하단에 회색 구분선 추가

        //네번째 박스
        Box(
            modifier = Modifier.fillMaxWidth()

        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 24.dp)
            ) {
                Text(
                    text = "결제 정보", style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = suit

                    )
                )

                Spacer(modifier = Modifier.height(10.dp))

                Info(front = "총 상품 금액", back = order.price)

                Info(front = "배송비", back = "0원")

                Info(front = "할인 쿠폰", back = "-0원")

                Info(front = "결제 수단", back = "가상계좌")

                // 총금액
                Row(
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "최종 결제 금액", style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 20.sp,
                            fontWeight = FontWeight.Medium,
                            fontFamily = suit
                        ), color = Color.Black
                    )

                    Text(
                        text = order.price, style = TextStyle(
                            fontSize = 18.sp,
                            lineHeight = 20.sp,
                            fontWeight = FontWeight.Medium,
                            fontFamily = suit
                        ), color = Color.Black
                    )

                }

            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun Previewmoredetail() {
    val navController = rememberNavController()
    val sampleOrderId = "2024111109162123456"

    MoreDetailScreen(navController = navController, orderId = sampleOrderId)
}