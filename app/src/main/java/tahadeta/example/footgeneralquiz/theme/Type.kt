package tahadeta.example.footgeneralquiz.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import tahadeta.example.footgeneralquiz.R

// Balloon Font
val BalloonFontFamily = FontFamily(
    listOf(
        Font(R.font.bronten, FontWeight.Normal),
        Font(R.font.bronten_bold, FontWeight.Bold)
    )
)

// Balloon Font
val FtyFontFamily = FontFamily(
    listOf(
        Font(R.font.fty_strategyl, FontWeight.Normal),
        Font(R.font.fty_strategyl, FontWeight.Bold)
    )
)

// Challenge Font
val ChallengeFontFamily = FontFamily(
    listOf(
        Font(R.font.challenge_shadow)
    )
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = BalloonFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)
