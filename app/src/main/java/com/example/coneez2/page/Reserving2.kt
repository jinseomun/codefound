package com.example.coneez2.page

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
import androidx.compose.material.icons.Icons
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
            NextButton("다음")
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
            modifier = Modifier.padding(horizontal = 10.dp)
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
            modifier = Modifier.padding(horizontal = 10.dp)
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
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    PlusMinusButton()
                }
            }
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

@Composable
fun PlusMinusButton(){
    var numberOfPeople by remember { mutableStateOf(1) }      // 기본값은 1명

    Row() {

        Button(
            onClick = { if (numberOfPeople > 1) numberOfPeople-- },
            modifier = Modifier
                .height(40.dp)
                .width(40.dp), // 버튼 크기 설정
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            shape = RoundedCornerShape(8.dp) // 둥근 모서리 설정
        ) {
            Image(
                painter = painterResource(id = R.drawable.minus), // 로컬 리소스에서 아이콘 불러오기
                contentDescription = "Minus",
                modifier = Modifier.size(24.dp) // 아이콘 크기 설정
            )
        }

        Text(
            text = "$numberOfPeople",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Button(
            onClick = { numberOfPeople++ },
            modifier = Modifier
                .height(40.dp)
                .width(40.dp), // 버튼 크기 설정
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            shape = RoundedCornerShape(8.dp) // 둥근 모서리 설정

        ) {
            Image(
                painter = painterResource(id = R.drawable.plus), // 로컬 리소스에서 아이콘 불러오기
                contentDescription = "Minus",
                modifier = Modifier.size(24.dp) // 아이콘 크기 설정
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Preview2() {
    SecondScreen()
}