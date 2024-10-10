package com.example.coneeze.DetailPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coneeze.R
import com.example.coneeze.ui.theme.Gray10
import com.example.coneeze.ui.theme.Main600
import com.example.coneeze.ui.theme.suit

@Composable
fun BottomButtonBar(){
    BottomAppBar(
        modifier = Modifier
            .height(80.dp) // 크기 설정
            .border(2.dp, Gray10),
        containerColor = Color.White

        // 테두리 설정
    ) {
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                Color.Transparent,  // 버튼 배경을 투명하게 설정
                contentColor = Color.Unspecified ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .background(color = Main600, shape = RoundedCornerShape(size = 4.dp)),
            shape = RectangleShape
        ){

            Text(
                text = "구매하기",

                // Button/Button2 14 B
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 18.sp,
                    fontFamily = suit,
                    fontWeight = FontWeight(700),
                    color = Color.White,
                    textAlign = TextAlign.Center,
                )
            )
        }
    }
}

@Preview
@Composable
fun BottomButtonBarPreview(){
    BottomButtonBar()
}