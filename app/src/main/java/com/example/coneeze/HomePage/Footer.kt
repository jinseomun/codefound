package com.example.coneeze.HomePage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import com.example.coneeze.ui.theme.FooterGray
import com.example.coneeze.ui.theme.suit

@Composable
fun Footer(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(146.dp)
            .background(com.example.coneeze.ui.theme.GrayLine)
            .padding(start = 20.dp, top = 24.dp, end = 20.dp, bottom = 24.dp)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom=2.dp)
        ){
            Column(
                modifier = Modifier
                    .padding(end=2.dp)
            ){
                Text(
                    text = "(주)이비앤엘커피컴퍼니",

                    // Body/Caption 12 R
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        fontFamily = suit,
                        fontWeight = FontWeight(400),
                        color = FooterGray,
                    )
                )
            }
            Column(
                modifier = Modifier.padding(end=2.dp)
            ){
                Text(
                    text = "|",

                    // Body/Caption 12 R
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        fontFamily = suit,
                        fontWeight = FontWeight(400),
                        color = FooterGray,
                    )
                )
            }
            Column(){
                Text(
                    text = "대표 : 최은비",

                    // Body/Caption 12 R
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        fontFamily = suit,
                        fontWeight = FontWeight(400),
                        color = FooterGray,
                    )
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom=2.dp)
        ){
            Text(
                text = "경기도 안산시 단원구 라성로 16 , 106동 1103호",

                // Body/Caption 12 R
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    fontFamily = suit,
                    fontWeight = FontWeight(400),
                    color = FooterGray,
                )
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom=12.dp)
        ){
            Text(
                text = "사업자등록번호 : 729-87-03069",

                // Body/Caption 12 R
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    fontFamily = suit,
                    fontWeight = FontWeight(400),
                    color = FooterGray,
                )
            )
        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom=2.dp)
        ){
            Column(
                modifier = Modifier
                    .padding(end=2.dp)
            ){
                Text(
                    text = "고객센터 : 0507-1332-9623",

                    // Body/Caption 12 R
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        fontFamily = suit,
                        fontWeight = FontWeight(400),
                        color = FooterGray,
                    )
                )
            }
            Column(
                modifier = Modifier.padding(end=2.dp)
            ){
                Text(
                    text = "|",

                    // Body/Caption 12 R
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        fontFamily = suit,
                        fontWeight = FontWeight(400),
                        color = FooterGray,
                    )
                )
            }
            Column(){
                Text(
                    text = "evnlcompany@naver.com",

                    // Body/Caption 12 R
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        fontFamily = suit,
                        fontWeight = FontWeight(400),
                        color = FooterGray,
                    )
                )
            }
        }
        Row(){
            Text(
                text = "운영시간 : 평일 09:00 - 18:00",

                // Body/Caption 12 R
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    fontFamily = suit,
                    fontWeight = FontWeight(400),
                    color = FooterGray,
                )
            )
        }
    }
}

@Preview
@Composable
fun FooterPreview(){
    Footer()
}