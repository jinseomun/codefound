package com.example.coneeze.CategoryPage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.coneeze.HomePage.twobyone
import com.example.coneeze.HomePage.twobytwo
import com.example.coneeze.data.coffeeImages3
import com.example.coneeze.data.features3
import com.example.coneeze.data.names3
import com.example.coneeze.data.prices3

@Composable
fun TenItems(
    navController: NavController,
    names: List<String> // 첫 번째 twobytwo에 필요한 데이터만 인자로 받음
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        // 첫 번째 twobytwo에 전달된 인자를 사용
        when (names.size) {
            1 -> {
                twobyone(
                    navController = navController,
                    names = names,
                    images = coffeeImages3,
                    features = features3,
                    prices = prices3
                )
            }

            3 -> {
                twobyone(
                    navController = navController,
                    names = names.take(3), // 전달할 아이템 개수 제한
                    images = coffeeImages3.take(3),
                    features = features3.take(3),
                    prices = prices3.take(3)
                )
                Spacer(modifier = Modifier.weight(1f))

                // 두 번째 twobyone 호출 (중복 방지)
                twobyone(
                    navController = navController,
                    names = names.takeLast(1), // 필요한 만큼만 전달
                    images = coffeeImages3.takeLast(1),
                    features = features3.takeLast(1),
                    prices = prices3.takeLast(1)
                )

                Spacer(modifier = Modifier.weight(1f))

            }

            8 -> {
                // 첫 번째 twobytwo 호출
                twobytwo(
                    navController = navController,
                    names = names.take(4), // 첫 4개 아이템 전달
                    features = features3.take(4),
                    images = coffeeImages3.take(4),
                    prices = prices3.take(4)
                )

                Spacer(modifier = Modifier.weight(1f))

                // 두 번째 twobytwo 호출 (다음 4개 아이템 전달)
                twobytwo(
                    navController = navController,
                    names = names.takeLast(4), // 마지막 4개 아이템 전달
                    features = features3.takeLast(4),
                    images = coffeeImages3.takeLast(4),
                    prices = prices3.takeLast(4)
                )

                Spacer(modifier = Modifier.weight(1f))
            }
        }
    }
}
