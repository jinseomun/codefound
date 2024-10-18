package com.example.coneeze.HomePage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coneeze.R
import com.example.coneeze.ui.theme.suit

@Composable
fun CategoryItem(
    text: String,
    action: () -> Unit,
    image: Painter?
) {
    Button(
        contentPadding = PaddingValues(0.dp),
        onClick = action,
          // 내용에 맞게 버튼 크기 조정
        colors = ButtonDefaults.buttonColors(
          Color.Transparent,  // 버튼 배경을 투명하게 설정
            contentColor = Color.Unspecified ),
            // 기본 텍스트 색상 사용
        shape = RectangleShape


    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start=9.dp, end=9.dp)
                    .width(56.dp)
                    .height(56.dp)


            ) {
                // 이미지 설정
                if (image != null) {
                    Image(
                        painter = painterResource(id = R.drawable.gray),
                        contentDescription = "카테고리 사진",
                        modifier = Modifier
                            .width(56.dp)
                            .height(56.dp)

                    )


                    Image(
                        painter = image,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(1.dp)
                            .width(44.dp)
                            .height(44.dp)

                    )
                }


            }
            Spacer(modifier = Modifier.height(5.dp))

            // 텍스트 설정
            Text(
                text = text,
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF484B51),  // 텍스트 색상 설정
                    fontFamily = suit
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryPreview(){
Box(modifier = Modifier.fillMaxSize()) {

    CategoryItem(
        text = "바보",
        image = painterResource(id = R.drawable.totalcategory),  // 이미지 리소스
        action = { /* onClick 동작 */ })
}
}