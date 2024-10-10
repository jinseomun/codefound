package com.example.coneeze.HomePage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coneeze.R

@Composable
fun ReserveTest(){
Row(
modifier = Modifier
.fillMaxWidth()
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 30.dp, end = 30.dp, top = 24.dp, bottom = 20.dp),

        ) {
        Button(
            contentPadding = PaddingValues(0.dp),
            onClick = {},
            // 내용에 맞게 버튼 크기 조정
            colors = ButtonDefaults.buttonColors(
                Color.Transparent,  // 버튼 배경을 투명하게 설정
                contentColor = Color.Unspecified ),
            // 기본 텍스트 색상 사용
            shape = RectangleShape



        ){
        Image(
            painter = painterResource(id = R.drawable.reservation),  // 이미지 리소스 설정
            contentDescription = "에약하기 사진",
            modifier = Modifier
                .width(155.dp)
                .height(100.dp)
                .aspectRatio(155f / 100f)


        )}
        Spacer(modifier = Modifier.weight(1f))
        Button(
            contentPadding = PaddingValues(0.dp),
            onClick = {},
            // 내용에 맞게 버튼 크기 조정
            colors = ButtonDefaults.buttonColors(
                Color.Transparent,  // 버튼 배경을 투명하게 설정
                contentColor = Color.Unspecified ),
            // 기본 텍스트 색상 사용
            shape = RectangleShape



        ){

        Image(
            painter = painterResource(id = R.drawable.test),  // 이미지 리소스 설정
            contentDescription = "테스트하기 사진",
            modifier = Modifier
                .width(155.dp)
                .height(100.dp)

        )}
    }
}
}

@Preview
@Composable
fun ReserveTestPreview(){
    ReserveTest()
}


