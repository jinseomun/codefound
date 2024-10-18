package com.example.coneeze.CategoryPage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coneeze.data.TapNames1
import com.example.coneeze.ui.theme.Main600
import com.example.coneeze.ui.theme.TapGray
import com.example.coneeze.ui.theme.suit

@Composable
fun TapMenu1(
    datas: List<String>,
    onItemClick: (Int) -> Unit // 인덱스에 따라 호출할 함수를 전달
) {
    var selectedIndex by remember { mutableStateOf(0) }

    Row(modifier = Modifier.fillMaxWidth()) {
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
                .background(color = Color.White)
                .padding(horizontal = 16.dp)
        ) {
            itemsIndexed(datas) { index, keyprice ->
                TapMenuButton(
                    index = index,
                    MenuName = keyprice,
                    isSelected = (index == selectedIndex)
                ) {
                    selectedIndex = index
                    onItemClick(index) // 클릭 시 전달된 함수 호출
                }
            }
        }
    }
}

@Composable
fun TapMenuButton(
    index: Int,
    MenuName: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        contentPadding = PaddingValues(0.dp),
        modifier = Modifier
            .wrapContentWidth()
            .padding(end = 12.dp)
            .height(52.dp),
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = if (isSelected) Main600 else TapGray
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .drawBehind {
                    val lineY = size.height
                    drawLine(
                        color = if (isSelected) Main600 else Color.White,
                        start = Offset(0f, lineY),
                        end = Offset(size.width, lineY),
                        strokeWidth = 2.dp.toPx()
                    )
                }
                .padding(horizontal = 4.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = MenuName,
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    fontFamily = suit,
                    fontWeight = FontWeight(700)
                ),
                textAlign = TextAlign.Center
            )
        }
    }
}
