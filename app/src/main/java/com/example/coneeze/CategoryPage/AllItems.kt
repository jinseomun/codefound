package com.example.coneeze.CategoryPage

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coneeze.ui.theme.Black22
import com.example.coneeze.ui.theme.NumberGray
import com.example.coneeze.ui.theme.suit


@Composable
fun AllItems(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(68.dp)
            .padding(start = 20.dp, top = 24.dp, end = 20.dp, bottom = 24.dp)
    ) {
        Text(
            text = "전체 상품",

            // Headline/Subtitle2 16 SB
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 20.sp,
                fontFamily = suit,
                fontWeight = FontWeight(600),
                color = Black22,
            )
        )
        Spacer(modifier = Modifier.width(4.dp))

        Text(
            text = "10",

            // Headline/Subtitle2 16 SB
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 20.sp,
                fontFamily = suit,
                fontWeight = FontWeight(600),
                color = NumberGray,
            )
        )

    }
}


@Preview (showBackground = true)
@Composable
fun AllItemsPreview(){
AllItems()
}