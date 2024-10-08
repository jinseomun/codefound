package com.example.coneez2.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.coneez2.mypage.BookingDetailScreen
import com.example.coneez2.mypage.BookingHistoryScreen
import com.example.coneez2.mypage.MoreDetailScreen
import com.example.coneez2.mypage.MypageScreen
import com.example.coneez2.mypage.OrderDetailScreen
import com.example.coneez2.resevepage.FirstScreen
import com.example.coneez2.resevepage.ReservationScreen
import com.example.coneez2.resevepage.SecondScreenWithModalBottomSheet
import com.example.coneez2.testingpage.ResultScreen
import com.example.coneez2.testingpage.SurveyScreen
import com.example.coneez2.testingpage.TestScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "마이페이지") {
        composable("reservation") { ReservationScreen(navController)}
        composable("reserving1") { FirstScreen(navController) }
        composable("reserving2") { SecondScreenWithModalBottomSheet(navController) }
        composable("teststart") { TestScreen(navController) }
        composable("survey") { SurveyScreen(navController) }
        composable("result") { ResultScreen(navController) }
        composable("마이페이지") { MypageScreen(navController) }
        composable("주문내역") { OrderDetailScreen(navController) }
        composable("주문상세") { MoreDetailScreen(navController) }
        composable("예약내역") { BookingHistoryScreen(navController) }
        composable("예약상세") { BookingDetailScreen(navController) }



    }
}

