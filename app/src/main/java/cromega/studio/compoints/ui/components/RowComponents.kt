package cromega.studio.compoints.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cromega.studio.compoints.data.Contestant

object RowComponents {

    @Composable
    fun PointsController(value: Int, contestant: Contestant) =
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ButtonComponents.PointsButton(
                increase = false,
                value = value,
                contestant = contestant
            )

            TextComponents.NormalText(
                text = "$value",
                maxWidth = false
            )

            ButtonComponents.PointsButton(
                increase = true,
                value = value,
                contestant = contestant
            )
        }
}