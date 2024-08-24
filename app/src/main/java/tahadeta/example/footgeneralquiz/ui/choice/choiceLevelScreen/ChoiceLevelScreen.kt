package tahadeta.example.footgeneralquiz.ui.choice.choiceLevelScreen

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import tahadeta.example.footgeneralquiz.MainActivity
import tahadeta.example.footgeneralquiz.R
import tahadeta.example.footgeneralquiz.navigation.Screen
import tahadeta.example.footgeneralquiz.theme.FootGeneralQuizTheme
import tahadeta.example.footgeneralquiz.theme.Green1
import tahadeta.example.footgeneralquiz.theme.Green2
import tahadeta.example.footgeneralquiz.theme.Green3
import tahadeta.example.footgeneralquiz.ui.choice.ChoiceFooter
import tahadeta.example.footgeneralquiz.ui.choice.ChoiceHeader
import tahadeta.example.footgeneralquiz.ui.choice.ChoiceLevelViewModel
import tahadeta.example.footgeneralquiz.util.supportWideScreen

@Composable
fun ChoiceLevelScreen(navController: NavController) {
    Surface(modifier = Modifier.supportWideScreen()) {
        ChoiceLevel(navController)
    }
}

@Composable
fun ChoiceLevel(navController: NavController) {
    val viewModel: ChoiceLevelViewModel = viewModel()

    val constraints = ConstraintSet {
        val headerBox = createRefFor("headerBox")
        val listBox = createRefFor("listBox")
        val footerBox = createRefFor("footerBox")
        val imageBox = createRefFor("imageBox")

        // Định nghĩa ràng buộc cho headerBox
        constrain(headerBox) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        // Định nghĩa ràng buộc cho listBox
        constrain(listBox) {
            top.linkTo(headerBox.bottom)
            bottom.linkTo(footerBox.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        // Định nghĩa ràng buộc cho footerBox
        constrain(footerBox) {
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        // Định nghĩa ràng buộc cho imageBox
        constrain(imageBox) {
            bottom.linkTo(parent.bottom)
            end.linkTo(parent.end)
            start.linkTo(parent.start)
            height = Dimension.value(200.dp)
        }
    }

    // Tính toán kích thước của box dựa trên độ phân giải màn hình hiện tại
    val boxSize = with(LocalDensity.current) { 300.dp.toPx() }

    // Sử dụng ConstraintLayout để bố trí các thành phần UI theo ràng buộc đã định nghĩa
    ConstraintLayout(
        constraints,
        modifier =
        Modifier.fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Green3, Green2), // Màu gradient từ Green3 đến Green2
                    start = Offset(0f, 0f), // Bắt đầu từ góc trên trái
                    end = Offset(boxSize, boxSize) // Kết thúc tại góc dưới phải
                )
            )
    ) {
        Box(
            modifier = Modifier
                .layoutId("imageBox")
                .fillMaxWidth(1f)
                .fillMaxHeight(0.1f)
        ) {
            Image(
                painter = painterResource(id = R.drawable.bottom_main_bg),
                contentDescription = null, // Hình ảnh không có mô tả
                contentScale = ContentScale.Crop // Cắt hình ảnh để vừa với hộp
            )
        }

        // Hộp chứa tiêu đề của màn hình
        Card(
            modifier = Modifier
                .layoutId("headerBox")
                .fillMaxWidth(1f)
                .fillMaxHeight(0.1f),
            shape = RoundedCornerShape(
                topStart = 0.dp,
                topEnd = 0.dp,
                bottomEnd = 20.dp,
                bottomStart = 20.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = Green1 // Màu nền của tiêu đề
            )
        ) {
            ChoiceHeader("Chọn cấp độ", "2/2") // Tiêu đề và số bước của màn hình
        }

        // Hộp chứa danh sách các cấp độ lựa chọn
        Box(
            modifier = Modifier
                .layoutId("listBox")
                .fillMaxWidth()
                .fillMaxHeight(0.8f)
        ) {
            LevelList(
                onItemSelected = viewModel::onLevelResponse, // Hàm callback khi một cấp độ được chọn
                selectedLevel = viewModel.levelResponse // Cấp độ hiện tại được chọn
            )
        }

        Box(
            modifier = Modifier
                .layoutId("footerBox")
                .fillMaxWidth(1f)
                .fillMaxHeight(0.1f)
        ) {
            ChoiceFooter(
                onNextClick = {
                    // Điều hướng tới màn hình Survey khi người dùng nhấn nút Start
                    navController.navigate(Screen.SurveyScreen.route)
                },
                onBackClink = {
                    // Điều hướng trở lại mđầun hình trước đó khi người dùng nhấn nút Back
                    navController.navigateUp()
                },
                "Bắt đầu", // Nhãn của nút chính
                true, // Luôn hiển thị nút
                viewModel.isStartEnabled // Trạng thái của nút Start (bật/tắt)
            )
        }
    }
}

@Preview(name = "Welcome light theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun WelcomeScreenPreview() {
    FootGeneralQuizTheme {
        ChoiceLevel(NavController(tahadeta.example.footgeneralquiz.MainActivity.activityInstance))
    }
}
