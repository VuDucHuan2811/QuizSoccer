package tahadeta.example.footgeneralquiz.ui.choice

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tahadeta.example.footgeneralquiz.R
import tahadeta.example.footgeneralquiz.theme.ChallengeFontFamily
import tahadeta.example.footgeneralquiz.theme.FootGeneralQuizTheme
import tahadeta.example.footgeneralquiz.theme.Green1
import tahadeta.example.footgeneralquiz.theme.Green1Opacity
import tahadeta.example.footgeneralquiz.theme.Green2

@Composable
fun ChoiceFooter(
    onNextClick: () -> Unit,
    onBackClink: () -> Unit,
    title: String,
    backIsVisible: Boolean,
    nextIsEnabled: Boolean
) {
    // Background imageBox
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (backIsVisible) {
            Image(
                painter = painterResource(id = R.drawable.left_arrow),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .height(36.dp)
                    .width(36.dp)
                    .weight(0.3f)
                    .selectable(
                        true,
                        onClick = onBackClink
                    )
            )
        }

        Card(
            modifier = Modifier
                .padding(20.dp)
                .height(50.dp)
                .weight(0.7f)
                .selectable(
                    enabled = nextIsEnabled,
                    selected = nextIsEnabled,
                    onClick = onNextClick,
                    role = Role.RadioButton
                ),
            colors = CardDefaults.cardColors(
                containerColor =
                if (nextIsEnabled) {
                    Color.White
                } else {
                    Green1Opacity
                }
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color =
                    if (nextIsEnabled) {
                        Green1
                    } else {
                        Green2
                    },
                    fontFamily = ChallengeFontFamily,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview(name = "Welcome light theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun WelcomeSceePrevirew() {
    FootGeneralQuizTheme {
        ChoiceFooter({},{}, "Testg", false, false)
    }
}
