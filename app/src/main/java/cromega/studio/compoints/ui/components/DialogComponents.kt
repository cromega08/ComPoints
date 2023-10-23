package cromega.studio.compoints.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import cromega.studio.compoints.data.Contestant
import cromega.studio.compoints.utils.PropertiesAndValuesUtils

object DialogComponents
{
    @Composable
    fun ContestantDialog(contestant: Contestant, onDismissDialog: () -> Unit, onClickUpdate: () -> Unit, onClickDelete: (() -> Unit)? = null) =
        Dialog(
            onDismissRequest = onDismissDialog,
            properties = PropertiesAndValuesUtils.generateDialogProperties()
        ) {
            Column(
                modifier =
                    Modifier
                        .background(Color.White)
                        .clip(RoundedCornerShape(5.dp)),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                BoxComponents.ContestantBox(contestant = contestant)

                TextFieldComponents.ContestantName(contestant = contestant, onDone = {})

                ButtonComponents.UpdateContestantsButton(
                    contestant = contestant,
                    add = true,
                    onClick = onClickUpdate
                )

                if (onClickDelete  != null) {
                    ButtonComponents.UpdateContestantsButton(
                        contestant = contestant,
                        add = false,
                        onClick = onClickDelete
                    )
                }
            }
        }
}