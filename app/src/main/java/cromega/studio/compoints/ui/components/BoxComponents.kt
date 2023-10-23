package cromega.studio.compoints.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cromega.studio.compoints.data.Contestant

object BoxComponents
{
    @Composable
    fun ContestantBox(contestant: Contestant) = ContestantBoxText(contestant)

    @Composable
    private fun ContestantBoxText(contestant: Contestant) =
        GenericContestantBox(
            contestant = contestant,
            padding = PaddingValues(10.dp)
        ) {
            TextComponents.BoxText("C${contestant.getNumber()}")
        }

    @Composable
    private fun GenericContestantBox(contestant: Contestant, padding: PaddingValues, content: @Composable() (BoxScope.() -> Unit)) =
        Box(
            modifier =
                Modifier
                    .aspectRatio(1f)
                    .fillMaxWidth()
                    .padding(padding)
                    .background(
                        color = Color.DarkGray,
                        shape = RoundedCornerShape(5.dp)
                    ).clickable(
                        enabled = true,
                        onClickLabel = "Select ${if (contestant.hasName()) contestant.getName() else "C${contestant.getNumber()}"}",
                        onClick = {
                        }
                    ),
            contentAlignment = Alignment.Center,
            content = content
        )
}