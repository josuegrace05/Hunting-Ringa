package hunting.kotlin.com.example.ringa.hunting.Presentation.BottomNavigation.BottomNavigationItems.ContactsItem.ContactList

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import hunting.kotlin.com.example.ringa.hunting.Domain.Entities.Contact
import hunting.kotlin.com.example.ringa.hunting.MyApplication
import hunting.kotlin.com.example.ringa.hunting.Presentation.Helper.BaseRecyclerViewAdapter.BaseAdapterInterface
import hunting.kotlin.com.example.ringa.hunting.Presentation.Helper.BaseRecyclerViewAdapter.BaseRecyclerViewAdapter
import hunting.kotlin.com.example.ringa.hunting.R


class ContactsListFragment: Fragment(){
  var recyclerView:RecyclerView?= null
  var baseRecyclerViewAdapter: BaseRecyclerViewAdapter<Contact>? = null
  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
  {
    val view = inflater.inflate(R.layout.fragment_contacts_list,container, false)
    setupRecyclerView(view)

    return view
  }
  fun setupRecyclerView(view:View){

    recyclerView = view.findViewById(R.id.fragment_contacts_recycler_view)
    recyclerView?.layoutManager = LinearLayoutManager(MyApplication.applicationContext())
    baseRecyclerViewAdapter= BaseRecyclerViewAdapter<Contact>(object : BaseAdapterInterface {
      override fun onCreateViewHolder(parent: ViewGroup?): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.contact_cell,parent,false)
        return ContactListViewHolder(view)
      }
    })
    recyclerView?.adapter = baseRecyclerViewAdapter
  }
  fun populateContactList(contactArrayList:ArrayList<Contact>){
    baseRecyclerViewAdapter?.addAll(contactArrayList)
  }
}