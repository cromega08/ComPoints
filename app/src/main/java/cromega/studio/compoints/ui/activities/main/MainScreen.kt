package cromega.studio.compoints.ui.activities.main

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cromega.studio.compoints.data.COMPETITIONS
import cromega.studio.compoints.ui.components.ButtonComponents
import cromega.studio.compoints.ui.components.TextComponents
import cromega.studio.compoints.utils.MethodsUtils

object MainScreen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Screen() =
        Scaffold(
            topBar = {TextComponents.TitleText(text = "ComPoints")},
            content = {paddingValues -> MainBody(paddingValues) }
        )

    @Composable
    fun MainBody(paddingValues: PaddingValues) {
        Row(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ButtonComponents.CircleButton(
                text = "Players",
                onClick = { MethodsUtils.launchContestantsActivity(MainStates.getContext(), COMPETITIONS.PLAYERS) }
            )

            ButtonComponents.CircleButton(
                text = "Teams",
                onClick = { MethodsUtils.launchContestantsActivity(MainStates.getContext(), COMPETITIONS.TEAMS) }
            )
        }
    }
}