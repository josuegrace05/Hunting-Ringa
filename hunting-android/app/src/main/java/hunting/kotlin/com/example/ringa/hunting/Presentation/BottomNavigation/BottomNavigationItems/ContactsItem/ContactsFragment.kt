package hunting.kotlin.com.example.ringa.hunting.Presentation.BottomNavigation.BottomNavigationItems.ContactsItem

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import hunting.kotlin.com.example.ringa.hunting.Domain.Entities.Contact
import hunting.kotlin.com.example.ringa.hunting.Infrastructure.ContactListManager
import hunting.kotlin.com.example.ringa.hunting.Presentation.AddContactActivity
import hunting.kotlin.com.example.ringa.hunting.Presentation.BottomNavigation.BottomNavigationItems.ContactsItem.ContactList.ContactsListFragment
import hunting.kotlin.com.example.ringa.hunting.Presentation.Helper.BaseViewPagerAdapter.BaseViewPagerAdapter
import hunting.kotlin.com.example.ringa.hunting.Presentation.Helper.BaseViewPagerAdapter.TabLayoutItem
import hunting.kotlin.com.example.ringa.hunting.Presentation.Helper.MenuFloatingButton.MenuFloatingButton
import hunting.kotlin.com.example.ringa.hunting.Presentation.Helper.MenuFloatingButton.MenuFloatingButtonInterface
import hunting.kotlin.com.example.ringa.hunting.Presentation.Helper.MenuFloatingButton.MenuFloatingButtonItem
import hunting.kotlin.com.example.ringa.hunting.R

class ContactsFragment:Fragment(),MenuFloatingButtonInterface{
  enum class FloatingButtonTags(val tag:String){
    SHARE("shareFloatingButton"),
    IMPORT_CONTACTS("referFloatingButton")
  }
  var viewPager : ViewPager? = null
  var tabLayout: TabLayout? = null
  var baseViewPagerAdapter: BaseViewPagerAdapter? = null
  var menuFloatingActionButton: MenuFloatingButton? = null
  val tabLayoutItemArray:ArrayList<TabLayoutItem> = ArrayList()
  var contactArray:ArrayList<Contact> = ArrayList()
  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
  {
    val view = inflater.inflate(R.layout.fragment_contacts,container, false)
    setupMenuFloatingButton(view)
    setupAdapter()
    setupViewPager(view)
    setupTabLayout(view)

    return view
  }
  fun setupAdapter(){
    tabLayoutItemArray.clear()
    tabLayoutItemArray.add(TabLayoutItem(ContactsListFragment(), getString(R.string.contacts_tab_layout_list)))
    tabLayoutItemArray.add(TabLayoutItem(ContactsPendingFragment(), getString(R.string.contacts_tab_layout_pending)))
    baseViewPagerAdapter = BaseViewPagerAdapter(childFragmentManager,tabLayoutItemArray)
  }
  fun setupTabLayout(view:View){
    tabLayout = view.findViewById(R.id.contacts_fragment_tab_layout)
    tabLayout?.setupWithViewPager(viewPager)
  }

  fun setupViewPager(view:View){
    viewPager = view.findViewById(R.id.contacts_fragment_view_pager)
    viewPager!!.adapter = baseViewPagerAdapter
    baseViewPagerAdapter?.notifyDataSetChanged()
  }
  fun setupMenuFloatingButton(view:View){
    menuFloatingActionButton = MenuFloatingButton(view.findViewById(R.id.contacts_floating_action_button_menu))
    menuFloatingActionButton!!.addFloatingActionButton(view.findViewById(R.id.contacts_floating_action_button_share),FloatingButtonTags.SHARE.tag)
    menuFloatingActionButton!!.addFloatingActionButton(view.findViewById(R.id.contacts_floating_action_button_add_contact),FloatingButtonTags.IMPORT_CONTACTS.tag)
    menuFloatingActionButton!!.listener = this
  }
  //Callback MenuFloatingButtonInterface
  override fun onFloatingActionButtonClicked(menuFloatingButtonItem: MenuFloatingButtonItem) {
    when(menuFloatingButtonItem.tag){
      FloatingButtonTags.SHARE.tag -> addButtonClicked(menuFloatingButtonItem.floatingActionButton)
      FloatingButtonTags.IMPORT_CONTACTS.tag-> importContacts()
    }
  }
  private fun addButtonClicked(view:View){
    val intent = Intent(activity,AddContactActivity::class.java)
    startActivity(intent)
  }
  fun importContacts(){
    val newContactArray = ContactListManager().getContacts()
    //contactArray = Helper().mergeContacts(contactArray,newContactArray)
    (tabLayoutItemArray[0].fragment as ContactsListFragment).populateContactList(newContactArray)
  }
}