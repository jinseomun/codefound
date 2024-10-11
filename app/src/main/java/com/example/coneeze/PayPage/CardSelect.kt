import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coneeze.PayPage.Form
import com.example.coneeze.ui.theme.Black22
import com.example.coneeze.ui.theme.Main600
import com.example.coneeze.ui.theme.suit

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardSelect() {
    // 상태를 관리하는 변수: 첫 번째 버튼 선택 여부
    val isSelectedPurchase = remember { mutableStateOf(true) }  // 기본적으로 구매하기 버튼이 선택됨
    val isSelectedCard = remember { mutableStateOf(false) }
    val type = remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally, // 가로 중앙 정렬
        verticalArrangement = Arrangement.Center
    ) {
        Row() {
            Button(
                onClick = {
                    // 구매하기 버튼을 클릭하면 이 버튼이 선택됨
                    isSelectedPurchase.value = true
                    isSelectedCard.value = false

                    type.value = true
                },
                modifier = Modifier
                    .width(204.dp)
                    .height(40.dp)
                    .padding(horizontal = 20.dp)
                    .background(
                        color = if (isSelectedPurchase.value) Main600 else Color.Transparent,
                        shape = RoundedCornerShape(size = 4.dp)
                    ),

                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isSelectedPurchase.value) Main600 else Color.Transparent,
                    contentColor = if (isSelectedPurchase.value) Color.White else Black22
                )
            ) {
                Text(
                    text = "가상계좌",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 18.sp,
                        fontFamily = suit,
                        fontWeight = FontWeight(700),
                        color = if (isSelectedPurchase.value) Color.White else Black22,
                        textAlign = TextAlign.Center,
                    )
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = {
                    // 신용카드 버튼을 클릭하면 이 버튼이 선택됨
                    isSelectedPurchase.value = false
                    isSelectedCard.value = true

                    type.value = false
                },
                modifier = Modifier
                    .width(204.dp)
                    .height(40.dp)
                    .padding(horizontal = 20.dp)
                    .background(
                        color = if (isSelectedCard.value) Main600 else Color.Transparent,
                        shape = RoundedCornerShape(size = 4.dp)
                    ),
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isSelectedCard.value) Main600 else Color.Transparent,
                    contentColor = if (isSelectedCard.value) Color.White else Black22
                )
            ) {
                Text(
                    text = "신용카드",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 18.sp,
                        fontFamily = suit,
                        fontWeight = FontWeight(700),
                        color = if (isSelectedCard.value) Color.White else Black22,
                        textAlign = TextAlign.Center,
                    )
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Form(type.value)

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
@Preview(showBackground = true)
fun CardSelectPreview() {
    CardSelect()
}
