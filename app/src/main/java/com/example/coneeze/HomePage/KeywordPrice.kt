import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coneeze.ui.theme.Main600
import com.example.coneeze.ui.theme.gray17
import com.example.coneeze.ui.theme.suit

val keyprices = listOf(
    "3만원 이하",
    "3~5만원",
    "5~10만원",
    "10만원 이상"
)

@Composable
fun KeywordPrice() {
    // 누른 버튼의 인덱스를 기억하는 상태
    var selectedIndex by remember { mutableStateOf(-1) }  // 초기값은 선택되지 않은 상태 (-1)

    Row(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)
        ) {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                // LazyRow가 화면 가로로 꽉 차도록 설정
            ) {
                itemsIndexed(keyprices) { index, keyprice ->
                    // 현재 선택된 인덱스를 상태로 전달
                    PriceButton(
                        index = index,
                        price = keyprice,
                        isSelected = (index == selectedIndex) // 현재 인덱스가 선택된 인덱스와 같은지 확인
                    ) {
                        selectedIndex = index // 버튼을 클릭하면 선택된 인덱스 변경
                    }
                }
            }
        }
    }
}

@Composable
fun PriceButton(
    index: Int,
    price: String,
    isSelected: Boolean,  // 선택 여부를 받음
    onClick: () -> Unit    // 버튼 클릭 이벤트 처리
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(end = 8.dp)
            .border(1.dp,if(isSelected) Main600 else gray17, RoundedCornerShape(50))
            .wrapContentWidth()
            .height(36.dp)
        ,
        shape = RoundedCornerShape(50),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) Main600 else Color.White,  // 선택된 경우 Main600, 기본 상태는 Gray
            contentColor = if (isSelected) Color.White else Color.Black // 선택된 경우 글자색은 흰색, 기본은 검정색
        )
    ) {
        Text(
            text = price,

            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 18.sp,
                fontFamily = suit,
                fontWeight = FontWeight(700),
                textAlign = TextAlign.Center
            )
        )
    }
}
@Preview(showBackground = true)
@Composable
fun KeywordPricePreview(){
    KeywordPrice()
}