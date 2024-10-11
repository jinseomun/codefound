import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import com.example.coneeze.ui.theme.GrayLine
import com.example.coneeze.ui.theme.Main600
import com.example.coneeze.ui.theme.suit

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardSelect() {
    val isSelectedPurchase = remember { mutableStateOf(true) }
    val isSelectedCard = remember { mutableStateOf(false) }
    val type = remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(top = 20.dp)

        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = {
                    isSelectedPurchase.value = true
                    isSelectedCard.value = false
                    type.value = true
                },
                modifier = Modifier
                    .weight(1f)
                    .height(44.dp)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFE4E5E7)
                    ),
                shape = RoundedCornerShape(4.dp),
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

            Button(
                onClick = {
                    isSelectedPurchase.value = false
                    isSelectedCard.value = true
                    type.value = false
                },
                modifier = Modifier
                    .weight(1f)
                    .height(44.dp)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFE4E5E7)
                    ),
                shape = if (isSelectedCard.value) RectangleShape else RoundedCornerShape(4.dp),
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
