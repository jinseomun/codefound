package com.example.coneeze.ReviewPage

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coneeze.CategoryPage.BackTopBar
import com.example.coneeze.CategoryPage.Section
import com.example.coneeze.DetailPage.BottomButtonBar
import com.example.coneeze.DetailPage.DetailExplain
import com.example.coneeze.DetailPage.DetailInfo
import com.example.coneeze.DetailPage.TapMenu2
import com.example.coneeze.HomePage.BottomIconRow
import com.example.coneeze.HomePage.GrayLine
import com.example.coneeze.HomePage.ReviewBanner
import com.example.coneeze.data.TapNames2
import com.example.coneeze.ui.theme.Gray10

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReviewScreen(){
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

                item { TapMenu2(first = 1) }

                item { Section("별점", "")}

                item { Rating() }

                item { ReviewBanner() }

                item { GrayLine()}

                item { ReviewHeader() }

                item{ CustomerReviews()}

                item{ MoreReview() }


            }
        },
        bottomBar = {
            BottomButtonBar()
        }
    )
}





@Preview
@Composable
fun ReviewScreenPreview(){
ReviewScreen()
}