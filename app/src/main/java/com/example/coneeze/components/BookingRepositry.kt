package com.example.coneeze.components

import androidx.compose.runtime.mutableStateListOf
import com.example.coneeze.mypage.Booking

object BookingRepository {
    private val _bookings =     mutableStateListOf<Booking>(
        Booking(
            bookingId = "123456789",
            date = "2023.11.11",
            serviceName = "향기로운 커피 원데이 클래스",
            bookingDate = "2023.12.11",
            progressMethod = "오프라인",
            numberOfReservations = "6명"
        ),
        Booking(
            bookingId = "123456789",
            date = "2023.11.11",
            serviceName = "향기로운 커피 원데이 클래스",
            bookingDate = "2023.12.11",
            progressMethod = "오프라인",
            numberOfReservations = "6명"
        ),

    )
    val bookings: List<Booking> get() = _bookings

    fun addBooking(booking: Booking) {
        _bookings.add(booking)
    }
}