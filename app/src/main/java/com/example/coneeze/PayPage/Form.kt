package com.example.coneeze.PayPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coneeze.R
import com.example.coneeze.ui.theme.gray17
import com.example.coneeze.ui.theme.suit

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Form(
    type: Boolean
){
if(type) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .border(width = 1.dp, color = gray17, shape = RoundedCornerShape(size = 4.dp)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "입금하실 은행을 선택해 주세요.",

            // Body/Body3 14 R
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 18.sp,
                fontFamily = suit,
                fontWeight = FontWeight(400),
                color = gray17,
            ),
            modifier = Modifier
                .padding(start = 16.dp, top = 14.dp, bottom = 14.dp)
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

    Spacer(modifier = Modifier.height(12.dp))

    val textState = remember { mutableStateOf("") }

    TextField(
        value = textState.value,
        onValueChange = { textState.value = it },
        modifier = Modifier
            .fillMaxWidth()
            .border(width = 1.dp, color = gray17, shape = RoundedCornerShape(size = 4.dp))
            .height(48.dp),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            focusedIndicatorColor = Color.Transparent, // 포커스 시 하단 선 제거
            unfocusedIndicatorColor = Color.Transparent, // 비포커스 시 하단 선 제거
            disabledIndicatorColor = Color.Transparent, // 비활성화 시 하단 선 제거
            errorIndicatorColor = Color.Transparent,
        ),
        label = {
            Text(
                text = "입금자명을 입력해 주세요.",

                // Body/Body3 14 R
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 18.sp,
                    fontFamily = suit,
                    fontWeight = FontWeight(400),
                    color = gray17,
                ),

                )
        } // 텍스트 필드에 레이블 추가
    )
}

    else{
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .border(width = 1.dp, color = gray17, shape = RoundedCornerShape(size = 4.dp)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "카드사를 선택해 주세요.",

            // Body/Body3 14 R
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 18.sp,
                fontFamily = suit,
                fontWeight = FontWeight(400),
                color = gray17,
            ),
            modifier = Modifier
                .padding(start = 16.dp, top = 14.dp, bottom = 14.dp)
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

    Spacer(modifier = Modifier.height(12.dp))

    val textState = remember { mutableStateOf("") }

    TextField(
        value = textState.value,
        onValueChange = { textState.value = it },
        modifier = Modifier
            .fillMaxWidth()
            .border(width = 1.dp, color = gray17, shape = RoundedCornerShape(size = 4.dp))
            .height(48.dp),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            focusedIndicatorColor = Color.Transparent, // 포커스 시 하단 선 제거
            unfocusedIndicatorColor = Color.Transparent, // 비포커스 시 하단 선 제거
            disabledIndicatorColor = Color.Transparent, // 비활성화 시 하단 선 제거
            errorIndicatorColor = Color.Transparent,
        ),
        label = {
            Text(
                text = "할부를 선택해 주세요.",

                // Body/Body3 14 R
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 18.sp,
                    fontFamily = suit,
                    fontWeight = FontWeight(400),
                    color = gray17,
                ),

                )
        } // 텍스트 필드에 레이블 추가
    )
}

    }



