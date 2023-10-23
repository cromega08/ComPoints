package cromega.studio.compoints.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cromega.studio.compoints.data.Contestant
import cromega.studio.compoints.ui.components.TextComponents.NormalText
import cromega.studio.compoints.utils.ModifierUtils

object ButtonComponents {

    @Composable
    fun CircleButton(text: String, onClick: () -> Unit) =
        Button(
            modifier = Modifier.padding(10.dp),
            onClick = onClick,
            shape = CircleShape
        ) {
            NormalText(text = text, maxWidth = false)
        }

    @Composable
    fun PointsButton(increase: Boolean = true, value: Int, contestant: Contestant) =
        TextButton(
            modifier = Modifier.wrapContentSize(),
            onClick = { if (increase) (contestant increase value) else (contestant decrease value) },
            content = { NormalText(text = if (increase) "+" else "-", maxWidth = false) }
        )

    @Composable
    fun UpdateContestantsButton(contestant: Contestant, add: Boolean, onClick: () -> Unit) =
        Button(
            modifier = ModifierUtils.maxWidthWithSmallPadding().wrapContentHeight(),
            onClick = onClick,
            shape = RoundedCornerShape(1.dp)
        ) {
            NormalText(text = "${if (add) "Update" else "Delete"} ${if (contestant.hasName()) contestant.getName() else "C${contestant.getNumber()}"}", maxWidth = true)
        }
}