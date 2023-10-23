package cromega.studio.compoints.utils

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

object ModifierUtils {

    @Composable
    fun smallPadding2Axis(): Modifier = Modifier.padding(PropertiesAndValuesUtils.generateSmallPadding2Axis())

    @Composable
    fun maxWidthWithSmallPadding(): Modifier = Modifier.fillMaxWidth().then(smallPadding2Axis())
}