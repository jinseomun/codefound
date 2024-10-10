package com.example.coneeze.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.example.coneeze.R

@OptIn(ExperimentalMaterial3Api::class)  // 실험적 API 사용을 명시적으로 허용
@Composable
fun CustomTopBar(
    title: String,
    showNavigationIcon: Boolean = true,  // 네비게이션 아이콘 표시 여부
    showActionIcon: Boolean = true,      // 액션 아이콘 표시 여부
    onNavigationClick: () -> Unit = {},  // 네비게이션 아이콘 클릭 동작
    onActionClick: () -> Unit = {}       // 액션 버튼 클릭 동작
) {
    Column {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = title,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = TextStyle(
                        fontSize = 16.sp, // 텍스트 크기
                        lineHeight = 20.sp, // 줄 높이
                        fontWeight = FontWeight.W600, // 폰트 두께, 600은 W600으로 표기
                        color = Color(0xFF000000), // 텍스트 색상, 예시로 검정색
                        textAlign = TextAlign.Center, // 텍스트 가운데 정렬
                    ),
                )
            },
            navigationIcon = {
                // 네비게이션 아이콘을 조건적으로 표시
                if (showNavigationIcon) {
                    IconButton(onClick = onNavigationClick) {
                        Icon(
                            imageVector = Icons.Filled.KeyboardArrowLeft,  // 네비게이션 아이콘 (왼쪽 아이콘)
                            contentDescription = "Back",
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }
            },
            actions = {
                // 액션 아이콘을 조건적으로 표시
                if (showActionIcon) {
                    IconButton(onClick = onActionClick) {
                        Icon(
                            imageVector = Icons.Filled.Close,  // 액션 버튼 (오른쪽 아이콘)
                            contentDescription = "Close",
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }
            }
        )
        Divider(color = Color(0xFFF1F2F3), thickness = 1.dp)  // 하단에 회색 구분선 추가
    }
}

@Composable
fun TopLogo() {
    Column {
        Box(
            Modifier
                .fillMaxWidth()
                .height(56.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Image(
                painter = painterResource(id = R.drawable.coneez_logo),
                contentDescription = "poster",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(start = 20.dp)
                    .height(24.dp)
            )
        }
        Divider(color = Color(0xFFF1F2F3), thickness = 1.dp)  // 하단에 회색 구분선 추가
    }
}
