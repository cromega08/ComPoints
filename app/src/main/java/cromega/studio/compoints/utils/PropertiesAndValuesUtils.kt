package cromega.studio.compoints.utils

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.SecureFlagPolicy

object PropertiesAndValuesUtils {
    @Composable
    fun generateSmallPadding2Axis() =
        PaddingValues(
            horizontal = 15.dp,
            vertical = 10.dp
        )

    @Composable
    fun generateDialogProperties() =
        DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true,
            securePolicy = SecureFlagPolicy.SecureOn
        )

    @Composable
    fun generateCardElevation(): CardElevation =
        CardDefaults.elevatedCardElevation(
            defaultElevation = 5.dp,
            pressedElevation = 3.dp,
            focusedElevation = 4.dp,
            hoveredElevation = 3.dp,
            draggedElevation = 6.dp,
            disabledElevation = 2.dp
        )

    @Composable
    fun generateButtonColors(): ButtonColors =
        ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = Color.Black,
            disabledContainerColor = Color.Gray,
            disabledContentColor = Color.Gray
        )
}