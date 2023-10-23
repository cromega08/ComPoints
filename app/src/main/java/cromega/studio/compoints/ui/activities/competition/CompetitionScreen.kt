package cromega.studio.compoints.ui.activities.competition

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import cromega.studio.compoints.data.Contestant
import cromega.studio.compoints.ui.components.*

object CompetitionScreen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Screen() =
        Scaffold(
            topBar = { TextComponents.TitleText(text = CompetitionStates.getTitle()) },
            content = {
                paddingValues ->
                    MainBody(paddingValues)

                    if (CompetitionStates.showDialog()) {

                        val alreadyExist: Boolean = CompetitionStates.existAmendmentPlayer()

                        if (!alreadyExist) {
                            CompetitionStates.setAmendmentPlayer(
                                Contestant(
                                    number = CompetitionStates.getNumberOfPlayers(),
                                    name = rememberSaveable { mutableStateOf("") },
                                    points = rememberSaveable { mutableStateOf(0) }
                                )
                            )
                        }

                        DialogComponents.ContestantDialog(
                            contestant = CompetitionStates.getAmendmentPlayer(),
                            onDismissDialog =
                            {
                                CompetitionStates.clearAmendmentPlayer()
                                CompetitionStates.closeDialog()
                            },
                            onClickUpdate =
                            {
                                CompetitionStates.pushAmendmentPlayer()
                                CompetitionStates.closeDialog()
                            },
                            onClickDelete =
                                if (alreadyExist) (
                                        {
                                            CompetitionStates.removePlayer(
                                                CompetitionStates.getAmendmentPlayer()
                                            )
                                            CompetitionStates.clearAmendmentPlayer()
                                            CompetitionStates.closeDialog()
                                        }
                                ) else null
                        )
                    }
                      },
            floatingActionButton = {
                ButtonComponents.CircleButton(
                    text = "+",
                    onClick = {
                        if (CompetitionStates.limitReached())
                            Toast.makeText(
                                CompetitionStates.getContext(),
                                "Limit of Contestants is ${CompetitionStates.getLimit()}",
                                Toast.LENGTH_LONG
                            ).show()
                        else CompetitionStates.openDialog()
                    }
                )
            },
            floatingActionButtonPosition = FabPosition.Center
        )

    @Composable
    private fun MainBody(paddingValues: PaddingValues) =
        Box(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
        ) {
            LazyVerticalGrid(
                modifier = Modifier.fillMaxSize(),
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.Center,
                horizontalArrangement = Arrangement.Center
            ) {
                items(CompetitionStates.getNumberOfPlayers()) {
                    PlayerPointCounterCard(CompetitionStates.getPlayer(it))
                }
            }
        }

    @Composable
    private fun PlayerPointCounterCard(contestant: Contestant) =
        CardComponents.ContestantCard(
            onClick = {
                CompetitionStates.setAmendmentPlayer(contestant)
                CompetitionStates.openDialog()
            }
        ) {
            BoxComponents.ContestantBox(contestant)

            TextComponents.NormalText(
                text = if (contestant.hasName()) contestant.getName() else "${CompetitionStates.getLabel()} ${contestant.getNumber()}",
                maxWidth = true
            )

            TextComponents.NormalText(
                text = "${contestant.getPoints()} Points",
                maxWidth = true
            )

            RowComponents.PointsController(
                value = 1,
                contestant = contestant
            )
        }
}