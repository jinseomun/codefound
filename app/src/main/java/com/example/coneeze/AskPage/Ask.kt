package com.example.coneeze.AskPage

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coneeze.DetailPage.TapMenu2
import com.example.coneeze.components.CustomTopBar
import com.example.coneeze.components.NextButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AskScreen(navController: NavController){
    Scaffold(
        topBar = {
            CustomTopBar(
                title = "",
                showNavigationIcon = true,
                showActionIcon = false,
                onNavigationClick = { navController.navigate("홈") },
                onActionClick = { /* 액션 버튼 클릭 동작 */ }
            )
        },
        content = { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {

                item { TapMenu2(first = 2) }

                item { AskHeader() }

                item { Answers()}


            }
        },
        bottomBar = {
            NextButton(onClick = { /*TODO*/ }, text = "구매하기" )
        }
    )
}



@Preview
@Composable
fun AskPagePreview(){
    val navController = rememberNavController()

    AskScreen(navController)
}