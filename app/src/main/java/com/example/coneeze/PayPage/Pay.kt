package com.example.coneeze.PayPage

import CardSelect
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coneeze.DetailPage.Buy_BottomButtonBar
import com.example.coneeze.HomePage.GrayLine
import com.example.coneeze.R
import com.example.coneeze.components.CustomTopBar
import com.example.coneeze.components.NextButton
import com.example.coneeze.login.SignupScreen
import com.example.coneeze.ui.theme.Gray10

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PayScreen(navController: NavController, image: Int, name: String, price: String) {
    Scaffold(
        topBar = {
            CustomTopBar(
                title = "결제하기",
                showNavigationIcon = true, // 네비게이션 아이콘을 보여줌
                showActionIcon = false,    // 액션 아이콘을 숨김
                onNavigationClick = { navController.popBackStack()},
                onActionClick = { }
            )
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
                item { ItemInfo(image, name, price) }  // 매개변수 전달
                item { GrayLine() }
                item { HeaderWithIcon(text = "결제 수단", icon = painterResource(id = R.drawable.up))}
                item { CardSelect() }
                item { GrayLine() }
                item { FinalPay(price) }  // price 전달
                item { GrayLine() }
                item{ Agreement()}

            }
        },
        bottomBar = {

            Buy_BottomButtonBar(navController, image = image, name = name, price = price)


        }
    )
}

@Preview(showBackground = true)
@Composable
fun PayPreview2(){
    val navController = rememberNavController()
    PayScreen(navController, image = R.drawable.check_pay,name = "", price = "" )
}


