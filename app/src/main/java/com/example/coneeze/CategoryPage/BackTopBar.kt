package com.example.coneeze.CategoryPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coneeze.R
import com.example.coneeze.ui.theme.Black22
import com.example.coneeze.ui.theme.suit

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BackTopBar(
    keyword: String
) {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(start = 109.dp),
                verticalAlignment = Alignment.CenterVertically

            ) {
                Text(
                    text = keyword,
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 20.sp,
                        fontFamily = suit,
                        fontWeight = FontWeight(600),
                        color = Black22,
                        textAlign = TextAlign.Center,
                    )
                )
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        navigationIcon = {
            Row(
                modifier = Modifier
                    .padding(start = 20.dp, top = 16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = "image description",
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp)
                )
            }
        }
    )
}
@Preview
@Composable
fun BackTopBarPreview(){
    BackTopBar(keyword = "")}
