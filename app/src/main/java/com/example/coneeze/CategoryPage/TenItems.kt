package com.example.coneeze.CategoryPage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coneeze.HomePage.twobyone
import com.example.coneeze.HomePage.twobytwo
import com.example.coneeze.data.coffeImages4
import com.example.coneeze.data.coffeeImages3
import com.example.coneeze.data.features3
import com.example.coneeze.data.features4
import com.example.coneeze.data.names3
import com.example.coneeze.data.names4
import com.example.coneeze.data.prices3
import com.example.coneeze.data.prices4


@Composable
fun TenItems() {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        twobytwo(
            names = names3,
            features = features3,
            images = coffeeImages3,
            prices = prices3
        )
        Spacer(modifier = Modifier.height(24.dp))
        twobytwo(
            names = names3,
            features = features3,
            images = coffeeImages3,
            prices = prices3
        )


        Spacer(modifier = Modifier.height(24.dp))
        twobyone(
            names = names4,
            features = features4,
            images = coffeImages4,
            prices = prices4
        )

        Spacer(modifier = Modifier.height(24.dp))

    }
}


@Preview
@Composable
fun TenItemsPreview(){
    TenItems()
}