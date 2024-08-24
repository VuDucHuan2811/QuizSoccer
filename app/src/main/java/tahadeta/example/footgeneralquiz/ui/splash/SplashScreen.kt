package tahadeta.example.footgeneralquiz.ui.splash

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import tahadeta.example.footgeneralquiz.R
import tahadeta.example.footgeneralquiz.navigation.Screen
import tahadeta.example.footgeneralquiz.theme.Blue1
import tahadeta.example.footgeneralquiz.theme.ChallengeFontFamily
import tahadeta.example.footgeneralquiz.theme.FootGeneralQuizTheme
import tahadeta.example.footgeneralquiz.theme.Green1
import tahadeta.example.footgeneralquiz.theme.Green4
import tahadeta.example.footgeneralquiz.util.supportWideScreen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    // A surface container using the 'background' color from the theme
    val boxSize = with(LocalDensity.current) { 400.dp.toPx() }
    var visible by remember { mutableStateOf(false) }
    val density = LocalDensity.current

    Surface(modifier = Modifier.supportWideScreen()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Green1, Blue1),
                        start = Offset(0f, 0f), // top left corner
                        end = Offset(boxSize, boxSize) // bottom right corner
                    )
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // fade in logo
            LaunchedEffect(key1 = true) {
                delay(100L)
                visible = !visible
            }

            // navigate
            LaunchedEffect(key1 = true) {
                delay(3000L)
                navController.navigate(Screen.ChoiceTypeScreen.route) {
                    popUpTo(Screen.SplashScreen.route) {
                        inclusive = true
                    }
                }
            }

            AnimatedVisibility(
                visible = visible,
                enter = slideInVertically {
                    // Slide in from 40 dp from the top.
                    with(density) { -40.dp.roundToPx() }
                } + expandVertically(
                    // Expand from the top.
                    expandFrom = Alignment.Top
                ) + fadeIn(
                    // Fade in with the initial alpha of 0.3f.
                    initialAlpha = 0.3f
                ),
                exit = slideOutVertically() + shrinkVertically() + fadeOut()
            ) {
                Splash()
            }
        }
    }
}

@Composable
fun Splash() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Logo(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
        )

        Text(
            text = "Challenge Your Knowledge!",
            color = Green4,
            fontSize = 30.sp,
            modifier = Modifier.fillMaxWidth().padding(vertical = 0.dp, horizontal = 20.dp),
            textAlign = TextAlign.Center,
            letterSpacing = 4.sp,
            lineHeight = 36.sp,
            fontFamily = ChallengeFontFamily
        )
    }
}

@Composable
private fun Logo(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.logo_splash),
        modifier = modifier,
        contentDescription = null,
        contentScale = ContentScale.Fit
    )
}

@Preview(name = "Welcome light theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun WelcomeScreenPreview() {
    FootGeneralQuizTheme {
        Splash()
    }
}
