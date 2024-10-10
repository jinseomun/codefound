package com.example.coneeze.components

import com.example.coneeze.R

import androidx.compose.runtime.mutableStateListOf

data class Order(
    val orderId: String,
    val date: String,
    val orderState: String,
    val name: String,
    val price: String,
    val imageRes: Int
)

object OrderRepository {
    private val _orders = mutableStateListOf(
        Order(
            orderId = "2024111109162123456",
            date = "2026.11.11",
            orderState = "구매 확정",
            name = "100% 아라비카 블렌드 바라던허니 스페셜티",
            price = "13,800원",
            imageRes = R.drawable.coffee1
        ),
        Order(
            orderId = "2024111109162123457",
            date = "2026.11.02",
            orderState = "배송 완료",
            name = "에티오피아 코케허니 예가체프G1 스페셜티",
            price = "12,200원",
            imageRes = R.drawable.coffee2
        ),
    )

    val orders: List<Order> get() = _orders

    fun addOrder(order: Order) {
        _orders.add(order)
    }
}
