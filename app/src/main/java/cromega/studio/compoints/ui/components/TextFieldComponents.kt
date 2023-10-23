package cromega.studio.compoints.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import cromega.studio.compoints.data.Contestant
import cromega.studio.compoints.utils.ModifierUtils

object TextFieldComponents
{
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ContestantName(contestant: Contestant, onDone: (KeyboardActionScope.() -> Unit)?) =
        TextField(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .then(ModifierUtils.smallPadding2Axis()),
            value = contestant.getName(),
            onValueChange = { contestant rename it },
            label = { Text("Name") },
            placeholder = { Text(text = "Contestant ${contestant.getNumber()}") },
            maxLines = 1,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Words,
                autoCorrect = false,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = onDone
            )
        )
}