package com.movan.movandialog.compose.dialogs

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties

@Composable
fun MessageDialog(
    title:MutableState<String>,
    message:MutableState<String>,
    okText:MutableState<String>,
    cancelText:MutableState<String> = mutableStateOf(""),
    okButtonClick: MutableState<() -> Unit> = mutableStateOf({ dialogOpen.value = false }),
    cancelButtonClick: MutableState<() -> Unit> = mutableStateOf({ dialogOpen.value = false }),
    dialogOpen: MutableState<Boolean>,
) {
    if (dialogOpen.value) {

        AlertDialog(
            onDismissRequest = { dialogOpen.value = false },
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false
            ),
            confirmButton = {
                TextButton(
                    onClick = okButtonClick.value
                ) {
                    Text(text = okText.value)
                }
            },
            dismissButton = {
                if (cancelText.value.isNotEmpty()) {
                    TextButton(
                        onClick = cancelButtonClick.value
                    ) {
                        Text(text = cancelText.value)
                    }
                }
            },
            title = {
                Text(text = title.value)
            },
            text = {
                Text(text = message.value)
            },
            modifier = Modifier.fillMaxWidth().padding(24.dp),
            shape = RoundedCornerShape(5.dp),
        )

    }
}