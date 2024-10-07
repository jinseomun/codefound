package com.example.coneez2.Resevepage

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.*  // 이 부분을 추가
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.Icon
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coneez2.R
import com.example.coneez2.components.CustomTopBar
import com.example.coneez2.components.NextButton


@OptIn(ExperimentalMaterial3Api::class)  // 실험적 API 사용을 명시적으로 허용
@Composable
fun SecondScreen() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CustomTopBar(
                title = "커니즈 서비스",
                showNavigationIcon = false, // 네비게이션 아이콘을 보여줌
                showActionIcon = true,    // 액션 아이콘을 숨김
                onNavigationClick = { /* 네비게이션 클릭 동작 */ },
                onActionClick = { /* 액션 버튼 클릭 동작 */ }
            )
        },
        content = { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                // 메인 콘텐츠
                ContentScreen2()
            }
        },
        bottomBar = {
            // 하단 바에 NextButton 추가
            NextButton("예약하기")
        }
    )
}

@Composable
fun ContentScreen2() {
    var selectedMode by remember { mutableStateOf("온라인") }  // 기본값은 "온라인"
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp), // 좌우 패딩을 추가
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.text_reserving2),
            contentDescription = "text",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .padding(top = 40.dp)
                .width(300.dp)
                .height(56.dp),
        )

        Spacer(modifier = Modifier.height(40.dp))

        Box (
        ){
            Column {
                // "클래스 진행 방식" 텍스트
                Text(
                    text = "클래스 진행 방식",
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
                    color = Color.Black,
                    modifier = Modifier.align(Alignment.Start)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // 온라인/오프라인 버튼
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween // 버튼들 사이에 간격 추가
                ) {
                    ModeButton(
                        title = "온라인",
                        isSelected = selectedMode == "온라인",
                        onClick = { selectedMode = "온라인" },
                        modifier = Modifier.weight(1f) // 남은 공간을 균등하게 차지

                    )

                    Spacer(modifier = Modifier.width(16.dp)) // 버튼 간 간격 설정

                    ModeButton(
                        title = "오프라인",
                        isSelected = selectedMode == "오프라인",
                        onClick = { selectedMode = "오프라인" },
                        modifier = Modifier.weight(1f) // 남은 공간을 균등하게 차지
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        // "인원수" 텍스트
        Box(
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "인원수",
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
                    color = Color.Black,
                )

                // 인원수 조절 버튼
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    PlusMinusButton()
                }
            }
        }

        // 오프라인일 경우에만 예약 일정 및 방문 주소 표시
        if (selectedMode == "오프라인"){
            OffScreen()
        }

    }
}

@Composable
fun ModeButton(title: String, isSelected: Boolean, onClick: () -> Unit,  modifier: Modifier) {
    Button(
        onClick = onClick,
        modifier = modifier
            .height(48.dp)
            .border(width = 1.dp, color = Color(0xFFE4E5E7), shape = RoundedCornerShape(4.dp)),  // 회색 테두리 추가
        shape = RoundedCornerShape(4.dp),  // 둥근 모서리 정도를 명시적으로 설정
        colors = ButtonDefaults.buttonColors(containerColor = if (isSelected) Color(0xFF644E46) else Color.White)
    ) {
        Text(
            text = title,
            color = if (isSelected) Color.White else Color.Gray,
            style = TextStyle(fontWeight = FontWeight.Bold),
            fontSize = 16.sp
        )
    }
}

//인원 변경 버튼
@Composable
fun PlusMinusButton() {
    var numberOfPeople by remember { mutableStateOf(1) }  // 기본값은 1명

    Row(
        verticalAlignment = Alignment.CenterVertically, // 수직 중앙 정렬
        modifier = Modifier
            .border(
                width = 1.dp, // 테두리 두께
                color = Color(0xFFE4E5E7), // 테두리 색상
                shape = RoundedCornerShape(4.dp) // 테두리 모서리 둥글게 설정
            )

    ) {
        Button(
            onClick = { if (numberOfPeople > 1) numberOfPeople-- },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            modifier = Modifier.width(60.dp),
            contentPadding = PaddingValues(0.dp) // 기본 패딩을 0으로 설정
        ) {
            Box(contentAlignment = Alignment.Center) {
                Image(
                    painter = painterResource(id = R.drawable.minus), // 로컬 리소스에서 아이콘 불러오기
                    contentDescription = "Minus",
                    modifier = Modifier.size(24.dp) // 아이콘 크기 설정
                )
            }
        }

        // 인원수 텍스트
        Text(
            text = "$numberOfPeople",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
        )

        Button(
            onClick = { numberOfPeople++ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent), // 배경색 설정
            modifier = Modifier.width(60.dp),
            contentPadding = PaddingValues(0.dp) // 기본 패딩을 0으로 설정
        ) {
            Box(contentAlignment = Alignment.Center) {
                Image(
                    painter = painterResource(id = R.drawable.plus), // 로컬 리소스에서 아이콘 불러오기
                    contentDescription = "Plus",
                    modifier = Modifier.size(24.dp) // 아이콘 크기 설정
                )
            }
        }
    }
}

@Composable
fun OffScreen(){
    Spacer(modifier = Modifier.height(40.dp))

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(text = "예약 일정", fontSize = 16.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .border(width = 1.dp, color = Color(0xFFE4E5E7), shape = RoundedCornerShape(4.dp)),  // 회색 테두리 추가
            shape = RoundedCornerShape(4.dp),  // 둥근 모서리 정도를 명시적으로 설정
            colors = ButtonDefaults.buttonColors(containerColor = Color.White)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween, // 좌우로 텍스트와 아이콘 배치
                verticalAlignment = Alignment.CenterVertically // 수직으로 중앙 정렬
            ) {
                Text(
                    text = "일정을 선택해 주세요.",
                    fontSize = 16.sp,
                    color = Color(0xFFAEB1B7),
                    modifier = Modifier.weight(1f) // 텍스트가 남은 공간을 차지하도록
                )

                // 아이콘 추가
                Icon(
                    painter = painterResource(id = R.drawable.calendar),  // 로컬 리소스에서 아이콘 불러오기
                    contentDescription = "Calendar Icon",
                    modifier = Modifier.size(24.dp),  // 아이콘 크기 설정
                    tint = Color(0xFFAEB1B7)  // 아이콘 색상
                )
            }        }
    }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        // 오프라인 시 방문 주소
        Text(
            text = "오프라인 시 방문 주소",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "서울시 서초구 강남대로 545-4, 8층 커니즈 교육센터", color = Color.Gray)
    }


}


@Preview(showBackground = true)
@Composable
fun Preview2() {
    SecondScreen()
}