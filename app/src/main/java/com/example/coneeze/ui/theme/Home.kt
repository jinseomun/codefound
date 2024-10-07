package com.example.coneeze.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coneeze.R


@Composable
fun HomeScreen() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(start = 20.dp, end = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
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
                    .padding(start = 28.dp, top = 130.dp)
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
                    .padding(start = 28.dp, top = 190.dp)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp, top = 24.dp, bottom = 20.dp),

                ) {
                Image(
                    painter = painterResource(id = R.drawable.reservation),  // 이미지 리소스 설정
                    contentDescription = "배너 사진",
                    modifier = Modifier
                        .width(155.dp)
                        .height(100.dp)
                        .aspectRatio(155f / 100f)


                )
                Spacer(modifier = Modifier.weight(1f))


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
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, bottom = 24.dp)
                    .height(78.dp),

                ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(end = 10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally


                ) {
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
                Spacer(modifier = Modifier.weight(1f))
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(end = 10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally


                ) {
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
                Spacer(modifier = Modifier.weight(1f))
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(end = 10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally


                ) {
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
                Spacer(modifier = Modifier.weight(1f))
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(end = 10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally


                ) {
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
                Spacer(modifier = Modifier.weight(1f))
                Column(
                    modifier = Modifier
                        .fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally


                ) {
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

            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .background(Color(0xFFF1F2F3))
        ) {}


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
            modifier = Modifier.fillMaxWidth()

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, bottom = 24.dp)
            ) {
                val languages = listOf(
                    "브라질 산토스 NY2",
                    "인도네시아 만델링 G1 프리미엄",
                    "콜롬비아 후일라 수프리모",
                    "과테말라 안티구아 SHB",
                    "브라질 FC 세하도 파트로치니오"
                )

                val features = listOf(
                    "고소, 담백",
                    "고소, 깔끔",
                    "스모키, 코코넛",
                    "다크초콜릿, 호두",
                    "부드러움, 캐러멜"
                )
                val coffeeImages = listOf(
                    painterResource(id = R.drawable.brazil),
                    painterResource(id = R.drawable.brazilfc),
                    painterResource(id = R.drawable.guatemala),
                    painterResource(id = R.drawable.indonesia),
                    painterResource(id = R.drawable.colombia)
                )

                val prices = listOf(
                    "5,800원",
                    "9,200원",
                    "7,500원",
                    "7,500원",
                    "5,900원"
                )

                Column {
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth()
                        // LazyRow가 화면 가로로 꽉 차도록 설정
                    ) {
                        itemsIndexed(languages) { index, language ->
                            // 언어 리스트와 이미지 리스트를 매칭하여 RowItem에 전달
                            if (index < coffeeImages.size && index < features.size && index < prices.size) {
                                RowItem(
                                    name = language,
                                    image = coffeeImages[index],
                                    feature = features[index],
                                    price = prices[index]
                                )
                            }
                        }
                    }
                }


            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .background(Color(0xFFF1F2F3))
        ) {}

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
                    text = "이전 구매 상품과 유사한 상품",
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
            modifier = Modifier.fillMaxWidth()

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, bottom = 24.dp)
            ) {
                val languages = listOf(
                    "브라질 산토스 NY2",
                    "인도네시아 만델링 G1 프리미엄",
                    "콜롬비아 후일라 수프리모",
                    "과테말라 안티구아 SHB",
                    "브라질 FC 세하도 파트로치니오"
                )

                val features = listOf(
                    "고소, 담백",
                    "고소, 깔끔",
                    "스모키, 코코넛",
                    "다크초콜릿, 호두",
                    "부드러움, 캐러멜"
                )
                val coffeeImages = listOf(
                    painterResource(id = R.drawable.brazil),
                    painterResource(id = R.drawable.brazilfc),
                    painterResource(id = R.drawable.guatemala),
                    painterResource(id = R.drawable.indonesia),
                    painterResource(id = R.drawable.colombia)
                )

                val prices = listOf(
                    "5,800원",
                    "9,200원",
                    "7,500원",
                    "7,500원",
                    "5,900원"
                )

                Column {
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth()
                        // LazyRow가 화면 가로로 꽉 차도록 설정
                    ) {
                        itemsIndexed(languages) { index, language ->
                            // 언어 리스트와 이미지 리스트를 매칭하여 RowItem에 전달
                            if (index < coffeeImages.size && index < features.size && index < prices.size) {
                                RowItem(
                                    name = language,
                                    image = coffeeImages[index],
                                    feature = features[index],
                                    price = prices[index]
                                )
                            }
                        }
                    }
                }


            }

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, bottom = 20.dp)
                    .height(100.dp)
                    .background(Color(0xFFEBE5E0))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp, bottom = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally


                ) {
                    Row() {
                        Text(
                            text = "커니즈 런칭 리뷰 이벤트",
// Headline/Title2 20 EB
                            style = TextStyle(
                                fontSize = 20.sp,
                                lineHeight = 24.sp,
                                fontWeight = FontWeight(700),

                                )
                        )
                    }
                    Row() {
                        Text(
                            text = "전상품 구매 후 리뷰 작성 시 5% 적립금 증정!",
                            style = TextStyle(
                                fontSize = 16.sp,
                                lineHeight = 20.sp,
                                fontWeight = FontWeight(400),
                                textAlign = TextAlign.Center,
                            )
                        )
                    }


                }
            }


        }

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
                    text = "커니즈 추천 베스트 상품",
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
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp)
            ) {
                val images = listOf(
                    painterResource(id = R.drawable.brazil),
                    painterResource(id = R.drawable.guatemala),
                    painterResource(id = R.drawable.indonesia)
                )
                val prices = listOf(
                    "5,800원",
                    "9,200원",
                    "7,500원",
                    "7,500원",
                )

                val names = listOf(
                    "브라질 산토스 NY2",
                    "인도네시아 만델링 G1 프리미엄",
                    "콜롬비아 후일라 수프리모",
                    "과테말라 안티구아 SHB",
                )

                val features = listOf(
                    "고소, 담백",
                    "고소, 깔끔",
                    "스모키, 코코넛",
                    "다크초콜릿, 호두",

                    )

                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    // 데이터를 두 개씩 묶어 한 행에 두 개의 아이템을 배치
                    itemsIndexed(names.chunked(2)) { rowIndex, rowItems ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(16.dp) // 아이템 사이에 간격 추가
                        ) {
                            // 두 개의 ColumnItem을 한 줄에 배치
                            for (index in rowItems.indices) {
                                ColumnItem(
                                    name = rowItems[index],
                                    image = images[rowIndex * 2 + index],
                                    feature = features[rowIndex * 2 + index],
                                    price = prices[rowIndex * 2 + index]

                                )
                            }
                            // 만약 2개 미만의 아이템이 있다면, 빈 공간을 추가해 그리드 정렬 유지
                            if (rowItems.size < 2) {
                                Spacer(modifier = Modifier.weight(1f))
                            }
                        }
                        Spacer(modifier = Modifier.height(16.dp)) // 각 행 사이에 간격 추가
                    }


                }
            }


        }
    }
}

@Composable
fun RowItem(name: String, image: Painter,feature: String, price : String) {
    Card(
        modifier = Modifier
            .padding(end = 10.dp)
            .width(122.dp)
            .height(188.dp),  // 각 항목의 너비를 고정
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),

        ) {
        Column(
        ) {
            Image(
                painter = image,  // 이미지 리소스 설정
                contentDescription = "배너 사진",
                modifier = Modifier
                    .width(122.dp)
                    .height(122.dp)
            )
            Text(
                text = name,
                modifier = Modifier
                    .padding(top=8.dp),
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 18.sp,
                    fontWeight = FontWeight(600),
                    ),
                maxLines = 1,  // 한 줄로 제한
                overflow = TextOverflow.Ellipsis)

            Text(
                text = feature,

                // Body/Caption 12 R
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF60646C)
                )
            )

            Text(
                text = price,

                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight(600),

                )
            )






        }
    }
}

@Composable
fun ColumnItem(name: String, image: Painter,feature: String, price : String) {
    Card(
        modifier = Modifier
            .width(155.dp)
            .height(219.dp),  // 각 항목의 너비를 고정
        colors = CardDefaults.cardColors(
            containerColor = Color.Gray
        ),

        ) {
        Column(
        ) {
            Image(
                painter = image,  // 이미지 리소스 설정
                contentDescription = "배너 사진",
                modifier = Modifier
                    .width(155.dp)
                    .height(155.dp)
            )
            Text(
                text = name,
                modifier = Modifier
                    .padding(top=8.dp),
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 18.sp,
                    fontWeight = FontWeight(600),
                ),
                maxLines = 1,  // 한 줄로 제한
                overflow = TextOverflow.Ellipsis)

            Text(
                text = feature,

                // Body/Caption 12 R
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF60646C)
                )
            )

            Text(
                text = price,

                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight(600),

                    )
            )




        }
    }
}

@Composable
@Preview(showBackground = true)
fun HomePreview() {

    HomeScreen()
}
