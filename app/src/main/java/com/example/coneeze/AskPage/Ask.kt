package com.example.coneeze.AskPage

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coneeze.CategoryPage.BackTopBar
import com.example.coneeze.CategoryPage.Section
import com.example.coneeze.DetailPage.BottomButtonBar
import com.example.coneeze.DetailPage.TapMenu2
import com.example.coneeze.HomePage.GrayLine
import com.example.coneeze.HomePage.ReviewBanner
import com.example.coneeze.ReviewPage.CustomerReviews
import com.example.coneeze.ReviewPage.MoreReview
import com.example.coneeze.ReviewPage.Rating
import com.example.coneeze.ReviewPage.ReviewHeader

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AskScreen(){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                navigationIcon = {
                    BackTopBar()
                },
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
            BottomButtonBar()
        }
    )
}



@Preview
@Composable
fun AskPagePreview(){
    AskScreen()
}