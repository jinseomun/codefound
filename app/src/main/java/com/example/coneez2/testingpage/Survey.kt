package com.example.coneez2.testingpage

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.coneez2.components.PrevNextButton
import com.example.coneez2.ui.theme.Main600
import com.example.coneez2.ui.theme.cafeFontFamily

@OptIn(ExperimentalMaterial3Api::class)  // 실험적 API 사용을 명시적으로 허용
@Composable
fun SurveyScreen(navController: NavController) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    val questions = listOf(
        "나는 커피에서 신맛(산미)이\n 나는 것을 좋아한다.",
        "커피는 강하고\n 묵직한 맛이 있어야 한다.",
        "나는 뒷맛이 깔끔한\n 커피를 좋아한다.",
        "나는 밤에 커피를 마셔도\n 잠이 잘 온다.",
        "나는 차 (Tea)처럼\n 부드러운 맛의\n 커피를 좋아한다.",
        "나는 평소 입맛이\n 까다로운 편이다.",
        "나는 한식보다\n 양식이 더 좋다.",
        "나는 따뜻한 커피보다\n 아이스 커피를 선호한다.",
        "나는 매운 음식을\n 잘 먹는 편이다.",
        "나는 새로운 도전을\n 좋아하는 성격이다."
    )

    var currentQuestionIndex by remember { mutableIntStateOf(0) }  // 현재 질문 인덱스 상태


    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CustomTopBar(
                title = "${currentQuestionIndex + 1}/${questions.size}",
                showNavigationIcon = false, // 네비게이션 아이콘을 보여줌
                showActionIcon = true,    // 액션 아이콘을 숨김
                onNavigationClick = { /* 네비게이션 클릭 동작 */ },
                onActionClick = { navController.navigate("teststart") }
            )
        },
        content = { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                // 메인 콘텐츠
                SurveyContent(
                    questions = questions,
                    currentQuestionIndex = currentQuestionIndex,
                )
            }

        },
        bottomBar = {
            // 하단 바에 NextButton 추가
                if (currentQuestionIndex == questions.size - 1) {
                    // 마지막 질문에서는 "결과보기" 버튼만 표시
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp, horizontal = 20.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Button(
                            onClick = { navController.navigate("result")  },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp),
                            shape = RoundedCornerShape(size = 4.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Main600)
                        ) {
                            Text(
                                text = "결과보기",
                                color = Color.White,
                                style = TextStyle(fontWeight = FontWeight.Bold),
                                fontSize = 14.sp
                            )
                        }
                    }
                } else {
                    // 마지막 질문이 아닐 때만 "이전"과 "다음" 버튼 표시
                    PrevNextButton(
                        onPrevClick = { if (currentQuestionIndex > 0) currentQuestionIndex-- },
                        onNextClick = { currentQuestionIndex++ },
                        isPrevEnabled = currentQuestionIndex > 0,
                        isNextEnabled = true
                    )
                }
        }
    )
}

@Composable
fun SurveyContent(
    questions: List<String>,
    currentQuestionIndex: Int,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .padding(horizontal = 25.dp)
                .padding(top = 60.dp, bottom = 50.dp)
        ) {
            Text(
                text = questions[currentQuestionIndex],
                style = TextStyle(
                    fontFamily = cafeFontFamily,
                    fontSize = 28.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight(700),
                    color = Main600,),
                )

        }

        // 선택지들
        Column {
            SurveyButton(onClick = { /* 선택지 클릭 시 처리 */ }, text = "매우 그렇다")
            SurveyButton(onClick = { /* 선택지 클릭 시 처리 */ }, text = "그렇다")
            SurveyButton(onClick = { /* 선택지 클릭 시 처리 */ }, text = "아니다")
            SurveyButton(onClick = { /* 선택지 클릭 시 처리 */ }, text = "매우 아니다")
        }


    }
}

@Composable
fun SurveyButton(
    onClick: () -> Unit,
    text: String
) {
    var isSelected by remember { mutableStateOf(false) } // 클릭 상태를 추적하는 변수

    Button(
        onClick = {
            isSelected = !isSelected  // 클릭할 때마다 상태 변경
            onClick()  // 추가적으로 onClick 동작 수행
        },
        modifier = Modifier
            .padding(bottom = 16.dp)
            .padding(horizontal = 25.dp)
            .fillMaxWidth()
            .height(60.dp)
            .border(
                width = 1.dp,
                color = if (isSelected) Main600 else Color(0xFFE4E5E7),  // 상태에 따른 색상
                shape = RoundedCornerShape(4.dp)
            ),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 14.sp,
                color = Color.Black
            )
        )
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewSurvey() {
    val navController = rememberNavController()
    SurveyScreen(navController)
}