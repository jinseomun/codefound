package com.example.coneez2.testingpage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coneez2.components.CustomTopBar
import com.example.coneez2.components.SurveyfinButton
import com.example.coneez2.ui.theme.Main600
import com.example.coneez2.ui.theme.cafeFontFamily

@OptIn(ExperimentalMaterial3Api::class)  // 실험적 API 사용을 명시적으로 허용
@Composable
fun ResultScreen(navController: NavController) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CustomTopBar(
                title = "결과",
                showNavigationIcon = false, // 네비게이션 아이콘을 보여줌
                showActionIcon = false,    // 액션 아이콘을 숨김
                onNavigationClick = { /* 네비게이션 클릭 동작 */ },
                onActionClick = { /* 액션 버튼 클릭 동작 */ }
            )
        },
        content = { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                // 메인 콘텐츠
                ResultContent()
            }
        },
        bottomBar = {
            // 하단 바에 NextButton 추가
            SurveyfinButton(
                text1 = "다시하기",
                text2 = "더 많은 커피 보러가기",
                onText1Click = { navController.navigate("teststart")},
            ) {
                
            }

        }
    )
}

@Composable
fun ResultContent(){

    Column(
        modifier = Modifier
            .padding(top = 48.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.TopCenter
        ) {
            Text(
                text = "홍길동 님의 커피 취향은",
                style = TextStyle(
                    fontFamily = cafeFontFamily,
                    fontSize = 28.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight(700),
                    color = Main600,
                ),
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Box(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
                .height(160.dp)
                .background(color = Color(0xFFF1F2F3)),

        ){}

        Box(
            modifier = Modifier
                .padding(top = 40.dp)
                .padding(horizontal = 20.dp)
                .fillMaxWidth(),
        ) {
            Text(
                text = " 홍길동 님의 취향에 맞는 커피는?",
                style = TextStyle(
                    fontFamily = cafeFontFamily,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight(700),
                    color = Main600,
                ),
            )

        }



    }

}


@Preview(showBackground = true)
@Composable
fun PreviewResult() {
    val navController = rememberNavController()
    ResultScreen(navController)
}
