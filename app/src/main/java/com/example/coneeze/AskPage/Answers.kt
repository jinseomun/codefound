package com.example.coneeze.AskPage

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Answers(){
    Answer(
        name= "luv******",
        question= "양이 조금 모자라는 것 같아요.",
        questionDate= "2024.11.11",
        answer="안녕하세요! 커니즈입니다.\n" +
                "처음 소분 할 때 기계로 정확히 무게를 재어 소분하는데, 이 과정에서 수분이 조금 빠져나가 무게가 상이할 수 있습니다. 이 점 참고 부탁드립니다. 감사합니다.",
        answerDate= "2024.11.11"
    )
    Answer(
        name= "pjs******",
        question= "원두 관리 방법 좀 알려주세요ㅠㅠ\n" +
                "커린이예요..",
        questionDate= "2024.10.11",
        answer= "안녕하세요! 커니즈입니다.\n" +
                "항상 습기를 조심하시길 바라며, 서늘한 곳에 보관해 주세요. 직사광선 또는 습기는 원두의 향과 맛을 변질 시키는 가장 큰 원인입니다.",
        answerDate= "2024.10.11"
    )
    Answer(
        name= "lkj******",
        question= "주문 상품 확인은 어디서 하나요??",
        questionDate= "2024.10.10",
        answer="안녕하세요! 커니즈입니다.\n" +
                "주문하신 상품은 마이페이지에서 확인하실 수 있습니다!",
        answerDate= "2024.10.11"
    )

    
    Spacer(modifier = Modifier.height(24.dp))
}

