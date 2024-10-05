package com.example.coneeze.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coneeze.R

@Composable
fun HomeScreen(

){
    Column(
        modifier = Modifier
        .fillMaxSize()){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(start = 20.dp, end = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                painter = painterResource(id = R.drawable.logo),  // 이미지 리소스 설정
                contentDescription = "커니즈 로고",
                modifier = Modifier
                    .width(137.dp)
                    .height(24.dp)
            )
        }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.grandma),  // 이미지 리소스 설정
                    contentDescription = "배너 사진",
                    modifier = Modifier
                        .fillMaxWidth() //가로 꽉 채우면 늘어나서
                        .aspectRatio(2942f / 1961f) // 그에 맞춰서 세로 크기도 늘리기
                )
                Text(
                    text = "에티오피아 고산지대의\n향기로움을 맛보세요",
                    style = TextStyle(
                        fontSize = 22.sp,
                        lineHeight = 28.sp,
                        fontWeight = FontWeight(800),
                        color = Color(0xFFFFFFFF),
                        ),
                    modifier = Modifier
                        .padding(start=28.dp, top = 130.dp)
                )
                Text(
                    text = "에티오피아 예가체프 G1",
// Body/Body3 14 R
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 18.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFFFFFFFF),
                        ),
                    modifier = Modifier
                        .padding(start = 28.dp, top=190.dp)
                )
            }

        Row(
            modifier = Modifier
            .fillMaxWidth()
           ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, top = 24.dp,bottom = 20.dp),

            ){ Image(
                painter = painterResource(id = R.drawable.reservation),  // 이미지 리소스 설정
                contentDescription = "배너 사진",
                modifier = Modifier
                    .width(155.dp)
                    .height(100.dp)
                    .aspectRatio(155f / 100f)
                    .padding(end=10.dp)

            )

                Image(
                    painter = painterResource(id = R.drawable.test),  // 이미지 리소스 설정
                    contentDescription = "배너 사진",
                    modifier = Modifier
                        .width(155.dp)
                        .height(100.dp)

                )

            }

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start=20.dp,end=20.dp, bottom = 24.dp)
                .height(78.dp)
        ){
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(end=10.dp),
                horizontalAlignment = Alignment.CenterHorizontally


            ){
            Image(
                painter = painterResource(id = R.drawable.gray),  // 이미지 리소스 설정
                contentDescription = "배너 사진",
                modifier = Modifier
                    .width(56.dp)
                    .height(56.dp)
            )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "전체",
// Body/Caption 12 R
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF484B51),
                    )
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(end=10.dp),
                horizontalAlignment = Alignment.CenterHorizontally


            ){
                Image(
                    painter = painterResource(id = R.drawable.gray),  // 이미지 리소스 설정
                    contentDescription = "배너 사진",
                    modifier = Modifier
                        .width(56.dp)
                        .height(56.dp)
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "전체",
// Body/Caption 12 R
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF484B51),
                    )
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(end=10.dp),
                horizontalAlignment = Alignment.CenterHorizontally


            ){
                Image(
                    painter = painterResource(id = R.drawable.gray),  // 이미지 리소스 설정
                    contentDescription = "배너 사진",
                    modifier = Modifier
                        .width(56.dp)
                        .height(56.dp)
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "전체",
// Body/Caption 12 R
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF484B51),
                    )
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(end=10.dp),
                horizontalAlignment = Alignment.CenterHorizontally


            ){
                Image(
                    painter = painterResource(id = R.drawable.gray),  // 이미지 리소스 설정
                    contentDescription = "배너 사진",
                    modifier = Modifier
                        .width(56.dp)
                        .height(56.dp)
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "전체",
// Body/Caption 12 R
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF484B51),
                    )
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally


            ){
                Image(
                    painter = painterResource(id = R.drawable.gray),  // 이미지 리소스 설정
                    contentDescription = "배너 사진",
                    modifier = Modifier
                        .width(56.dp)
                        .height(56.dp)
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "전체",
// Body/Caption 12 R
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF484B51),
                    )
                )
            }

        }}

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .background(Color(0xFFF1F2F3))
        ){}


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
            text = "홍길동 님의 취향에 맞는 커피예요",
// Headline/Title3 18 EB
            style = TextStyle(
                fontSize = 18.sp,
                lineHeight = 22.sp,
                fontWeight = FontWeight(700),

                )
        )
    }

}

        Row(
            modifier=Modifier
            .fillMaxWidth()){
Row(modifier = Modifier
    .fillMaxWidth()
    .padding(start=20.dp, bottom = 24.dp)){

}
        }




        }
       }


@Composable
@Preview(showBackground = true)
fun HomePreview(){
    HomeScreen()
}