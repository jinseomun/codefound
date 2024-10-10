package com.example.coneeze.DetailPage

import android.inputmethodservice.Keyboard
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coneeze.CategoryPage.Section
import com.example.coneeze.R

@Composable
fun DetailExplain(){
    Column(
        modifier = Modifier.fillMaxWidth()
    ){
        Section( text = "상품 상세", number = "")

        DetailExplainImage()
    }
}

@Composable
fun DetailExplainImage(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ){
        Image(
            painterResource(id = R.drawable.kenya_explain),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(320f / 1200f)
        )
    }
}

@Preview(showBackground = true, heightDp = 1700)
@Composable
fun DetailExplainPreview(){
    DetailExplain()
}