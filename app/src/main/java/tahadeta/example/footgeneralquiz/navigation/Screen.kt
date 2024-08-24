package tahadeta.example.footgeneralquiz.navigation

// Định nghĩa một lớp sealed để quản lý các màn hình trong ứng dụng
sealed class Screen(val route: String) {

    // Màn hình SplashScreen với route là "splash_screen"
    object SplashScreen : Screen("splash_screen")

    // Màn hình ChoiceTypeScreen với route là "choice_type_screen"
    object ChoiceTypeScreen : Screen("choice_type_screen")

    // Màn hình ChoiceLevelScreen với route là "choice_level_screen"
    object ChoiceLevelScreen : Screen("choice_level_screen")

    // Màn hình SurveyScreen với route là "survey_screen"
    object SurveyScreen : Screen("survey_screen")

    // Màn hình ResultScreen với route là "result_screen"
    object ResultScreen : Screen("result_screen")

    // Hàm để thêm đối số vào route
    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)  // Thêm route của màn hình hiện tại vào chuỗi
            args.forEach {
                append("/$it")  // Thêm từng đối số vào chuỗi theo định dạng "/arg"
            }
        }
    }
}
