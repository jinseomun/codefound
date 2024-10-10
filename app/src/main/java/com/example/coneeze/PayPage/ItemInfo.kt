package com.example.coneeze.PayPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coneeze.R
import com.example.coneeze.ui.theme.Black22
import com.example.coneeze.ui.theme.suit

@Composable
fun ItemInfo(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 24.dp)
    ) {

        Row(modifier = Modifier.height(20.dp)) {
            Text(
                text = "주문 상품 정보",

                // Headline/Subtitle2 16 SB
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    fontFamily = suit,
                    fontWeight = FontWeight(600),
                    color = Black22,
                )
            )
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painterResource(id = R.drawable.downicon),
                contentDescription = null,
                modifier = Modifier
                    .padding(1.dp)
                    .width(24.dp)
                    .height(24.dp)
            )


        }
    }
}


@Preview(showBackground = true)
@Composable
fun ItemInfoPreview(){
    ItemInfo()
}