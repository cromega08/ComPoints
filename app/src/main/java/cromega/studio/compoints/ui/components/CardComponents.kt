package cromega.studio.compoints.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.Card
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import cromega.studio.compoints.utils.ModifierUtils
import cromega.studio.compoints.utils.PropertiesAndValuesUtils

object CardComponents {

    @Composable
    fun ContestantCard(onClick: () -> Unit, content: @Composable() (ColumnScope.() -> Unit)) =
        Card(
            modifier =
                Modifier
                    .clickable(
                        enabled = true,
                        onClickLabel = "Edit Contestant",
                        role = Role.Button,
                        onClick = onClick
                    )
                    .then(ModifierUtils.smallPadding2Axis()),
            shape = Shapes().medium,
            elevation = PropertiesAndValuesUtils.generateCardElevation(),
            content = content
        )
}