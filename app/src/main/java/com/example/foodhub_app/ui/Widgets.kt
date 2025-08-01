package com.example.foodhub_app.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.foodhub_app.R
import com.example.foodhub_app.ui.theme.Orange

@Composable
fun GroupSocialIcons(color: Color, onFacebookClick: () -> Unit, onGoogleClick: () -> Unit) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            HorizontalDivider(modifier = Modifier.weight(1f), thickness = 1.dp, color = color)
            Text(text = stringResource(id = R.string.signInText), color = color, modifier = Modifier.padding(8.dp))
            HorizontalDivider(modifier = Modifier.weight(1f), thickness = 1.dp, color = color)
        }
        Spacer(modifier = Modifier.size(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            SocialButton(
                icon = R.drawable.ic_google,
                title = R.string.sign_with_google,
                onGoogleClick
            )
            SocialButton(
                icon = R.drawable.ic_facebook,
                title = R.string.sign_with_facebook,
                onFacebookClick
            )

        }
    }
}

@Composable
fun SocialButton(icon: Int, title: Int, onClick: () -> Unit) {
    Button(
        onClick = { onClick },
        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
        modifier = Modifier.shadow(4.dp, shape = androidx.compose.foundation.shape.CircleShape)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = null,
                Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = stringResource(id = title), color = Color.Black)
        }
    }
}

@Composable
fun FoodHubTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = LocalTextStyle.current,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    prefix: @Composable (() -> Unit)? = null,
    suffix: @Composable (() -> Unit)? = null,
    supportingText: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = OutlinedTextFieldDefaults.shape,
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors().copy(
        focusedTextColor = Color.Black,
        unfocusedTextColor = Color.LightGray.copy(alpha = 0.4f),
        focusedIndicatorColor = Orange,
        unfocusedIndicatorColor = Color.LightGray.copy(alpha = 0.4f)
    )
) {
    Column {
        label?.let {
            Row {
                Spacer(modifier = Modifier.size(8.dp))
                it()
            }
        }
        Spacer(modifier = Modifier.size(8.dp))
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = modifier,
            enabled = enabled,
            readOnly = readOnly,
            textStyle = textStyle,
            label = null,
            placeholder = placeholder,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            prefix = null,
            suffix = null,
            supportingText = supportingText,
            isError = isError,
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            singleLine = singleLine,
            maxLines = maxLines,
            minLines = minLines,
            interactionSource = interactionSource,
            shape = shape,
            colors = colors,
        )
    }
}