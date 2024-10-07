package com.example.coneez2.Testingpage

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import com.example.coneez2.Resevepage.FirstScreen
import com.example.coneez2.components.CustomTopBar

@OptIn(ExperimentalMaterial3Api::class)  // 실험적 API 사용을 명시적으로 허용
@Composable
fun TestScreen(modifier: Modifier = Modifier) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CustomTopBar(
                title = "셀프테스트",
                showNavigationIcon = true, // 네비게이션 아이콘을 보여줌
                showActionIcon = false,    // 액션 아이콘을 숨김
                onNavigationClick = { /* 네비게이션 클릭 동작 */ },
                onActionClick = { /* 액션 버튼 클릭 동작 */ }
            )
        },
        content = { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                // 메인 콘텐츠
                TestContent()
            }

        },
        bottomBar = {
            // 하단 바에 NextButton 추가
        }
    )
}

@Composable
fun TestContent(){

}

@Preview(showBackground = true)
@Composable
fun PreviewTest() {
    TestScreen()
}