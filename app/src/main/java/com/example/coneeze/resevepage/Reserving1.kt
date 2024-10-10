package com.example.coneeze.resevepage

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.example.coneeze.components.NextButton
import com.example.coneeze.ui.theme.Main600

@OptIn(ExperimentalMaterial3Api::class)  // 실험적 API 사용을 명시적으로 허용
@Composable
fun FirstScreen(navController: NavController) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CustomTopBar(
                title = "커니즈 서비스",
                showNavigationIcon = false, // 네비게이션 아이콘을 보여줌
                showActionIcon = true,    // 액션 아이콘을 숨김
                onNavigationClick = { /* 네비게이션 클릭 동작 */ },
                onActionClick = { navController.popBackStack("reservation", inclusive = false)  }
            )
        },
        content = { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                // 메인 콘텐츠
                ContentScreen1()
            }
        },
        bottomBar = {
            // 하단 바에 NextButton 추가
            NextButton(onClick = {navController.navigate("reserving2") }, "다음"
            )
        }
    )
}

@Composable
fun ContentScreen1(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp), // 좌우 패딩을 추가
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.text_reserving),
            contentDescription = "text",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .padding(top = 40.dp)
                .width(300.dp)
                .height(56.dp),
        )

        Spacer(modifier = Modifier.height(40.dp))

        // 여러 개의 서비스 버튼을 나열
        ServiceButton(
            title = "서비스명",
            description = "서비스 설명글입니다.서비스 설명글입니다.서비스 설명글입니다.서비스 설명글입니다.서비스 설명글입니다."
        )

        Spacer(modifier = Modifier.height(16.dp))

        ServiceButton(
            title = "서비스명",
            description = "서비스 설명글입니다.서비스 설명글입니다.서비스 설명글입니다.서비스 설명글입니다.서비스 설명글입니다."
        )

        Spacer(modifier = Modifier.height(16.dp))

        ServiceButton(
            title = "서비스명",
            description = "서비스 설명글입니다.서비스 설명글입니다.서비스 설명글입니다.서비스 설명글입니다.서비스 설명글입니다."
        )


    }
}

@Composable
fun ServiceButton(title: String, description: String) {
    var isClicked by remember { mutableStateOf(false) }

    // 버튼 클릭 이벤트 정의
    Button(
        onClick = {
            isClicked = !isClicked
        },
        modifier = Modifier
            .fillMaxWidth() // 버튼을 화면의 너비만큼 채우도록 설정
            .height(120.dp)
            .border(
                width = 1.dp,
                color = if (isClicked) Main600 else Color(0xFFf1f2f3), // 클릭 시 갈색 테두리
                shape = RoundedCornerShape(size = 8.dp)
            ),
        shape = RoundedCornerShape(size = 8.dp),
        contentPadding = PaddingValues(horizontal = 20.dp), // 버튼 안의 내용 패딩
        colors = ButtonDefaults.buttonColors(containerColor = Color.White) // 버튼 배경 흰색
    ) {
        // 버튼 내부 레이아웃
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = title,
                color = Color.Black,
                style = TextStyle(fontWeight = FontWeight.Bold),
                fontSize = 16.sp // 제목 텍스트 크기 설정
            )

            Spacer(modifier = Modifier.height(6.dp)) // 제목과 설명 사이 간격

            Text(
                text = description,
                color = Color.Gray,
                fontSize = 14.sp, // 설명 텍스트 크기 설정
                maxLines = Int.MAX_VALUE, // 텍스트를 여러 줄로 표시
                overflow = TextOverflow.Visible // 텍스트가 넘어가면 줄바꿈
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun Preview1() {
    val navController = rememberNavController()
    FirstScreen(navController = navController)
}