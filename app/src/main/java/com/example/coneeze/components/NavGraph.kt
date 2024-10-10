package com.example.coneeze.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.coneeze.CategoryPage.CategoryScreen
import com.example.coneeze.DetailPage.DetailScreen
import com.example.coneeze.HomePage.HomeScreen
import com.example.coneeze.R
import com.example.coneeze.login.LoginScreen
import com.example.coneeze.login.SignupScreen
import com.example.coneeze.mypage.BookingDetailScreen
import com.example.coneeze.mypage.BookingHistoryScreen
import com.example.coneeze.mypage.MoreDetailScreen
import com.example.coneeze.mypage.MypageScreen
import com.example.coneeze.mypage.OrderDetailScreen
import com.example.coneeze.resevepage.FirstScreen
import com.example.coneeze.resevepage.ReservationScreen
import com.example.coneeze.resevepage.SecondScreenWithModalBottomSheet
import com.example.coneeze.testingpage.ResultScreen
import com.example.coneeze.testingpage.SurveyScreen
import com.example.coneeze.testingpage.TestScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "로그인") {
        composable("로그인") { LoginScreen(navController)}
        composable("회원가입") { SignupScreen(navController)}
        composable("홈") { HomeScreen(navController)}
        composable("카테고리") { CategoryScreen(navController)}
        composable(
            route = "디테일/{image}/{name}/{price}",
            arguments = listOf(
                navArgument("image") { type = NavType.IntType },
                navArgument("name") { type = NavType.StringType },
                navArgument("price") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val image = backStackEntry.arguments?.getInt("image")
            val name = backStackEntry.arguments?.getString("name") ?: "Unknown"
            val price = backStackEntry.arguments?.getString("price") ?: "0원"
            if (image != null) {
                DetailScreen(navController = navController, image = image, name = name, price = price)
            }
        }
        composable("reservation") { ReservationScreen(navController)}
        composable("reserving1") { FirstScreen(navController) }
        composable("reserving2") { SecondScreenWithModalBottomSheet(navController) }
        composable("테스트시작") { TestScreen(navController) }
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

