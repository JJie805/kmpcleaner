package com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.contacts

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.Contact
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ContactsScreenRoot(
    viewModel: ContactsViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    ContactsScreen(
        uiState = uiState,
        onAction = viewModel::onAction
    )
}

@Composable
fun ContactsScreen(
    uiState: ContactsUiState,
    onAction: (ContactsAction) -> Unit
) {
    Scaffold(
        bottomBar = {
            if (uiState.selectedContacts.isNotEmpty()) {
                Button(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    onClick = { onAction(ContactsAction.DeleteSelected) }
                ) {
                    Text("Delete Selected (${uiState.selectedContacts.size})")
                }
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier.fillMaxSize().padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            if (uiState.isLoading) {
                CircularProgressIndicator()
            } else if (uiState.error != null) {
                Text("Error: ${uiState.error}")
            } else if (uiState.duplicateContactGroups.isEmpty() && uiState.invalidContacts.isEmpty()) {
                Text(text = "非常干净，没有发现可清理的联系人。")
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    if (uiState.duplicateContactGroups.isNotEmpty()) {
                        item {
                            Text("重复联系人", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(bottom = 8.dp))
                        }
                        items(uiState.duplicateContactGroups) { group ->
                            DuplicateContactGroupItem(group)
                        }
                    }

                    if (uiState.invalidContacts.isNotEmpty()) {
                        item {
                            Text("无效联系人", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(top = 16.dp, bottom = 8.dp))
                        }
                        items(uiState.invalidContacts, key = { it.id }) { contact ->
                            ContactItem(
                                contact = contact,
                                isSelected = uiState.selectedContacts.contains(contact.id),
                                onToggleSelection = { onAction(ContactsAction.ToggleSelection(contact.id)) }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun DuplicateContactGroupItem(group: List<Contact>) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(group.first().name, fontWeight = FontWeight.Bold)
            group.forEach { contact ->
                Text("  - ${contact.phoneNumbers.joinToString()}", style = MaterialTheme.typography.bodySmall)
            }
            Spacer(Modifier.height(8.dp))
            Button(onClick = { /* TODO: Merge action */ }, modifier = Modifier.align(Alignment.End)) {
                Text("合并")
            }
        }
    }
}

@Composable
private fun ContactItem(
    contact: Contact,
    isSelected: Boolean,
    onToggleSelection: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onToggleSelection() }
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(text = contact.name.ifBlank { "(无姓名)" }, style = MaterialTheme.typography.bodyLarge)
            contact.phoneNumbers.forEach {
                Text(text = it, style = MaterialTheme.typography.bodyMedium)
            }
            contact.emails.forEach {
                Text(text = it, style = MaterialTheme.typography.bodyMedium)
            }
        }
        if (isSelected) {
            Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = "Selected",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
    }
}
