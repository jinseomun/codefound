package com.example.coneeze.HomePage

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coneeze.ui.theme.Main600
import com.example.coneeze.ui.theme.surround


@Composable
fun Header(
    text: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, top = 24.dp, bottom = 16.dp)
        ) {
            Text(
                text = text,
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 22.sp,
                    fontFamily = surround,
                    fontWeight = FontWeight(700),
                    color = Main600

                )
            )
        }

    }
}

@Preview
@Composable
fun HeaderPreiview(){
    Header("벌써 월요일..")
}