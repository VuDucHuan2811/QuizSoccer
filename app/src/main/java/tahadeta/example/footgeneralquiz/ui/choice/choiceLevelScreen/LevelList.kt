package tahadeta.example.footgeneralquiz.ui.choice.choiceLevelScreen

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tahadeta.example.footgeneralquiz.R
import tahadeta.example.footgeneralquiz.data.Level
import tahadeta.example.footgeneralquiz.theme.FootGeneralQuizTheme
import tahadeta.example.footgeneralquiz.theme.FtyFontFamily
import tahadeta.example.footgeneralquiz.theme.Gold2
import tahadeta.example.footgeneralquiz.theme.Green1
import tahadeta.example.footgeneralquiz.theme.Green1Unselected
import tahadeta.example.footgeneralquiz.util.Constants.LIST_OF_THREE_LEVELS
import tahadeta.example.footgeneralquiz.util.Constants.LIST_OF_TWO_LEVELS
import tahadeta.example.footgeneralquiz.util.levelSelected
import tahadeta.example.footgeneralquiz.util.typeSelected

@Composable
fun LevelList(
    onItemSelected: (Level) -> Unit,
    selectedLevel: Level?
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.height(16.dp))

        // Lựa chọn danh sách cấp độ dựa trên giá trị của typeSelected
        val listOfLevels =
            if (typeSelected.equals("2") ||
                typeSelected.equals("3") ||
                typeSelected.equals("4")
            ) LIST_OF_TWO_LEVELS
            else LIST_OF_THREE_LEVELS

        // Lặp qua danh sách cấp độ và tạo một mục cho mỗi cấp độ
        listOfLevels.forEach { it ->
            val selected = it == selectedLevel
            LevelItemView(
                onItemSelected = {
                    levelSelected = it.idLevel.toString()
                    onItemSelected(it)
                },
                selectedAnswer = selected,
                index = it.idLevel!!.toInt()
            )
        }

        Spacer(Modifier.height(16.dp))
    }
}


@Composable
fun LevelItemView(
    onItemSelected: () -> Unit,
    selectedAnswer: Boolean,
    index: Int
) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .selectable(
                selectedAnswer,
                onClick = onItemSelected,
                role = Role.RadioButton
            ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor =
            if (selectedAnswer) {
                Green1
            } else {
                Green1Unselected
            }
        ),
        border = BorderStroke(
            width = 2.dp,
            color = Green1Unselected
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = getImageLevel(index)),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .height(100.dp)
                    .padding(6.dp)
            )

            Text(
                text = LIST_OF_THREE_LEVELS[index].title.toString(),
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                color = Gold2,
                fontFamily = FtyFontFamily,
                textAlign = TextAlign.Center
            )
        }
    }
}


fun getImageLevel(id: Int): Int {
    return when (id) {
        0 -> R.drawable.level1
        1 -> R.drawable.level2
        else -> R.drawable.level3
    }
}

@Preview(name = "Welcome light theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun WelcomeScreenPrevew() {
    FootGeneralQuizTheme {
        LevelList(
            onItemSelected = {}, // Callback rỗng cho mục chọn cấp độ
            selectedLevel = tahadeta.example.footgeneralquiz.data.Level(1, "Level 2") // Cấp độ mặc định được chọn
        )
    }
}
