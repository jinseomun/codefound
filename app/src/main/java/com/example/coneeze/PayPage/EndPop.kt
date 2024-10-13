package com.example.coneeze.PayPage

import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.coneeze.R
import com.example.coneeze.components.Bookinginfo
import com.example.coneeze.components.CustomTopBar
import com.example.coneeze.ui.theme.Main800
import com.example.coneeze.ui.theme.cafeFontFamily
import com.example.coneeze.ui.theme.suit
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EndpopScreen(navController: NavController, image: Int, name: String, price: String) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    val currentDateTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"))
        .format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"))

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

        topBar = {
            CustomTopBar(
                title = "결제완료",
                showNavigationIcon = false, // 네비게이션 아이콘을 보여줌
                showActionIcon = true,    // 액션 아이콘을 숨김
                onNavigationClick = { },
                onActionClick = {navController.navigate("홈")  }
            )
        },
        content = { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                EndpopContent(name = name, price = price, dateTime = currentDateTime)
            }

        },
    )
}

@Composable
fun EndpopContent(name: String, price: String, dateTime: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Spacer(modifier = Modifier.height(40.dp))

                    Image(
                        painter = painterResource(id = R.drawable.check_pay),
                        contentDescription = "완료 아이콘",
                        modifier = Modifier.size(72.dp)
                    )
                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "주문이\n 완료되었습니다.",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 28.sp,
                            color = Main800,
                            fontFamily = cafeFontFamily,
                        ),
                        textAlign = TextAlign.Center
                    )
                }
            }

            Spacer(modifier = Modifier.height(56.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                Divider(color = Color(0xFFF1F2F3), thickness = 1.dp)

                Spacer(modifier = Modifier.height(20.dp))

                Bookinginfo(front = "구매 상품", back = name)

                Spacer(modifier = Modifier.height(4.dp))

                Bookinginfo(front = "결제 일시", back = dateTime)

                Spacer(modifier = Modifier.height(4.dp))

                Bookinginfo(front = "결제 수단", back = "삼성카드 / 일시불")

                Spacer(modifier = Modifier.height(20.dp))

                Divider(color = Color(0xFFF1F2F3), thickness = 1.dp)

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier
                        .padding(vertical = 0.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "결제 금액",
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 20.sp,
                            fontWeight = FontWeight.Medium,
                            fontFamily = suit
                        ),
                        color = Color.Black
                    )

                    Text(
                        text = price,
                        style = TextStyle(
                            fontSize = 22.sp,
                            lineHeight = 20.sp,
                            fontWeight = FontWeight.Medium,
                            fontFamily = suit
                        ),
                        color = Color.Black
                    )
                }




            }
        }


    }
}

