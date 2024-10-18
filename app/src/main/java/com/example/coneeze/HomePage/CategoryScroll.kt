package com.example.coneeze.HomePage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.coneeze.R

@Composable
fun CategoryScroll(navController: NavController){

    Column(

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp)
                    .height(84.dp),

                ) {
                CategoryItem(
                    text = "ALL",
                    action = { navController.navigate("카테고리") },
                    image = painterResource(id = R.drawable.totalcategory)
                )
                Spacer(modifier = Modifier.weight(1f))
                CategoryItem(
                    text = "BEANS",
                    action = { navController.navigate("카테고리") },
                    image = painterResource(id = R.drawable.coffeecategory)
                )
                Spacer(modifier = Modifier.weight(1f))
                CategoryItem(
                    text = "PRODUCTS",
                    action = { navController.navigate("카테고리") },
                    image = painterResource(id = R.drawable.teabagcategory)
                )
                Spacer(modifier = Modifier.weight(1f))
                CategoryItem(
                    text = "TOOLS",
                    action = { navController.navigate("카테고리") },
                    image = painterResource(id = R.drawable.extractcategory)
                )
            }
        }
        Spacer(modifier = Modifier.height(9.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ){ Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, bottom = 24.dp)
                .height(84.dp),

            ){
            CategoryItem(
                text = "GOODS",
                action = { navController.navigate("카테고리") },
                image = painterResource(id = R.drawable.goodscategory)
            )
            Spacer(modifier = Modifier.weight(1f))
            CategoryItem(
                text = "GIFTS",
                action = { navController.navigate("카테고리") },
                image = painterResource(id = R.drawable.presentcategory)
            )
            Spacer(modifier = Modifier.weight(1f))
            CategoryItem(
                text = "",
                action = {  },
                image = null
            )
            Spacer(modifier = Modifier.weight(1f))
            CategoryItem(
                text = "",
                action = { },
                image = null
            )
        } }
    }
}