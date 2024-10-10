package com.example.coneeze.DetailPage

import android.inputmethodservice.Keyboard
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.coneeze.R

@Composable
fun DetailExplain(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ){
        Image(
            painterResource(id = R.drawable.kenya_explain),
            contentDescription = null
        )
    }
}

@Preview
@Composable
fun DetailExplainPreview(){
    DetailExplain()
}