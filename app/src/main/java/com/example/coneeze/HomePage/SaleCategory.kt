package com.example.coneeze.HomePage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.example.coneeze.data.SaleImages
import com.example.coneeze.data.tags
import com.example.coneeze.data.tagbackgroundColors
import com.example.coneeze.data.tagtextColors
import com.example.coneeze.data.SaleNames
import com.example.coneeze.data.SaleFeatures
import com.example.coneeze.data.SalePrices
import com.example.coneeze.data.Percents
import com.example.coneeze.data.OriginPrices


@Composable
fun SaleCategory(
    image: List<Int>,
    name: List<String>,
    feature: List<String>,
    percent: List<String>,
    price: List<String>,
    origin_price: List<String>,
    tagCategory: List<String>,            // Tag 관련 인자 추가
    tagBackgroundColor: List<Color>,
    tagTextColor: List<Color>
){
    Column(

    ) {

        SaleItem(
            image = painterResource(id = image[0]),
            name =name[0],
            feature= feature[0],
            percent = percent[0],
            price = price[0],
            origin_price= origin_price[0],
            tagCategory= tagCategory[0],            // Tag 관련 인자 추가
            tagBackgroundColor= tagBackgroundColor[0],
            tagTextColor = tagTextColor[0]
        )

        Spacer(modifier = Modifier.height(16.dp))

        SaleItem(
            image = painterResource(id = image[1]),
            name =name[1],
            feature= feature[1],
            percent = percent[1],
            price = price[1],
            origin_price= origin_price[1],
            tagCategory= tagCategory[1],            // Tag 관련 인자 추가
            tagBackgroundColor= tagBackgroundColor[1],
            tagTextColor = tagTextColor[1]
        )
    }

}

@Preview(showBackground = true)
@Composable
fun SaleCategoryPreview(){
    SaleCategory(
        image = SaleImages,
        name = SaleNames,
        feature = SaleFeatures,
        percent = Percents ,
        price = SalePrices,
        origin_price = OriginPrices,
        tagCategory = tags,
        tagBackgroundColor = tagbackgroundColors,
        tagTextColor = tagtextColors
    )
}
