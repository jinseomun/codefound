package com.example.coneeze.components
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coneeze.ui.theme.suit
import java.time.LocalDate
import java.time.YearMonth


@Composable
fun CustomCalendar(
    onDateSelected: (LocalDate) -> Unit
) {
    // 현재 월과 선택된 날짜를 저장하는 상태 변수
    var currentMonth by remember { mutableStateOf(YearMonth.now()) }
    var selectedDate by remember { mutableStateOf<LocalDate?>(null) }

    // 월과 요일 정보 계산
    val firstDayOfMonth = currentMonth.atDay(1)
    val daysInMonth = currentMonth.lengthOfMonth()
    val startDayOffset = firstDayOfMonth.dayOfWeek.value % 7
    val daysInPreviousMonth = currentMonth.minusMonths(1).lengthOfMonth()

    // 달력 UI
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFFFFFF))
            .padding(horizontal = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally


    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp, bottom = 36.dp)
        ) {
            Text(
                text = "〈",
                fontSize = 20.sp,
                modifier = Modifier
                    .weight(1f)
                    .clickable {
                        currentMonth = currentMonth.minusMonths(1)
                        selectedDate = null // 월이 변경되면 선택 초기화
                    },
                textAlign = TextAlign.Center // 중앙 정렬
            )
            Text(
                text = "${currentMonth.year}년 ${currentMonth.monthValue}월",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(3f),
                textAlign = TextAlign.Center,
                style = TextStyle(fontFamily = suit)
            )
            Text(
                text = "〉",
                fontSize = 20.sp,
                modifier = Modifier
                    .weight(1f)
                    .clickable {
                        currentMonth = currentMonth.plusMonths(1)
                        selectedDate = null // 월이 변경되면 선택 초기화
                    },
                textAlign = TextAlign.Center // 중앙 정렬
            )
        }


        // 요일 헤더 표시
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            listOf("일", "월", "화", "수", "목", "금", "토").forEach { day ->
                Text(
                    text = day,
                    fontSize = 16.sp,
                    color = if (day == "일") Color.Red else Color.Gray,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f),
                    style = TextStyle( fontFamily = suit)
                )
            }
        }

        // 날짜 표시
        // 날짜 표시
        var weekHasNextMonthDays = false // 마지막 줄 표시 여부를 위한 변수

        // 날짜 표시
        for (week in 0 until 6) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                for (day in 0..6) {
                    val dateIndex = week * 7 + day
                    val dateText: String
                    val date: LocalDate? // 클릭 가능한 날짜 객체
                    val color: Color
                    val isFaded: Boolean

                    when {
                        // 이전 달의 날짜
                        dateIndex < startDayOffset -> {
                            dateText = (daysInPreviousMonth - startDayOffset + dateIndex + 1).toString()
                            color = Color.Gray
                            isFaded = true
                            date = null // 클릭 불가 날짜
                        }
                        // 현재 달의 날짜
                        dateIndex - startDayOffset < daysInMonth -> {
                            val dayOfMonth = dateIndex - startDayOffset + 1
                            dateText = dayOfMonth.toString()
                            color = if (day == 0) Color.Red else Color.Black
                            isFaded = false
                            date = currentMonth.atDay(dayOfMonth) // 클릭 가능한 날짜

                            // 30일이 토요일일 경우 다음 달 날짜 표시 중단
                            if (dayOfMonth == 30 && day == 6) {
                                weekHasNextMonthDays = true
                            }
                        }
                        // 다음 달의 날짜 (한 주 내에서만 표시)
                        else -> {
                            dateText = (dateIndex - startDayOffset - daysInMonth + 1).toString()
                            color = Color.Gray
                            isFaded = true
                            date = null // 클릭 불가 날짜
                            weekHasNextMonthDays = true
                        }
                    }

                    // 날짜 버튼 구현
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f) // 정사각형 비율을 유지
                            .background(
                                color = if (selectedDate != null && selectedDate == date) Color.LightGray else Color.Transparent,
                                shape = CircleShape
                            )
                            .clickable {
                                if (date != null && date.month == currentMonth.month) {
                                    selectedDate = date
                                    onDateSelected(date) // 콜백 호출 추가
                                }
                            }
                    ) {
                        Text(
                            text = dateText,
                            fontSize = 16.sp,
                            color = color.copy(alpha = if (isFaded) 0.5f else 1f),
                            textAlign = TextAlign.Center,
                            style = TextStyle(fontFamily = suit)
                        )
                    }
                }
            }

            // 다음 달 날짜가 표시된 주 이후에는 그리기를 중단
            if (weekHasNextMonthDays) break
        }


        //            text = selectedDate?.let {
        //              "${it.year}년 ${it.monthValue}월 ${it.dayOfMonth}일"
        //          } ?: "날짜를 선택하세요",

    }
}

