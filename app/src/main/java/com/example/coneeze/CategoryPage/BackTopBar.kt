package com.example.coneeze.CategoryPage

import androidx.compose.foundation.Image
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coneeze.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BackTopBar() {
    TopAppBar(
        title = { Text(text = "") },
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        navigationIcon = {
            Row(
                modifier = Modifier
                    .padding(start=20.dp,top = 16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = "image description",

                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp)
                )
            }
        },
    )
}

@Preview
@Composable
fun BackTopBarPreview(){
    BackTopBar()
}