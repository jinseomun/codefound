package com.example.coneeze.PayPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coneeze.R
import com.example.coneeze.ui.theme.All
import com.example.coneeze.ui.theme.Black30
import com.example.coneeze.ui.theme.GrayLine
import com.example.coneeze.ui.theme.RedCherry600
import com.example.coneeze.ui.theme.TapGray
import com.example.coneeze.ui.theme.suit

@Composable
fun Agreement(){
    val isChecked = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 24.dp)
    ) {

        AgreementRow()

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .border(width = 1.dp, color = GrayLine)
                .padding(1.dp)
                .width(320.dp)
                .height(0.dp)
        ) {}

        Spacer(modifier = Modifier.height(20.dp))

        AgreementDetail(text = "(필수)개인정보 수집 및 이용 동의")

        Spacer(modifier = Modifier.height(4.dp))

        AgreementDetail(text = "(필수)개인정보 제3자 정보 제공 동의")

    }
}


@Composable
fun AgreementDetail(
    text: String
){

    val isChecked = remember { mutableStateOf(false) }
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ){
        Button(
            contentPadding = PaddingValues(0.dp),
            onClick = {
                isChecked.value = !isChecked.value

            },
            // 내용에 맞게 버튼 크기 조정
            colors = ButtonDefaults.buttonColors(
                Color.Transparent,  // 버튼 배경을 투명하게 설정
                contentColor = Color.Unspecified ),
            // 기본 텍스트 색상 사용
            shape = RectangleShape



        ) {
            Image(
                painterResource(id = R.drawable.check),
                contentDescription = null,
                modifier = Modifier
                    .padding(1.dp)
                    .width(19.dp)
                    .height(19.dp),
                colorFilter = if (isChecked.value) {
                    androidx.compose.ui.graphics.ColorFilter.tint(Black30)
                } else {
                    androidx.compose.ui.graphics.ColorFilter.tint(Color.Gray)
                }
            )
        }

        Spacer(modifier = Modifier.width(4.dp))


        Text(
            text = text,

            // Body/Body3 14 R
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 18.sp,
                fontFamily = suit,
                fontWeight = FontWeight(400),
                color = All,
            )
        )
    }
}

@Composable
fun AgreementRow() {
    var isChecked by remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = { isChecked = it } // 체크박스 상태 변경
        )

        Text(
            text = "주문 내용 확인 및 결제 동의 (필수)",
            fontFamily = suit
        )



    }
}

@Preview(showBackground = true)
@Composable
fun AgreementPreview(){
    Agreement()
}