package com.example.coneeze.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
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
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val focusManager = LocalFocusManager.current // 포커스 매니저 선언

    Scaffold(modifier = Modifier
        .nestedScroll(scrollBehavior.nestedScrollConnection)
        .clickable { focusManager.clearFocus() }, // 화면을 클릭하면 키보드 내리기
        topBar = {},
        content = { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                // 메인 콘텐츠
                LoginContent(navController)
            }
        },
        bottomBar = {
            // 하단 바에 NextButton 추가
        }
    )
}

@Composable
fun LoginContent(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(120.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.symbol),
                    contentDescription = "logo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.width(60.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))

                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "logo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.width(210.dp)
                )
            }

            Spacer(modifier = Modifier.height(60.dp))

            LoginField(navController)

            LoginRow(navController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginField(navController: NavController) {
    val focusManager = LocalFocusManager.current

    // 아이디와 비밀번호의 상태를 저장할 변수를 추가
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 20.dp)
        ) {
            Text(
                text = "아이디",
                color = Color.Gray,
                modifier = Modifier.padding(start = 8.dp),
                style = TextStyle(fontFamily = suit)
            )
            TextField(value = username,
                onValueChange = { username = it },
                placeholder = {
                    Text(
                        text = "아이디를 입력해 주세요.",
                        color = Color.LightGray,
                        style = TextStyle(fontSize = 12.sp, fontFamily = suit)
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { focusManager.clearFocus() }, // 화면 터치 시 키보드 내림
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Main600,
                    unfocusedIndicatorColor = Color(0xFFF1F2F3)
                )
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "비밀번호",
                color = Color.Gray,
                modifier = Modifier.padding(start = 8.dp),
                style = TextStyle(fontFamily = suit)
            )
            TextField(value = password,
                onValueChange = { password = it },
                placeholder = {
                    Text(
                        text = "비밀번호를 입력해 주세요.",
                        color = Color.LightGray,
                        style = TextStyle(fontSize = 12.sp, fontFamily = suit)
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { focusManager.clearFocus() },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
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
                Text(
                    text = "로그인", color = Color.White, style = TextStyle(fontFamily = suit)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
            ) {
                TextButton(onClick = { /* 아이디 찾기 */ }) {
                    Text(
                        "아이디 찾기", color = Color.Gray, style = TextStyle(
                            fontSize = 12.sp, fontFamily = suit
                        )
                    )
                }
                Divider(
                    color = Color.Gray, modifier = Modifier
                        .height(15.dp)
                        .width(1.dp)
                )
                TextButton(onClick = { /* 비밀번호 재설정 */ }) {
                    Text("비밀번호 재설정", color = Color.Gray, style = TextStyle(fontSize = 12.sp))
                }
                Divider(
                    color = Color.Gray, modifier = Modifier
                        .height(15.dp)
                        .width(1.dp)
                )
                TextButton(onClick = { navController.navigate("회원가입") }) {
                    Text("회원가입", color = Color.Gray, style = TextStyle(fontSize = 12.sp))
                }
            }
        }
    }
}

@Composable
fun LoginRow(navController: NavController) {

    var kakaoImage by remember { mutableStateOf(false) }
    var naverImage by remember { mutableStateOf(false) }
    var googleImage by remember { mutableStateOf(false) }
    var appleImage by remember { mutableStateOf(false) }

    Column {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(painter = painterResource(id = R.drawable.kakao),
                contentDescription = "logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(65.dp)
                    .clickable {
                        kakaoImage = true // 로딩 이미지 표시
                    })

            Spacer(modifier = Modifier.width(10.dp))

            Image(painter = painterResource(id = R.drawable.naver),
                contentDescription = "logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(65.dp)
                    .clickable {
                        naverImage = true // 로딩 이미지 표시
                    })

            Spacer(modifier = Modifier.width(10.dp))

            Image(painter = painterResource(id = R.drawable.google),
                contentDescription = "logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(65.dp)
                    .clickable {
                        googleImage = true // 로딩 이미지 표시
                    })

            Spacer(modifier = Modifier.width(10.dp))

            Image(painter = painterResource(id = R.drawable.apple),
                contentDescription = "logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(65.dp)
                    .clickable {
                        appleImage = true // 로딩 이미지 표시
                    })
        }

        Spacer(modifier = Modifier.height(40.dp))

        if (kakaoImage) {
            Box(
                modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.kakao_screen), // 보여줄 이미지
                    contentDescription = "Kakao Loading", contentScale = ContentScale.Crop
                )

                LaunchedEffect(Unit) {
                    delay(2000) // 2초 딜레이
                    navController.navigate("홈") {
                        popUpTo("login_screen") { inclusive = true }
                    }
                    kakaoImage = false // 상태 초기화 (필요시)
                }
            }
        }

        if (naverImage) {
            Box(
                modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.naver_screen), // 보여줄 이미지
                    contentDescription = "Kakao Loading", contentScale = ContentScale.Crop
                )

                LaunchedEffect(Unit) {
                    delay(2000) // 2초 딜레이
                    navController.navigate("홈") {
                        popUpTo("login_screen") { inclusive = true }
                    }
                    naverImage = false // 상태 초기화 (필요시)
                }
            }
        }
        if (googleImage) {
            Box(
                modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.google_screen), // 보여줄 이미지
                    contentDescription = "Kakao Loading", contentScale = ContentScale.Crop
                )

                LaunchedEffect(Unit) {
                    delay(2000) // 2초 딜레이
                    navController.navigate("홈") {
                        popUpTo("login_screen") { inclusive = true }
                    }
                    googleImage = false // 상태 초기화 (필요시)
                }
            }

            if (appleImage) {
                Box(
                    modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.apple_screen), // 보여줄 이미지
                        contentDescription = "Kakao Loading", contentScale = ContentScale.Crop
                    )

                    LaunchedEffect(Unit) {
                        delay(2000) // 2초 딜레이
                        navController.navigate("홈") {
                            popUpTo("login_screen") { inclusive = true }
                        }
                        appleImage = false // 상태 초기화 (필요시)
                    }
                }
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun Previewlogin() {
    val navController = rememberNavController()
    LoginScreen(navController)
}