package com.example.coneeze.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coneeze.R
import com.example.coneeze.ui.theme.Main600
import com.example.coneeze.ui.theme.suit
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {
    val focusManager = LocalFocusManager.current // 포커스 매니저 선언

    Scaffold(
        modifier = Modifier.clickable { focusManager.clearFocus() }, // 화면 클릭 시 키보드 내리기
        topBar = { /* 상단바 필요 시 추가 */ },
        content = { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                LoginContent(navController)
            }
        },
        bottomBar = { /* 하단 바 필요 시 추가 */ }
    )
}

@Composable
fun LoginContent(navController: NavController) {
    var showLoadingScreen by remember { mutableStateOf(false) }
    var loadingType by remember { mutableStateOf("") }

    if (showLoadingScreen) {
        // 로딩 화면 표시
        LoadingScreen(navController, loadingType) {
            showLoadingScreen = false
        }
    } else {
        // 기본 로그인 화면 표시
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(120.dp))

            // 로고 표시
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.symbol),
                    contentDescription = "Symbol Logo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.width(60.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Main Logo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.width(210.dp)
                )
            }

            Spacer(modifier = Modifier.height(60.dp))

            // 로그인 필드
            LoginField(navController)

            // 소셜 로그인 버튼 행
            LoginRow(
                onClickKakao = {
                    loadingType = "kakao"
                    showLoadingScreen = true
                },
                onClickNaver = {
                    loadingType = "naver"
                    showLoadingScreen = true
                },
                onClickGoogle = {
                    loadingType = "google"
                    showLoadingScreen = true
                },
                onClickApple = {
                    loadingType = "apple"
                    showLoadingScreen = true
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginField(navController: NavController) {
    // 아이디와 비밀번호 상태 변수 추가
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
    ) {
        Text(text = "아이디", color = Color.Gray, modifier = Modifier.padding(start = 8.dp), fontFamily = suit)
        TextField(
            value = username, // 상태 연결
            onValueChange = { username = it }, // 입력 변화 시 상태 업데이트
            placeholder = {
                Text(
                    text = "아이디를 입력해 주세요.",
                    color = Color.LightGray,
                    style = TextStyle(fontSize = 12.sp),
                    fontFamily = suit
                )
            },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Main600,
                unfocusedIndicatorColor = Color(0xFFF1F2F3)
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(text = "비밀번호", color = Color.Gray, modifier = Modifier.padding(start = 8.dp), fontFamily = suit)
        TextField(
            value = password, // 상태 연결
            onValueChange = { password = it }, // 입력 변화 시 상태 업데이트
            placeholder = {
                Text(
                    text = "비밀번호를 입력해 주세요.",
                    color = Color.LightGray,
                    style = TextStyle(fontSize = 12.sp),
                    fontFamily = suit
                )
            },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password), // 비밀번호 필드 설정
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Main600,
                unfocusedIndicatorColor = Color(0xFFF1F2F3)
            )
        )

        Spacer(modifier = Modifier.height(36.dp))

        Button(
            onClick = { navController.navigate("홈") },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(size = 4.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Main600)
        ) {
            Text(text = "로그인", color = Color.White, fontFamily = suit)
        }

        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
fun LoginRow(
    onClickKakao: () -> Unit,
    onClickNaver: () -> Unit,
    onClickGoogle: () -> Unit,
    onClickApple: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.kakao),
            contentDescription = "Kakao Login",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(65.dp)
                .clickable { onClickKakao() }
        )
        Spacer(modifier = Modifier.width(10.dp))
        Image(
            painter = painterResource(id = R.drawable.naver),
            contentDescription = "Naver Login",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(65.dp)
                .clickable { onClickNaver() }
        )
        Spacer(modifier = Modifier.width(10.dp))
        Image(
            painter = painterResource(id = R.drawable.google),
            contentDescription = "Google Login",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(65.dp)
                .clickable { onClickGoogle() }
        )
        Spacer(modifier = Modifier.width(10.dp))
        Image(
            painter = painterResource(id = R.drawable.apple),
            contentDescription = "Apple Login",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(65.dp)
                .clickable { onClickApple() }
        )
    }
}

@Composable
fun LoadingScreen(navController: NavController, loadingType: String, onLoadingComplete: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        val imageResId = when (loadingType) {
            "kakao" -> R.drawable.kakao_screen
            "naver" -> R.drawable.naver_screen
            "google" -> R.drawable.google_screen
            else -> R.drawable.apple_screen
        }

        Image(
            painter = painterResource(id = imageResId),
            contentDescription = "$loadingType Loading",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        LaunchedEffect(Unit) {
            delay(2000) // 2초 후에 홈 화면으로 전환
            navController.navigate("홈") {
                popUpTo("login_screen") { inclusive = true }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLogin() {
    val navController = rememberNavController()
    LoginScreen(navController)
}