package com.example.coneeze.HomePage

import androidx.compose.foundation.Image

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coneeze.R
import com.example.coneeze.ui.theme.Black22
import com.example.coneeze.ui.theme.FeatureColor
import com.example.coneeze.ui.theme.Gray10
import com.example.coneeze.ui.theme.RedCherry
import com.example.coneeze.ui.theme.RedCherry50
import com.example.coneeze.ui.theme.RedCherry600
import com.example.coneeze.ui.theme.suit

@Composable
fun SaleItem(
    image: Painter,
    name : String,
    feature: String,
    percent : String,
    price : String,
    origin_price : String,
    tagCategory: String,            // Tag 관련 인자 추가
    tagBackgroundColor: Color,
    tagTextColor: Color
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp)
    ){
        Column(
            modifier = Modifier
                .padding(end=12.dp)
        ){
            Image(
                painter = image,
                contentDescription = "카테고리 사진",
                modifier = Modifier
                    .width(80.dp)
                    .height(80.dp)
            )
        }
        Column(){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 4.dp)
            ){
                Tag(
                    category= tagCategory,
                    backgrounder = tagBackgroundColor,
                    text_color = tagTextColor
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 2.dp)
            ){
                Text(
                    text = name,
// Headline/Subtitle 14 SB
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 18.sp,
                        fontFamily = suit,
                        fontWeight = FontWeight(600),
                        color = Black22,
                    )
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 4.dp)
            ){
                Text(
                    text = feature,
// Body/Caption 12 R
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        fontFamily = suit,
                        fontWeight = FontWeight(400),
                        color = FeatureColor,
                    )
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ){
                Column(
                    modifier = Modifier
                        .padding(end =2.dp)
                ){
                    Text(
                        text = percent,

                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 20.sp,
                            fontFamily = suit,
                            fontWeight = FontWeight(400),
                            color = RedCherry
                        )
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(end =2.dp)
                ){
                    Text(
                        text = price,

                        // Headline/Subtitle2 16 SB
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 20.sp,
                            fontFamily = suit,
                            fontWeight = FontWeight(600),
                            color = Black22,
                        )
                    )
                }
                Column(){
                    Text(
                        text = origin_price,
                        style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 20.sp,
                            fontFamily = suit,
                            fontWeight = FontWeight(400),
                            color = Gray10,
                            textDecoration = TextDecoration.LineThrough,
                        )
                    )
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun SaleItemPreview(){
    SaleItem(
        image = painterResource(id = R.drawable.colom_supremo),
        name ="콜롬비아 수프리모 후일라 1kg",
        feature= "은은, 허브향, 단맛",
        percent = "15%",
        price = "15,900원",
        origin_price= "18,500원",
        tagCategory= "특가",            // Tag 관련 인자 추가
        tagBackgroundColor= RedCherry50,
        tagTextColor = RedCherry600
    )
}