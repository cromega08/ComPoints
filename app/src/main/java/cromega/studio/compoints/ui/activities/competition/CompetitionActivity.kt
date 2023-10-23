package cromega.studio.compoints.ui.activities.competition

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import cromega.studio.compoints.ui.theme.ComPointsTheme
import cromega.studio.compoints.utils.MethodsUtils

class CompetitionActivity : ComponentActivity() {
    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        setContent {
            CompetitionStates.initializeStates(
                context = remember { mutableStateOf(baseContext) },
                title = rememberSaveable { mutableStateOf(intent.getStringExtra("title") ?: "Competition") },
                label = rememberSaveable { mutableStateOf(intent.getStringExtra("title") ?: "Competition") },
                limit = rememberSaveable { mutableStateOf(intent.getIntExtra("limit", 0)) },
                players = remember { mutableStateListOf() },
                showDialog = rememberSaveable { mutableStateOf(false) },
                amendmentPlayer = rememberSaveable { mutableStateOf(null) }
            )

            ComPointsTheme {
                CompetitionScreen.Screen()
            }
        }
    }

    @SuppressLint("MissingSuperCall")
    @Deprecated(
        message = "Deprecated in Java",
        replaceWith = ReplaceWith(
            expression = "MethodsUtils.launchMainActivity(baseContext)",
            "cromega.studio.compoints.utils.MethodsUtils"
        )
    )
    override fun onBackPressed() = MethodsUtils.launchMainActivity(baseContext)
}