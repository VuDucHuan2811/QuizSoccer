package tahadeta.example.footgeneralquiz.ui.choice.choiceTypeScreen

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
fun ChoiceTypeScreen(navController: NavController) {
    Surface(modifier = Modifier.supportWideScreen()) {
        ChoiceType(navController)
    }
}

@Composable
fun ChoiceType(navController: NavController) {
    val viewModel: ChoiceLevelViewModel = viewModel()

    val constraints = ConstraintSet {
        val headerBox = createRefFor("headerBox")
        val listBox = createRefFor("listBox")
        val footerBox = createRefFor("footerBox")
        val imageBox = createRefFor("imageBox")

        constrain(headerBox) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(listBox) {
            top.linkTo(headerBox.bottom)
            bottom.linkTo(footerBox.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(footerBox) {
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(imageBox) {
            bottom.linkTo(parent.bottom)
            end.linkTo(parent.end)
            start.linkTo(parent.start)
            height = Dimension.value(200.dp)
        }
    }

    val boxSize = with(LocalDensity.current) { 300.dp.toPx() }

    ConstraintLayout(
        constraints,
        modifier =
        Modifier.fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Green3, Green2),
                    start = Offset(0f, 0f), // top left corner
                    end = Offset(boxSize, boxSize) // bottom right corner
                )
            )
    ) {
        // Background imageBox
        Box(
            modifier = Modifier
                .layoutId("imageBox")
                .fillMaxWidth(1f)
                .fillMaxHeight(0.1f)
        )
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
                containerColor = Green1
            )
        ) {
            ChoiceHeader("Chọn Loại Câu Hỏi", "1/2")
        }

        // listBox
        Box(
            modifier = Modifier
                .layoutId("listBox")
                .fillMaxWidth()
                .fillMaxHeight(0.8f)

        ) {
            ChoiceList(
                onItemSelected = viewModel::onChoiceResponse,
                selectedLevel = viewModel.choiceResponse
            )
        }

        // footerBox
        Box(
            modifier = Modifier
                .layoutId("footerBox")
                .fillMaxWidth(1f)
                .fillMaxHeight(0.1f)

        ) {
            ChoiceFooter(
                onNextClick = {
                    navController.navigate(Screen.ChoiceLevelScreen.route)
                },
                onBackClink = {
                    navController.navigateUp()
                },
                "Tiếp tục",
                false,
                viewModel.isNextEnabled
            )
        }
    }
}

@Preview(name = "Welcome light theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun WelcomeScreenPreview() {
    FootGeneralQuizTheme {
        ChoiceType(NavController(tahadeta.example.footgeneralquiz.MainActivity.activityInstance))
    }
}
