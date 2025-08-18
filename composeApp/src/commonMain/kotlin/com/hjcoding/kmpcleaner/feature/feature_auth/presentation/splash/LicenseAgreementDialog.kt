package com.hjcoding.kmpcleaner.feature.feature_auth.presentation.splash

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Composable
fun LicenseAgreementDialog(
    onDismissRequest: () -> Unit,
    onAgree: () -> Unit,
    onDisagree: () -> Unit,
){
    Dialog(
        onDismissRequest = onDismissRequest
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp)
                .clip(MaterialTheme.shapes.medium)
                .background(Color.White)
                .padding(vertical = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "标题",
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Black
            )
            Spacer(Modifier.height(20.dp))
            Text(
                text = buildAnnotatedString {
                    append("感谢您的下载和使用，为保护您的个人信息安全，在使用前，请仔细阅读并理解")
                },
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 16.dp),
                style = MaterialTheme.typography.labelMedium,
                lineHeight = 14.sp
            )
            Spacer(Modifier.heightIn(15.dp))
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
            ) {
                Button(
                    modifier = Modifier.weight(2f),
                    onClick = {
                        onDisagree()
                    },
                    border = BorderStroke(
                        width = 0.5.dp,
                        color = Color.Gray,
                    ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.surface,
                        contentColor = Color.Black
                    )
                ) {
                    Text(
                        text = "不同意",
                        style = MaterialTheme.typography.labelMedium,
                        textAlign = TextAlign.Center
                    )
                }
                Button(
                    modifier = Modifier.weight(3f),
                    onClick = {
                        onAgree()
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary
                    )
                ) {
                    Text(
                        text = "同意",
                        style = MaterialTheme.typography.labelMedium,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}