package tahadeta.example.footgeneralquiz.ui.choice.choiceTypeScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tahadeta.example.footgeneralquiz.R
import tahadeta.example.footgeneralquiz.data.Choice
import tahadeta.example.footgeneralquiz.theme.FtyFontFamily
import tahadeta.example.footgeneralquiz.theme.Green1
import tahadeta.example.footgeneralquiz.theme.Green1Unselected
import tahadeta.example.footgeneralquiz.util.Constants.LIST_OF_CHOICES
import tahadeta.example.footgeneralquiz.util.typeSelected

@Composable
fun ChoiceList(
    onItemSelected: (Choice) -> Unit,
    selectedLevel: Choice?
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),

        contentPadding = PaddingValues(
            start = 6.dp,
            top = 6.dp,
            end = 12.dp,
            bottom = 6.dp
        ),
        content = {
            items(LIST_OF_CHOICES.size) { index ->

                val selected = LIST_OF_CHOICES[index] == selectedLevel
                ChoiceItemView(
                    onItemSelected = {
                        typeSelected = index.toString()
                        onItemSelected(LIST_OF_CHOICES[index])
                    },
                    selectedAnswer = selected,
                    index = LIST_OF_CHOICES[index].idChoice!!.toInt()
                )
            }
        }
    )
}

@Composable
fun ChoiceItemView(
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
            defaultElevation = 4.dp
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
            color = if (selectedAnswer) {
                Green1Unselected
            } else {
                Green1Unselected
            }
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = getImageType(LIST_OF_CHOICES[index].icon)),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.height(120.dp)
            )

            Text(
                text = LIST_OF_CHOICES[index].title.toString(),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                fontFamily = FtyFontFamily,
                color = Color(0xFFFFFFFF),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

fun getImageType(id: String?): Int {
    when (id) {
        "WORLD_CUP" -> return R.drawable.worldcup // Nếu id là "WORLD_CUP", trả về tài nguyên drawable worldcup
        "TEAMS" -> return R.drawable.teams
        "LEAGUE_EU" -> return R.drawable.uefa
        "LEAGUE_AF" -> return R.drawable.uefa // Nếu id là "LEAGUE_AF", cũng trả về tài nguyên drawable uefa (có thể cần phân biệt)
        "PLAYERS" -> return R.drawable.players
        "FLAGS" -> return R.drawable.flags
        "AWARDS" -> return R.drawable.awards
        "VARIOUS" -> return R.drawable.worldcup
        else -> return R.drawable.worldcup
    }
}
