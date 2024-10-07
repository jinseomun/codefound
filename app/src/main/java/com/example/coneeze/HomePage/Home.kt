package com.example.coneeze.HomePage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coneeze.R
import com.example.coneeze.ui.theme.Main600
import com.example.coneeze.ui.theme.surround


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
                    color = Color.White,
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
                    color = Color.White,
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
                Category(text = "전체", action = { /*TODO*/ }, image = painterResource(id = R.drawable.gray) )
                Spacer(modifier = Modifier.weight(1f))
                Category(text = "전체", action = { /*TODO*/ }, image = painterResource(id = R.drawable.gray) )
                Spacer(modifier = Modifier.weight(1f))
                Category(text = "전체", action = { /*TODO*/ }, image = painterResource(id = R.drawable.gray) )
                Spacer(modifier = Modifier.weight(1f))
                Category(text = "전체", action = { /*TODO*/ }, image = painterResource(id = R.drawable.gray) )
                Spacer(modifier = Modifier.weight(1f))
                Category(text = "전체", action = { /*TODO*/ }, image = painterResource(id = R.drawable.gray) )


                }

            }


       GrayLine()

        Header("홍길동 님의 취향에 맞는 커피예요")

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

        GrayLine()

        Header("이전 구매 상품과 유사한 상품")

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

        ReviewBanner()

        Header("커니즈 추천 베스트 상품")

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
                    painterResource(id = R.drawable.guatemala),
                    painterResource(id = R.drawable.arabica),
                    painterResource(id = R.drawable.ethi_co),
                    painterResource(id = R.drawable.ethi_ari)
                )
                val prices = listOf(
                    "8,300원",
                    "7,900원",
                    "11,200원",
                    "16,800원",
                )

                val names = listOf(
                    "과테말라 안티구아 SHB",
                    "100 아라비카 블렌딩 롱로이",
                    "에티오피아 코케허니 예가체프 G1 스페셜티",
                    "에티오피아 아리차 내추럴 예가체프 G1 스페셜티",

                )

                val features = listOf(
                    "다크 초콜릿",
                    "산미, 감귤",
                    "고소, 견과류",
                    "산미, 감귤",

                    )

                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    // 데이터를 두 개씩 묶어 한 줄에 두 개의 아이템을 배치
                    itemsIndexed(names.chunked(2)) { rowIndex, rowItems ->
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            verticalArrangement = Arrangement.spacedBy(24.dp) // 각 아이템 사이에 간격 추가
                        ) {
                            // 두 개의 ColumnItem을 한 열에 배치
                            for (index in rowItems.indices) {
                                ColumnItem(
                                    name = rowItems[index],
                                    image = images[rowIndex * 2 + index],
                                    feature = features[rowIndex * 2 + index],
                                    price = prices[rowIndex * 2 + index]
                                )
                            }
                            // 각 열 사이에 간격 추가
                        }
                    }
                }
            }


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
            containerColor = Color.White
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
