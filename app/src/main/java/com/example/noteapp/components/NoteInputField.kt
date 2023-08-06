package com.example.noteapp.components


import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.noteapp.R


@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun NoteInputText(
    modifier: Modifier = Modifier,
    text : String,
    label: String,
    maxLine: Int = 1,
    onTextChange: (String) -> Unit = {},
    onImeAction : () -> Unit = {}
){
    val keyBoardController = LocalSoftwareKeyboardController.current


    TextField(
        value = text,
        onValueChange = onTextChange,
        label = { Text(text = label,  color = colorResource(id = R.color.my_mustard)) },
        keyboardActions = KeyboardActions(onDone = {
            onImeAction()
            keyBoardController?.hide()
        }),
        modifier = modifier,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = colorResource(id = R.color.my_mustard),
            containerColor = colorResource(id = R.color.my_blue),
            cursorColor = colorResource(id = R.color.my_mustard),
            focusedBorderColor = colorResource(id = R.color.my_mustard),
            unfocusedBorderColor = colorResource(id = R.color.my_blue),
        )

    )
}


@Composable
fun InputButton(text: String, textColor : Color, btnColor: Color, modifier: Modifier = Modifier){
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(containerColor = btnColor)
        ) {
        Text(text = text, color = textColor)
    }


}