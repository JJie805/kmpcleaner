package com.hjcoding.kmpcleaner.platform

import android.annotation.SuppressLint
import android.content.Context
import android.provider.ContactsContract
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.Contact

class AndroidContactsScanner(private val context: Context) : ContactsScanner {

    @SuppressLint("Range")
    override fun getContacts(completion: (List<Contact>) -> Unit) {
        val contacts = mutableListOf<Contact>()
        val contentResolver = context.contentResolver
        val cursor = contentResolver.query(
            ContactsContract.Contacts.CONTENT_URI,
            null, null, null, null
        )

        cursor?.use {
            while (it.moveToNext()) {
                val id = it.getString(it.getColumnIndex(ContactsContract.Contacts._ID))
                val name = it.getString(it.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME_PRIMARY))
                val phoneNumbers = mutableListOf<String>()
                val emails = mutableListOf<String>()

                if (it.getInt(it.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)) > 0) {
                    val pCur = contentResolver.query(
                        ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                        null,
                        ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                        arrayOf(id),
                        null
                    )
                    pCur?.use {
                        while (pCur.moveToNext()) {
                            val phoneNumber = pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
                            phoneNumbers.add(phoneNumber)
                        }
                    }
                }

                val eCur = contentResolver.query(
                    ContactsContract.CommonDataKinds.Email.CONTENT_URI,
                    null,
                    ContactsContract.CommonDataKinds.Email.CONTACT_ID + " = ?",
                    arrayOf(id),
                    null
                )
                eCur?.use {
                    while (eCur.moveToNext()) {
                        val email = eCur.getString(eCur.getColumnIndex(ContactsContract.CommonDataKinds.Email.DATA))
                        emails.add(email)
                    }
                }

                contacts.add(Contact(id, name, phoneNumbers, emails))
            }
        }
        completion(contacts)
    }
}