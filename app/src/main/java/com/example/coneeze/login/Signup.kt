



package com.example.coneeze.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coneeze.components.CustomTopBar
import com.example.coneeze.ui.theme.Main600
import com.example.coneeze.ui.theme.cafeFontFamily
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType
import com.example.coneeze.components.NextButton


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
                onNavigationClick = {navController.navigate("로그인") },
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
            NextButton(onClick = { navController.navigate("홈")  }, text = "회원가입")
        }
    )
}

@Composable
fun SignupContent() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top=44.dp),
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
        }

        item { Inuput_Signup() }
        item { PrivacyAgreementRow() }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Inuput_Signup() {
    Column(
        modifier = Modifier
            .padding(horizontal = 28.dp)
            .padding(top = 20.dp)

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
                Text(
                    text = "아이디를 입력해 주세요.",
                    color = Color.LightGray,
                    style = TextStyle(fontSize = 12.sp),
                )
            },
            modifier = Modifier
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),

            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Main600,       // 포커스된 상태의 하단 바 색상
                unfocusedIndicatorColor = Color(0xFFF1F2F3)  // 포커스 해제된 상태의 하단 바 색상
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "비밀번호",
            color = Color.Gray,
            modifier = Modifier.padding(start = 8.dp)
        )
        TextField(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(
                    text = "비밀번호를 입력해 주세요.",
                    color = Color.LightGray,
                    style = TextStyle(fontSize = 12.sp),
                )
            },
            modifier = Modifier
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),

            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Main600,       // 포커스된 상태의 하단 바 색상
                unfocusedIndicatorColor = Color(0xFFF1F2F3)  // 포커스 해제된 상태의 하단 바 색상
            )
        )

        Spacer(modifier = Modifier.height(8.dp))


        TextField(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(
                    text = "비밀번호를 한번 더 입력해 주세요.",
                    color = Color.LightGray,
                    style = TextStyle(fontSize = 12.sp)

                    )
            },
            modifier = Modifier
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),

            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Main600,       // 포커스된 상태의 하단 바 색상
                unfocusedIndicatorColor = Color(0xFFF1F2F3)  // 포커스 해제된 상태의 하단 바 색상
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "이름",
            color = Color.Gray,
            modifier = Modifier.padding(start = 8.dp)
        )
        TextField(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(
                    text = "이름을 입력해 주세요.",
                    color = Color.LightGray,
                    style = TextStyle(fontSize = 12.sp),
                )
            },
            modifier = Modifier
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Main600,       // 포커스된 상태의 하단 바 색상
                unfocusedIndicatorColor = Color(0xFFF1F2F3)  // 포커스 해제된 상태의 하단 바 색상
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "연락처",
            color = Color.Gray,
            modifier = Modifier.padding(start = 8.dp)
        )
        TextField(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(
                    text = "연락처를 입력해 주세요.",
                    color = Color.LightGray,
                    style = TextStyle(fontSize = 12.sp),
                )
            },
            modifier = Modifier
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),

            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Main600,       // 포커스된 상태의 하단 바 색상
                unfocusedIndicatorColor = Color(0xFFF1F2F3)  // 포커스 해제된 상태의 하단 바 색상
            )
        )
    }
}

@Composable
fun PrivacyAgreementRow() {
    var isChecked by remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 18.dp)
    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = { isChecked = it } // 체크박스 상태 변경
        )

        Text(
            text = "[필수] 개인정보처리방침에 동의합니다.",
        )

        Spacer(modifier = Modifier.width(24.dp))


        Text(
            text = "약관보기",
            color = Color(0xFF60646C),
            textDecoration = TextDecoration.Underline, // 밑줄 추가
            modifier = Modifier.clickable { /* 약관보기 동작 추가 */ }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSignup() {
    val navController = rememberNavController()
    SignupScreen(navController)
}
