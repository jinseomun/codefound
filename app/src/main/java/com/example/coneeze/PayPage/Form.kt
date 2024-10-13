package com.example.coneeze.PayPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coneeze.R
import com.example.coneeze.ui.theme.GrayLine
import com.example.coneeze.ui.theme.Main600
import com.example.coneeze.ui.theme.gray17
import com.example.coneeze.ui.theme.suit

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Form(
    type: Boolean
) {

    var text by remember { mutableStateOf("") } // text 상태 변수 추가

    if (type) {
        Column {
            CustomRowWithIcon(
                text = "입금하실 은행을 선택해 주세요.",
                showIcon = true  // 아이콘을 표시
            )

            Spacer(modifier = Modifier.height(16.dp))

            CustomRowWithIcon(
                text = "입금자명을 확인해 주세요.",
                showIcon = false // 아이콘을 숨김
            )
        }
    } else {
        Column {
            CustomRowWithIcon(
                text = "카드사를 선택해 주세요.",
                showIcon = true  // 아이콘을 표시
            )

            Spacer(modifier = Modifier.height(16.dp))

            CustomRowWithIcon(
                text = "할부를 선택해 주세요",
                showIcon = true// 아이콘을 숨김
            )
        }
    }

}


@Composable
fun CustomRowWithIcon(
    text: String,
    showIcon: Boolean = true,     // 아이콘을 표시할지 여부를 결정하는 매개변수
    iconColor: Color = Color.Gray // 아이콘 색상 조절
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .border(width = 1.dp, color = Color.LightGray, shape = RoundedCornerShape(size = 4.dp)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 18.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Gray,
                fontFamily = suit
            ),
            modifier = Modifier
                .padding(start = 16.dp)
        )

        if (showIcon) { // showIcon이 true일 때만 아이콘 표시
            Icon(
                imageVector = Icons.Filled.KeyboardArrowDown,
                contentDescription = "toggle",
                tint = iconColor,
                modifier = Modifier
                    .size(36.dp)
                    .padding(end = 12.dp)
            )
        }
    }
}