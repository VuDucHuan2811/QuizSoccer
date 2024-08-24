package tahadeta.example.footgeneralquiz.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import tahadeta.example.footgeneralquiz.ui.choice.choiceLevelScreen.ChoiceLevelScreen
import tahadeta.example.footgeneralquiz.ui.choice.choiceTypeScreen.ChoiceTypeScreen
import tahadeta.example.footgeneralquiz.ui.splash.SplashScreen
import tahadeta.example.footgeneralquiz.ui.survey.SurveyRoute
import tahadeta.example.footgeneralquiz.ui.survey.surveyScreen.SurveyResultScreen

// Hàm composable để thiết lập điều hướng cho ứng dụng
@Composable
fun Navigation() {
    // Tạo một NavController để quản lý điều hướng
    val navController = rememberNavController()

    // Định nghĩa NavHost với NavController và màn hình khởi đầu là SplashScreen
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ) {
        // Điều hướng tới SplashScreen
        composable(route = Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }

        // Điều hướng tới ChoiceTypeScreen
        composable(route = Screen.ChoiceTypeScreen.route) {
            ChoiceTypeScreen(navController = navController)
        }

        // Điều hướng tới ChoiceLevelScreen
        composable(route = Screen.ChoiceLevelScreen.route) {
            ChoiceLevelScreen(navController = navController)
        }

        // Điều hướng tới SurveyScreen
        composable(route = Screen.SurveyScreen.route) {
            SurveyRoute(
                navController = navController,
                onNavUp = navController::navigateUp
            )
        }

        // Điều hướng tới SurveyResultScreen với đối số 'name'
        composable(
            route = Screen.ResultScreen.route + "/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType  // Định nghĩa loại dữ liệu của 'name' là chuỗi
                    defaultValue = "0"  // Giá trị mặc định của 'name' là "0"
                    nullable = false  // Đối số 'name' không thể là null
                }
            )
        ) {
            SurveyResultScreen(
                onDonePressed = {
                    // Khi nhấn nút 'Done', điều hướng trở lại ChoiceTypeScreen và xóa tất cả các màn hình trước đó khỏi ngăn điều hướng
                    navController.navigate(Screen.ChoiceTypeScreen.route) {
                        popUpTo(0)
                    }
                },
                // Nhận giá trị của 'name' từ các đối số của điều hướng
                result = it.arguments?.getString("name").toString()
            )
        }
    }
}
