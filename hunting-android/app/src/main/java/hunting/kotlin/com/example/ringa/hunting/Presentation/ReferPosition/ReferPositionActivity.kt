package hunting.kotlin.com.example.ringa.hunting.Presentation.ReferPosition

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import hunting.kotlin.com.example.ringa.hunting.Domain.Entities.Profile
import hunting.kotlin.com.example.ringa.hunting.MyApplication
import hunting.kotlin.com.example.ringa.hunting.Presentation.Helper.BaseRecyclerViewAdapter.BaseAdapterInterface
import hunting.kotlin.com.example.ringa.hunting.Presentation.Helper.BaseRecyclerViewAdapter.BaseRecyclerViewAdapter
import hunting.kotlin.com.example.ringa.hunting.R
import hunting.kotlin.com.example.ringa.hunting.Presentation.Helper.MenuFloatingButton.MenuFloatingButton
import hunting.kotlin.com.example.ringa.hunting.Presentation.Helper.MenuFloatingButton.MenuFloatingButtonInterface
import hunting.kotlin.com.example.ringa.hunting.Presentation.Helper.MenuFloatingButton.MenuFloatingButtonItem

class ReferPositionActivity:ReferPositionActivityLogic,AppCompatActivity(),MenuFloatingButtonInterface{

  var presenter: ReferPositionPresenterLogic? = null
  init {
    val referPositionPresenter = ReferPositionPresenter()
    referPositionPresenter.viewLogic = this@ReferPositionActivity
    presenter = referPositionPresenter
  }

  enum class FloatingButtonTags(val tag:String){
    SHARE("shareFloatingButton"),
    REFER("referFloatingButton")
  }

  var recyclerView: RecyclerView? = null
  var positionsRecyclerViewAdapter: BaseRecyclerViewAdapter<Profile>? = null
  var menuFloatingButton: MenuFloatingButton? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_refer_position)
    setupFloatingButton()
    setupRecyclerView()
    positionsRecyclerViewAdapter?.startLoading()
    presenter?.getProfilesByPositionId(1)
  }

  fun setupRecyclerView(){
    recyclerView = findViewById(R.id.activity_refer_position_recycler_view)
    recyclerView?.layoutManager = LinearLayoutManager(MyApplication.applicationContext())
    positionsRecyclerViewAdapter = BaseRecyclerViewAdapter<Profile>(object : BaseAdapterInterface {
      override fun onCreateViewHolder(parent: ViewGroup?): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.refer_position_cell,parent,false)
        return ReferPositionViewHolder(view)
      }
    })
    recyclerView?.adapter = positionsRecyclerViewAdapter
  }

  fun setupFloatingButton(){
    menuFloatingButton = MenuFloatingButton(findViewById(R.id.floating_action_button_menu))
    menuFloatingButton!!.addFloatingActionButton(findViewById(R.id.floating_action_button_share), FloatingButtonTags.SHARE.tag)
    menuFloatingButton!!.addFloatingActionButton(findViewById(R.id.floating_action_button_refer_to_contact),
      FloatingButtonTags.REFER.tag)
    menuFloatingButton!!.listener = this
  }
  // MenuFloatingButtonInterface callback
  override fun onFloatingActionButtonClicked(menuFloatingButtomItem: MenuFloatingButtonItem) {
    when(menuFloatingButtomItem.tag){
      FloatingButtonTags.REFER.tag-> Toast.makeText(this, "Refer clicked",Toast.LENGTH_SHORT).show()
      FloatingButtonTags.SHARE.tag-> Toast.makeText(this, "Share clicked",Toast.LENGTH_SHORT).show()
    }
  }
  // display error message from api
  override fun displayApiErrorMessage(message: String) {
    val layoutView = findViewById(R.id.activity_positions_details_layout) as View
    val mySnackbar = Snackbar.make(layoutView, message, Snackbar.LENGTH_LONG);
    mySnackbar.show();
  }

  override fun displayProfiles(profileArrayList: ArrayList<Profile>) {
    positionsRecyclerViewAdapter?.stopLoading()
    positionsRecyclerViewAdapter?.addAll(profileArrayList)
  }

}