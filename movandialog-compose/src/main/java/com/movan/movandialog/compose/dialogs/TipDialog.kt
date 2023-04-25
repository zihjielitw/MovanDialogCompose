package com.movan.movandialog.compose.dialogs

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.movan.movandialog.compose.R
import com.movan.movandialog.compose.model.TipDialogType
import kotlinx.coroutines.delay

@Composable
fun TipDialog(
    dialogType: MutableState<TipDialogType> = mutableStateOf(TipDialogType.Success),
    iconColor: Color = MaterialTheme.colorScheme.onSurface,
    text:MutableState<String> = mutableStateOf(""),
    textColor: Color = MaterialTheme.colorScheme.onSurface,
    textFontSize: TextUnit = MaterialTheme.typography.bodyMedium.fontSize,
    dialogOpen: MutableState<Boolean>,
) {
    if (dialogOpen.value) {

        LaunchedEffect(key1 = Unit){
            delay(1500)
            dialogOpen.value = false
        }

        Dialog(
            onDismissRequest = {
                dialogOpen.value = false
            },
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false
            )
        ){
            Surface(
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight()
                    .padding(16.dp),
                shape = RoundedCornerShape(size = 10.dp),
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    when(dialogType.value) {
                        TipDialogType.Success-> {
                            Image(
                                painter  = painterResource(id = R.drawable.tipdialog_success),
                                contentDescription = "Icon Success",
                                contentScale = ContentScale.Fit,
                                colorFilter = ColorFilter.tint(iconColor),
                                modifier = Modifier.size(64.dp)
                            )
                        }
                        TipDialogType.Warning-> {
                            Image(
                                painter  = painterResource(id = R.drawable.tipdialog_warning),
                                contentDescription = "Icon Warning",
                                contentScale = ContentScale.Fit,
                                colorFilter = ColorFilter.tint(iconColor),
                                modifier = Modifier.size(64.dp)
                            )
                        }
                        TipDialogType.Error-> {
                            Image(
                                painter  = painterResource(id = R.drawable.tipdialog_error),
                                contentDescription = "Icon Error",
                                contentScale = ContentScale.Fit,
                                colorFilter = ColorFilter.tint(iconColor),
                                modifier = Modifier.size(64.dp)
                            )
                        }
                    }
                    if (text.value.isNotEmpty()) {
                        Text(
                            text = text.value,
                            modifier = Modifier.padding(top = 16.dp),
                            color = textColor,
                            fontSize = textFontSize
                        )
                    }
                }
            }
        }


    }
}