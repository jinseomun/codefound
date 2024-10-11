package com.example.coneeze.PayPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coneeze.R
import com.example.coneeze.ui.theme.All
import com.example.coneeze.ui.theme.Black22
import com.example.coneeze.ui.theme.FeatureColor
import com.example.coneeze.ui.theme.suit
@Composable
fun ItemInfo(image: Int, name: String, price: String) {
    val isClicked = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 24.dp)
    ) {

        Row(modifier = Modifier.height(20.dp)) {
            Text(
                text = "주문 상품 정보",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    fontFamily = suit,
                    fontWeight = FontWeight(600),
                    color = Black22,
                )
            )
            Spacer(modifier = Modifier.weight(1f))

            Button(
                contentPadding = PaddingValues(0.dp),
                onClick = { isClicked.value = !isClicked.value },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.Unspecified
                ),
                shape = RectangleShape,
                modifier = Modifier
                    .width(24.dp)
                    .height(24.dp)
            ) {
                Image(
                    painterResource(
                        id = if (!isClicked.value) R.drawable.downicon else R.drawable.up
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(1.dp)
                        .width(24.dp)
                        .height(24.dp)
                )
            }
        }

        if (isClicked.value) {
            Spacer(modifier = Modifier.height(24.dp))

            Row(modifier = Modifier.fillMaxWidth()) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                ) {
                    Row {
                        Image(
                            painterResource(id = image),
                            contentDescription = "배너 사진",
                            modifier = Modifier
                                .width(80.dp)
                                .height(80.dp)
                                .clip(RoundedCornerShape(6.dp))
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text(
                                text = name,
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    lineHeight = 18.sp,
                                    fontFamily = suit,
                                    fontWeight = FontWeight(400),
                                    color = All,
                                )
                            )
                            Spacer(modifier = Modifier.height(2.dp))

                            Row {
                                Text(
                                    text = "200g",
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        lineHeight = 16.sp,
                                        fontFamily = suit,
                                        fontWeight = FontWeight(400),
                                        color = FeatureColor,
                                    )
                                )

                                Spacer(modifier = Modifier.width(2.dp))

                                Text(
                                    text = "/",
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        lineHeight = 16.sp,
                                        fontFamily = suit,
                                        fontWeight = FontWeight(400),
                                        color = FeatureColor,
                                    )
                                )

                                Spacer(modifier = Modifier.width(2.dp))

                                Text(
                                    text = "1개",
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        lineHeight = 16.sp,
                                        fontFamily = suit,
                                        fontWeight = FontWeight(400),
                                        color = FeatureColor,
                                    )
                                )
                            }

                            Spacer(modifier = Modifier.height(2.dp))

                            Text(
                                text = price,
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    lineHeight = 18.sp,
                                    fontFamily = suit,
                                    fontWeight = FontWeight(600),
                                    color = FeatureColor,
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}

