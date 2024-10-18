package com.example.coneeze.HomePage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coneeze.data.coffeImages4
import com.example.coneeze.data.features4
import com.example.coneeze.data.names4
import com.example.coneeze.data.prices4
@Composable
fun twobyone(
    navController: NavController,
    names: List<String>,
    images: List<Int>,
    features: List<String>,
    prices: List<String>
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        // 첫 번째 아이템 렌더링
        if (names.isNotEmpty() && images.isNotEmpty() && features.isNotEmpty() && prices.isNotEmpty()) {
            HorizontalItem(
                navController = navController,
                name = names[0],
                feature = features[0],
                image = images[0],
                price = prices[0],
            )
        }

        Spacer(modifier = Modifier.width(24.dp)) // 아이템 간의 간격 유지

        // 두 번째 아이템 또는 빈 공간으로 대체
        if (names.size > 1 && images.size > 1 && features.size > 1 && prices.size > 1) {
            HorizontalItem(
                navController = navController,
                name = names[1],
                feature = features[1],
                image = images[1],
                price = prices[1],
            )
        } else {
            // 데이터가 하나만 있을 경우 빈 아이템 대체
            Box(
                modifier = Modifier
                    .width(150.dp) // HorizontalItem과 동일한 너비
                    .padding(8.dp)
            ) {
                // 빈 박스 또는 플레이스홀더 (디자인에 맞게 추가 가능)
            }
        }
    }
    Spacer(modifier = Modifier.height(24.dp))
}


@Preview(showBackground = true)
@Composable
fun twobyonePreview(){
    twobyone(navController = rememberNavController(), names = names4 , images = coffeImages4, features = features4, prices = prices4)
}