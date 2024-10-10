package com.example.coneez2.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MonotonicFrameClock
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coneez2.components.CustomTopBar
import com.example.coneez2.ui.theme.Main600
import com.example.coneez2.ui.theme.cafeFontFamily


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupScreen(navController: NavController) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CustomTopBar(
                title = "회원가입",
                showNavigationIcon = true, // 네비게이션 아이콘을 보여줌
                showActionIcon = false,    // 액션 아이콘을 숨김
                onNavigationClick = { /* 네비게이션 클릭 동작 */ },
                onActionClick = {  }
            )
        },
        content = { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                // 메인 콘텐츠
                SignupContent()
            }

        },
        bottomBar = {
            // 하단 바에 NextButton 추가
        }
    )
}

@Composable
fun SignupContent(){
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "가입을 위해 회원 정보를 \n 입력해 주세요.",
                style = TextStyle(
                    fontFamily = cafeFontFamily,
                    fontSize = 28.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight(700),
                    color = Main600,
                )
            )
        }

        
        Inuput_Signup()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Inuput_Signup() {
    Column(
        modifier = Modifier
            .padding(horizontal = 30.dp)
            .padding(top = 30.dp)

    ) {
        Text(
            text = "아이디",
            color = Color.Gray,
            modifier = Modifier.padding(start = 8.dp)
        )
        TextField(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(text = "아이디를 입력해 주세요.", color = Color.LightGray)
            },
            modifier = Modifier
                .fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                focusedIndicatorColor = Main600,      // 포커스된 상태의 하단 바 색상
                unfocusedIndicatorColor = Color(0xFFF1F2F3)     // 포커스 해제된 상태의 하단 바 색상

            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "비밀번호",
            color = Color.Gray,
            modifier = Modifier.padding(start = 8.dp)
        )
        TextField(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(text = "비밀번호를 입력해 주세요.", color = Color.LightGray)
            },
            modifier = Modifier
                .fillMaxWidth(),

            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                focusedIndicatorColor = Main600,      // 포커스된 상태의 하단 바 색상
                unfocusedIndicatorColor = Color(0xFFF1F2F3)     // 포커스 해제된 상태의 하단 바 색상

            )
        )

        Spacer(modifier = Modifier.height(8.dp))


        TextField(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(text = "비밀번호를 한 번 더 입력해 주세요.", color = Color.LightGray)
            },
            modifier = Modifier
                .fillMaxWidth(),

            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                focusedIndicatorColor = Main600,      // 포커스된 상태의 하단 바 색상
                unfocusedIndicatorColor = Color(0xFFF1F2F3)     // 포커스 해제된 상태의 하단 바 색상


            )
        )

    }
}


@Preview(showBackground = true)
@Composable
fun PreviewSignup() {
    val navController = rememberNavController()
    SignupScreen(navController)
}
