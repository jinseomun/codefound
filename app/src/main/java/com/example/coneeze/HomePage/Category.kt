package com.example.coneeze.HomePage

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.coneeze.R

@Composable
fun Category(){
Row(
modifier = Modifier
.fillMaxWidth()
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, bottom = 24.dp)
            .height(78.dp),

        ) {
        CategoryItem(
            text = "전체",
            action = { /*TODO*/ },
            image = painterResource(id = R.drawable.gray)
        )
        Spacer(modifier = Modifier.weight(1f))
        CategoryItem(
            text = "전체",
            action = { /*TODO*/ },
            image = painterResource(id = R.drawable.gray)
        )
        Spacer(modifier = Modifier.weight(1f))
        CategoryItem(
            text = "전체",
            action = { /*TODO*/ },
            image = painterResource(id = R.drawable.gray)
        )
        Spacer(modifier = Modifier.weight(1f))
        CategoryItem(
            text = "전체",
            action = { /*TODO*/ },
            image = painterResource(id = R.drawable.gray)
        )
        Spacer(modifier = Modifier.weight(1f))
        CategoryItem(
            text = "전체",
            action = { /*TODO*/ },
            image = painterResource(id = R.drawable.gray)
        )


    }
}
}