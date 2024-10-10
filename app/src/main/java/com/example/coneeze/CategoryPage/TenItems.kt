package com.example.coneeze.CategoryPage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coneeze.HomePage.twobyone
import com.example.coneeze.HomePage.twobytwo
import com.example.coneeze.data.coffeeImages3
import com.example.coneeze.data.features3
import com.example.coneeze.data.names3
import com.example.coneeze.data.prices3


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
        Spacer(modifier = Modifier.weight(1f))
        twobytwo(
            names = names3,
            features = features3,
            images = coffeeImages3,
            prices = prices3
        )


        Spacer(modifier = Modifier.weight(1f))
        twobyone(
            names = names3,
            features = features3,
            images = coffeeImages3,
            prices = prices3
        )

        Spacer(modifier = Modifier.weight(1f))

    }
}


@Preview
@Composable
fun TenItemsPreview(){
    TenItems()
}