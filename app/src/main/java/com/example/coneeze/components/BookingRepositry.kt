package com.example.coneeze.components

import androidx.compose.runtime.mutableStateListOf


data class Booking(
    val bookingId: String,
    val date: String,
    val serviceName: String,
    val bookingDate: String,
    val progressMethod: String,        // 진행 방식 (e.g., "오프라인", "온라인")
    val numberOfReservations: String   // 예약 인원수 (e.g., "6명")
)

const val PAYMENT_METHOD = "가상 계좌"
const val PAYMENT_STATUS = "결제 완료"
const val BOOKING_STATE = "예약 신청"
const val TOTAL_AMOUNT = "20,000원"

object BookingRepository {
    private val _bookings =     mutableStateListOf<Booking>(
        Booking(
            bookingId = "123456789",
            date = "2023.11.11",
            serviceName = "커피 원데이 클래스",
            bookingDate = "2023.12.11",
            progressMethod = "오프라인",
            numberOfReservations = "6명"
        ),
        Booking(
            bookingId = "123456789",
            date = "2023.11.11",
            serviceName = "커피 원데이 클래스",
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