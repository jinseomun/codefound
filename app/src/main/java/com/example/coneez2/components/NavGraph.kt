package com.example.coneez2.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.coneez2.login.LoginScreen
import com.example.coneez2.login.SignupScreen
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
    NavHost(navController = navController, startDestination = "reservation") {
        composable("로그인") { LoginScreen(navController)}
        composable("회원가입") { SignupScreen(navController)}
        composable("reservation") { ReservationScreen(navController)}
        composable("reserving1") { FirstScreen(navController) }
        composable("reserving2") { SecondScreenWithModalBottomSheet(navController) }
        composable("teststart") { TestScreen(navController) }
        composable("survey") { SurveyScreen(navController) }
        composable("result") { ResultScreen(navController) }
        composable("마이페이지") { MypageScreen(navController) }
        composable("주문내역") { OrderDetailScreen(navController) }
        composable(
            route = "주문상세/{orderId}",
            arguments = listOf(navArgument("orderId") { type = NavType.StringType })
        ) { backStackEntry ->
            val orderId = backStackEntry.arguments?.getString("orderId")
            MoreDetailScreen(navController, orderId) }
        composable("예약내역") { BookingHistoryScreen(navController) }
        composable(
            route = "예약상세/{bookingId}",
            arguments = listOf(navArgument("bookingId") { type = NavType.StringType })
        ) { backStackEntry ->
            val bookingId = backStackEntry.arguments?.getString("bookingId")
            BookingDetailScreen(navController, bookingId)
        }


    }
}

