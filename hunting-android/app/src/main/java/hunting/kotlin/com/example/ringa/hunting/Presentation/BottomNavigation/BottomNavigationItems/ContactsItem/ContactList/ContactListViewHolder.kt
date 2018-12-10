package hunting.kotlin.com.example.ringa.hunting.Presentation.BottomNavigation.BottomNavigationItems.ContactsItem.ContactList

import android.view.View
import hunting.kotlin.com.example.ringa.hunting.Domain.Entities.Contact
import hunting.kotlin.com.example.ringa.hunting.MyApplication
import hunting.kotlin.com.example.ringa.hunting.Presentation.Helper.BaseLayoutHolders.TextFieldWithImageAndDescriptionHolder
import hunting.kotlin.com.example.ringa.hunting.Presentation.Helper.BaseRecyclerViewAdapter.BaseViewHolder
import hunting.kotlin.com.example.ringa.hunting.R

class ContactListViewHolder(view: View) : BaseViewHolder<Contact>(view) {
  val contactNameTextViewHolder = TextFieldWithImageAndDescriptionHolder(view.findViewById(R.id.contact_name))
  val contactPhoneTextViewHolder = TextFieldWithImageAndDescriptionHolder(view.findViewById(R.id.contact_phone))
  override fun setupData(data: Contact) {
    contactNameTextViewHolder?.valueTextView?.text = data.name
    contactNameTextViewHolder?.setFormattedDescription(MyApplication.applicationContext()?.resources?.getString(R.string.content_list_view_name)!!)
    contactPhoneTextViewHolder?.valueTextView?.text = data.phone
    contactPhoneTextViewHolder?.setFormattedDescription(MyApplication.applicationContext()?.resources?.getString(R.string.content_list_view_phone)!!)
    contactPhoneTextViewHolder?.iconImageView.setImageDrawable(MyApplication.applicationContext()?.getDrawable(R.drawable.ic_phone_24dp))
  }

}


