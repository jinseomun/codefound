package com.example.coneez2.mypage

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
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
import com.example.coneez2.R
import com.example.coneez2.components.CustomTopBar
import com.example.coneez2.components.ScrollableButton

data class Order(
    val orderId: String,
    val date: String,
    val orderState: String,
    val name: String,
    val price: String,
    @DrawableRes val imageRes: Int
)

@OptIn(ExperimentalMaterial3Api::class)  // 실험적 API 사용을 명시적으로 허용
@Composable
fun OrderDetailScreen(navController: NavController) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    val selectedButton = remember { mutableStateOf("전체") }

    val orders = listOf(
        Order(
            orderId = "2024111109162123456",
            date = "2026.11.11",
            orderState = "구매 확정",
            name = "100% 아라비카 블렌드 바라던허니 스페셜티",
            price = "13,800원",
            imageRes = R.drawable.coffee1
        ),
        Order(
            orderId = "2024111109162123457",
            date = "2026.11.02",
            orderState = "배송 완료",
            name = "에티오피아 코케허니 예가체프G1 스페셜티",
            price = "12,200원",
            imageRes = R.drawable.coffee2
        ),
    )


    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CustomTopBar(
                title = "주문 내역",
                showNavigationIcon = true, // 네비게이션 아이콘을 보여줌
                showActionIcon = false,    // 액션 아이콘을 숨김
                onNavigationClick = { navController.navigate("마이페이지") },
                onActionClick = { /* 액션 버튼 클릭 동작 */ }
            )
        },
        content = { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                Column {
                    // 2. selectedButton을 ScrollableButtonRow1에 전달합니다.
                    ScrollableButtonRow1(selectedButton)

                    // 3. selectedButton의 값에 따라 주문 목록을 필터링합니다.
                    val filteredOrders = if (selectedButton.value == "전체") {
                        orders
                    } else {
                        orders.filter { it.orderState == selectedButton.value }
                    }

                    LazyColumn {
                        items(filteredOrders) { order ->
                            OrderCard(order, navController)
                        }
                    }
                }
            }
        },
        bottomBar = {
            // 하단 바에 NextButton 추가
        }
    )
}

@Composable
fun ScrollableButtonRow1(selectedButton: MutableState<String>) {
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
fun OrderCard(order: Order, navController: NavController) {
    Box(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .padding(top = 24.dp)
            .height(200.dp)
            .fillMaxWidth(),
    ) {
        Column {
            //첫줄
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = order.date,
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                )

                //주문상세
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable(onClick = {
                        navController.navigate("주문상세/${order.orderId}")
                    })
                ) {
                    Text(
                        text = "주문상세",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium
                        ),
                        color = Color.Gray
                    )
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowRight,  // 네비게이션 아이콘 (왼쪽 아이콘)
                        contentDescription = "Next",
                        modifier = Modifier.size(24.dp),
                        tint = Color.LightGray
                    )

                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            //구매확정
            Box {
                Text(
                    text = order.orderState,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    ),
                    color = Color(0xFF68BC43)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

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
                        text = order.name,
                        style = TextStyle(
                            fontSize = 15.sp,
                            lineHeight = 18.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF303236),
                        ),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                    Spacer(modifier = Modifier.height(1.dp))


                    Text(
                        text = "100g / 1개",
                        style = TextStyle(
                            fontSize = 13.sp,
                            lineHeight = 16.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF60646C),
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
                        ),

                        )

                }

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Previeworderdetail() {
    val navController = rememberNavController()
    OrderDetailScreen(navController)
}

