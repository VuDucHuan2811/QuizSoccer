package tahadeta.example.footgeneralquiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import tahadeta.example.footgeneralquiz.navigation.Navigation
import tahadeta.example.footgeneralquiz.theme.FootGeneralQuizTheme

class MainActivity : ComponentActivity() {

    companion object {
        lateinit var activityInstance: tahadeta.example.footgeneralquiz.MainActivity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tahadeta.example.footgeneralquiz.MainActivity.Companion.activityInstance = this
        setContent {
            FootGeneralQuizTheme {
                Navigation()
            }
        }
    }
}
