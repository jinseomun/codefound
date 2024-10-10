package com.example.coneeze.DetailPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coneeze.R
import com.example.coneeze.ui.theme.Black30
import com.example.coneeze.ui.theme.Gray600
import com.example.coneeze.ui.theme.GrayLine
import com.example.coneeze.ui.theme.NumberGray
import com.example.coneeze.ui.theme.suit
@Composable
fun DetailInfo() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        // 상단 이미지
        Image(
            painter = painterResource(id = R.drawable.kenya),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
        )


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 24.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                // 제품명 텍스트
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "케냐 AA PLUS 아이히더 프리미엄",
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 20.sp,
                            fontFamily = suit,
                            fontWeight = FontWeight(600),
                            color = Black30,
                        )
                    )
                }
            }

                Spacer(modifier = Modifier.height(8.dp))

                // 별점 Row (5개의 별을 반복)

                Row(
                    horizontalArrangement = Arrangement.Center,  // 가로 중앙 정렬
                    verticalAlignment = Alignment.CenterVertically  // 세로 중앙 정렬
                ) {
                    repeat(5) {
                        Image(
                            painter = painterResource(id = R.drawable.yellow_star),
                            contentDescription = "star",
                            modifier = Modifier
                                .width(12.dp)
                                .height(12.dp)
                                .padding(1.dp),
                            colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(Black30)// 별 사이에 간격 추가
                        )
                    }

                    Spacer(modifier = Modifier.width(4.dp))

                    Text(
                        text = "12개 리뷰 보기",
                        style = TextStyle(
                            fontSize = 12.sp,
                            lineHeight = 16.sp,
                            fontFamily = suit,
                            fontWeight = FontWeight(400),
                            color = Gray600,
                            textDecoration = TextDecoration.Underline,
                        )
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "12,700원",
                        style = TextStyle(
                            fontSize = 18.sp,
                            lineHeight = 22.sp,
                            fontFamily = suit,
                            fontWeight = FontWeight(700),
                            color = Black30,
                        )
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    modifier = Modifier
                        .border(width = 1.dp, color = GrayLine)
                        .padding(1.dp)
                        .fillMaxWidth()
                        .height(0.dp)
                ) {}

                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column() {
                        Text(
                            text = "배송정보",

                            // Headline/Subtitle 14 SB
                            style = TextStyle(
                                fontSize = 14.sp,
                                lineHeight = 18.sp,
                                fontFamily = suit,
                                fontWeight = FontWeight(600),
                                color = NumberGray,
                            ),
                            modifier = Modifier.width(72.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(12.dp))
                    Column() {
                        Text(
                            text = "CJ 대한통운\n배송비 3,000원\n제주도, 도서산간 배송비 별도",

                            // Body/Body3 14 R
                            style = TextStyle(
                                fontSize = 14.sp,
                                lineHeight = 18.sp,
                                fontFamily = suit,
                                fontWeight = FontWeight(400),
                                color = Gray600,
                            )
                        )
                    }
                }
                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column() {
                            Text(
                                text = "교환 및 환불",

                                // Headline/Subtitle 14 SB
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    lineHeight = 18.sp,
                                    fontFamily = suit,
                                    fontWeight = FontWeight(600),
                                    color = NumberGray,
                                ),
                                modifier = Modifier.width(72.dp)
                            )
                        }

                        Spacer(modifier = Modifier.width(12.dp))
                        Column() {
                            Text(
                                text = "배송 완료 시점에서 7일 이내\n불량 상품 외 단순 교환 및 환불 시 배송비 소비자 부담",

                                // Body/Body3 14 R
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    lineHeight = 18.sp,
                                    fontFamily = suit,
                                    fontWeight = FontWeight(400),
                                    color = Gray600,
                                )
                            )
                        }
                    }

                }
            }
        }


@Preview(showBackground = true)
@Composable
fun DetailInfoPreview() {
    DetailInfo()
}