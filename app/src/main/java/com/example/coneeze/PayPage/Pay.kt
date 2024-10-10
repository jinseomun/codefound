package com.example.coneeze.PayPage

import CardSelect
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coneeze.CategoryPage.BackTopBar
import com.example.coneeze.CategoryPage.Section
import com.example.coneeze.CategoryPage.TapMenu1
import com.example.coneeze.CategoryPage.TenItems
import com.example.coneeze.DetailPage.BottomButtonBar
import com.example.coneeze.HomePage.BottomIconRow
import com.example.coneeze.HomePage.GrayLine
import com.example.coneeze.R
import com.example.coneeze.data.TapNames1
import com.example.coneeze.ui.theme.Gray10

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PayScreen(){
    Scaffold(
        topBar = {
            BackTopBar(keyword = "결제하기")
        },
        content = { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                item { HeaderWithIcon(text = "배송 정보", icon = painterResource(id = R.drawable.up))}
                item { DeliveryInfo() }
                item { GrayLine()}
                item{ HeaderWithIcon(text = "주문 상품 정보", icon = painterResource(id = R.drawable.downicon)) }
                item { GrayLine() }
                item { HeaderWithIcon(text = "결제 수단", icon = painterResource(id = R.drawable.up))}
                item { CardSelect() }
                item { GrayLine() }
                item { FinalPay() }
                item { GrayLine() }
                item{ Agreement()}

            }
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .height(80.dp) // 크기 설정
                    .border(2.dp, Gray10),
                containerColor = Color.White

                // 테두리 설정
            ) {
                BottomButtonBar()
            }
        }
    )

}



@Preview(showBackground = true)
@Composable
fun PayScreenPreview(){
PayScreen()
}