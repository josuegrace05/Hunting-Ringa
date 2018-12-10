package hunting.kotlin.com.example.ringa.hunting.Infrastructure

import android.provider.ContactsContract
import hunting.kotlin.com.example.ringa.hunting.Domain.Entities.Contact
import hunting.kotlin.com.example.ringa.hunting.MyApplication

class ContactListManager {
  fun getContacts():ArrayList<Contact>{
    val contactArrayList = ArrayList<Contact>()
    val phones = MyApplication.applicationContext()?.contentResolver?.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC")
    while (phones!!.moveToNext()) {
      val name = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
      val phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
      contactArrayList.add(Contact(-1,name, phoneNumber))
    }
    phones.close()
    return  contactArrayList
  }
}