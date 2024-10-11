package com.example.coneeze.DetailPage

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.coneeze.components.Order
import com.example.coneeze.components.OrderRepository
import com.example.coneeze.ui.theme.Gray10
import com.example.coneeze.ui.theme.Main600
import com.example.coneeze.ui.theme.suit
import java.time.LocalDate
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

import androidx.navigation.NavController

@Composable
fun Buy_BottomButtonBar(navController: NavController, image: Int, name: String, price: String) {
    BottomAppBar(
        modifier = Modifier
            .height(80.dp), // 크기 설정
        containerColor = Color.Transparent
    ) {
        Button(
            onClick = {
                // 현재 날짜 생성
                val currentDate = ZonedDateTime.now(ZoneId.of("Asia/Seoul"))
                    .format(DateTimeFormatter.ofPattern("yyyy.MM.dd"))

                // 새로운 주문 객체 생성
                val newOrder = Order(
                    orderId = System.currentTimeMillis().toString(),
                    date = currentDate,
                    orderState = "구매 확정",
                    name = name,
                    price = price,
                    imageRes = image
                )

                // 주문 저장
                OrderRepository.addOrder(newOrder)

                // 네비게이션 실행
                navController.navigate("결제완료/$image/$name/$price")
            },
            colors = ButtonDefaults.buttonColors(
                Color.Transparent,
                contentColor = Color.Unspecified
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .background(color = Main600, shape = RoundedCornerShape(size = 4.dp)),
            shape = RectangleShape
        ) {
            Text(
                text = "구매하기",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 18.sp,
                    fontFamily = suit,
                    fontWeight = FontWeight(700),
                    color = Color.White,
                    textAlign = TextAlign.Center,
                )
            )
        }
    }
}
