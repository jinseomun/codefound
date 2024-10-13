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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coneeze.R
import com.example.coneeze.ui.theme.Black22
import com.example.coneeze.ui.theme.suit

@Composable
fun HeaderWithIcon(
    text: String,
    icon: Painter,
    content: @Composable () -> Unit // 드러낼 내용을 위한 content 파라미터 추가
) {
    val isClicked = remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(top = 20.dp)
    ) {
        Row(modifier = Modifier.height(30.dp)) {
            Text(
                text = text,
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

        // 클릭 시 content 표시
        if (isClicked.value) {
            Spacer(modifier = Modifier.height(8.dp))
            content()
        }
    }
}
