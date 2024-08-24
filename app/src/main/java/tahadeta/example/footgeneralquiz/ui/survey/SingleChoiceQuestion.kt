package tahadeta.example.footgeneralquiz.ui.survey

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import tahadeta.example.footgeneralquiz.data.PossibleAnswer
import tahadeta.example.footgeneralquiz.data.Question
import tahadeta.example.footgeneralquiz.theme.Green1Unselected
import tahadeta.example.footgeneralquiz.theme.Green2

@Composable
fun SingleChoiceQuestion(
    title: String,
    question: Question,
    withImage: Boolean,
    selectedAnswer: PossibleAnswer?,
    onOptionSelected: (PossibleAnswer, Question) -> Unit,
    modifier: Modifier = Modifier
) {
    QuestionWrapper(
        title = title,
        modifier = modifier.selectableGroup(),
        withImage = withImage,
        questionId = question.idQuestion
    ) {
        question.possibleAnswers.forEach {
            val selected = it == selectedAnswer
            RadioButtonWithTexteRow(
                modifier = Modifier.padding(vertical = 8.dp),
                text = it.title.toString(),
                selected = selected,
                onOptionSelected = {
                    onOptionSelected(it, question)
                }
            )
        }
    }
}

@Composable
fun RadioButtonWithTexteRow(
    text: String,
    selected: Boolean,
    onOptionSelected: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.small,
        color = if (selected) {
            Green1Unselected
        } else {
            Green2
        },
        border = BorderStroke(
            width = 1.dp,
            color = if (selected) {
                Green1Unselected
            } else {
                Green1Unselected
            }
        ),
        modifier = modifier
            .clip(MaterialTheme.shapes.small)
            .selectable(
                selected,
                onClick = onOptionSelected,
                role = Role.RadioButton
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text,
                Modifier.weight(1f),
                style = MaterialTheme.typography.bodyLarge,
                color = if (selected) {
                    Green2
                } else {
                    Green1Unselected
                }
            )

            Box(Modifier.padding(8.dp)) {
                RadioButton(
                    selected,
                    onClick = null,
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color.White,
                        unselectedColor = Green1Unselected
                    )
                )
            }
        }
    }
}
