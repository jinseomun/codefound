package com.example.coneez2.resevepage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coneez2.R
import com.example.coneez2.components.CustomCalendar
import com.example.coneez2.components.CustomTopBar
import com.example.coneez2.components.NextButton
import com.example.coneez2.components.ScrollableButton
import com.example.coneez2.ui.theme.Main600
import com.example.coneez2.ui.theme.Main800
import com.example.coneez2.ui.theme.cafeFontFamily
import kotlinx.coroutines.launch



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondScreenWithModalBottomSheet(navController: NavController) {
    var isBottomSheetVisible by remember { mutableStateOf(false) }
    var isPopupVisible by remember { mutableStateOf(false) } // 팝업 표시 여부
    val scope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    Box(modifier = Modifier.fillMaxSize()) {
        // ContentScreen2를 항상 표시
        Scaffold(
            topBar = {
                CustomTopBar(
                    title = "커니즈 서비스",
                    showNavigationIcon = false,
                    showActionIcon = true,
                    onNavigationClick = { /* 네비게이션 클릭 동작 */ },
                    onActionClick = { navController.popBackStack("reservation", inclusive = false) }
                )
            },
            content = { innerPadding ->
                Column(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                ) {
                    // 메인 콘텐츠
                    Box(modifier = Modifier.weight(1f)) {
                        ContentScreen2(
                            onSelectDateClicked = {
                                isBottomSheetVisible = true // 버튼 클릭 시 ModalBottomSheet 표시
                            }
                        )
                    }
                    // NextButton을 하단에 배치
                    NextButton(
                        onClick = { isPopupVisible = true},
                        "예약하기"
                    )
                }
            }
        )

        // 예약 완료 팝업
        if (isPopupVisible) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.5f)) // 반투명 배경
                    .clickable { isPopupVisible = false }, // 클릭 시 팝업 닫기
                contentAlignment = Alignment.Center
            ) {
                Card(
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .width(320.dp)
                        .height(210.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White, // 원하는 배경색 설정
                    ),

                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Spacer(modifier = Modifier.height(30.dp))

                        Image(
                            painter = painterResource(id = R.drawable.check_circle),
                            contentDescription = "완료 아이콘",
                            modifier = Modifier.size(48.dp)
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = "예약이 완료되었습니다.",
                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                color = Main800,
                                fontFamily = cafeFontFamily,
                            ),
                            textAlign = TextAlign.Center
                        )

                        Spacer(modifier = Modifier.height(24.dp))

                        Button(
                            onClick = { navController.navigate("reservation")  },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp)
                                .height(48.dp)
                                .border(width = 1.dp, color = Color(0xFFE4E5E7), shape = RoundedCornerShape(4.dp)),  // 회색 테두리 추가
                            shape = RoundedCornerShape(4.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Main600)
                        ) {
                            Text(
                                text = "확인",
                                color = Color.White,
                                style = TextStyle(fontWeight = FontWeight.Bold)
                            )
                        }
                    }
                }
            }
        }

        // ModalBottomSheet를 독립적으로 표시
        if (isBottomSheetVisible) {
            ModalBottomSheet(
                onDismissRequest = { isBottomSheetVisible = false },
                sheetState = sheetState,
                containerColor = Color.White,
                scrimColor = Color.Black.copy(alpha = 0.3f), // 투명도 30%로 설정

            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.White)
                ) {

                    // 달력 (CustomCalendar 컴포저블 호출)
                    CustomCalendar(
                        onDateSelected = { selectedDate ->
                            scope.launch { sheetState.hide() }
                            isBottomSheetVisible = false // 날짜 선택 후 ModalBottomSheet 닫기
                        }
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Divider 추가
                    Divider(
                        color = Color(0xFFE4E5E7),
                        thickness = 1.dp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp))

                    Spacer(modifier = Modifier.height(24.dp))

                    Text(
                        text = "시간 선택",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        ),
                        modifier = Modifier.padding(horizontal = 24.dp)
                    )

                    Spacer(modifier = Modifier.height(4.dp))


                    ScrollableButtonRow_time()

                    Spacer(modifier = Modifier.height(36.dp))

                    SheetButtonRow(onClose = { isBottomSheetVisible = false })

                    Spacer(modifier = Modifier.height(36.dp))

                }
            }
        }
    }
}

@Composable
fun ContentScreen2(onSelectDateClicked: () -> Unit) {
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
                        modifier = Modifier.weight(1f)
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    ModeButton(
                        title = "오프라인",
                        isSelected = selectedMode == "오프라인",
                        onClick = { selectedMode = "오프라인" },
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        // "인원수" 텍스트
        Box {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "인원수",
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
                    color = Color.Black,
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    PlusMinusButton()
                }
            }
        }

        if (selectedMode == "오프라인"){
            OffScreen(onSelectDateClicked)
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
fun OffScreen(onSelectDateClicked: () -> Unit) {
    Spacer(modifier = Modifier.height(40.dp))

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(text = "예약 일정", fontSize = 16.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onSelectDateClicked,
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
            }
        }
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

@Composable
fun ScrollableButtonRow_time() {
    val selectedButton = remember { mutableStateOf("") }

    // Horizontal scroll state
    val scrollState = rememberScrollState()

    // Row with horizontal scroll enabled
    Row(
        modifier = Modifier
            .horizontalScroll(scrollState) // Row가 좌우로 스크롤 가능하도록 설정
            .padding(horizontal = 20.dp, vertical = 8.dp)
    ) {
        ScrollableButton("10:00", selectedButton, fontSize = 16)
        Spacer(modifier = Modifier.width(8.dp))
        ScrollableButton("10:30", selectedButton, fontSize = 16)
        Spacer(modifier = Modifier.width(8.dp))
        ScrollableButton("11:00", selectedButton, fontSize = 16)
        Spacer(modifier = Modifier.width(8.dp))
        ScrollableButton("11:30", selectedButton, fontSize = 16)
        Spacer(modifier = Modifier.width(8.dp))
        ScrollableButton("12:00", selectedButton, fontSize = 16)
    }
}

@Composable
fun SheetButtonRow(onClose: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween // 버튼들 사이에 간격 추가
    ) {
        Button(
            onClick = { onClose() }, // 닫기 버튼 클릭 시 onClose 호출
            modifier = Modifier
                .height(54.dp)
                .weight(1f)
                .border(
                    width = 1.dp,
                    color = Main600,
                    shape = RoundedCornerShape(4.dp)
                ),  // 회색 테두리 추가
            shape = RoundedCornerShape(4.dp),  // 둥근 모서리 정도를 명시적으로 설정
            colors = ButtonDefaults.buttonColors(containerColor = Color.White)
        ) {
            Text(
                text = "닫기",
                color = Main600,
                style = TextStyle(fontWeight = FontWeight.Bold),
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Button(
            onClick = { onClose() }, // 확인 버튼 클릭 시 onClose 호출
            modifier = Modifier
                .height(54.dp)
                .weight(1f)
                .border(
                    width = 1.dp,
                    color = Main600,
                    shape = RoundedCornerShape(4.dp)
                ),  // 회색 테두리 추가
            shape = RoundedCornerShape(4.dp),  // 둥근 모서리 정도를 명시적으로 설정
            colors = ButtonDefaults.buttonColors(containerColor = Main600)
        ) {
            Text(
                text = "확인",
                color = Color.White,
                style = TextStyle(fontWeight = FontWeight.Bold),
                fontSize = 16.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview2() {
    val navController = rememberNavController()
    SecondScreenWithModalBottomSheet(navController = navController)
}