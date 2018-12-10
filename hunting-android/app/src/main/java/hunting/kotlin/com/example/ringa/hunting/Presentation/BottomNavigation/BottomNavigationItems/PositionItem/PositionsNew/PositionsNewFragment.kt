package hunting.kotlin.com.example.ringa.hunting.Presentation.BottomNavigation.BottomNavigationItems.PositionItem.PositionsNew

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import hunting.kotlin.com.example.ringa.hunting.Domain.Entities.Position
import hunting.kotlin.com.example.ringa.hunting.MyApplication
import hunting.kotlin.com.example.ringa.hunting.Presentation.Helper.BaseRecyclerViewAdapter.BaseViewHolderCallback
import hunting.kotlin.com.example.ringa.hunting.R
import android.support.design.widget.Snackbar

import hunting.kotlin.com.example.ringa.hunting.Presentation.BottomNavigation.BottomNavigationItems.PositionItem.PositionDetails.PositionDetailsActivity
import hunting.kotlin.com.example.ringa.hunting.Presentation.Helper.BaseRecyclerViewAdapter.BaseAdapterInterface
import hunting.kotlin.com.example.ringa.hunting.Presentation.Helper.BaseRecyclerViewAdapter.BaseRecyclerViewAdapter


class PositionsNewFragment:PositionsNewFragmentLogic,Fragment(),BaseViewHolderCallback{

  var presenter:PositionsNewPresenterLogic? = null
  init {
    val positionsNewPresenter = PositionsNewPresenter()
    positionsNewPresenter.viewLogic = this@PositionsNewFragment
    presenter = positionsNewPresenter
  }

  var recyclerView:RecyclerView? = null
  var positionsRecyclerViewAdapter: BaseRecyclerViewAdapter<Position>? = null
  var viewHolder:PositionsNewViewHolder? = null

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
  {
    val view = inflater.inflate(R.layout.fragment_positions_new,container,false)
    setupRecyclerView(view)
    positionsRecyclerViewAdapter?.startLoading()
    presenter?.getNewPositions()
    return view
  }

  fun setupRecyclerView(view:View){
    recyclerView = view.findViewById(R.id.fragment_positions_new_recycler_view)
    recyclerView?.layoutManager = LinearLayoutManager(MyApplication.applicationContext())
    positionsRecyclerViewAdapter = BaseRecyclerViewAdapter<Position>(object : BaseAdapterInterface {
      override fun onCreateViewHolder(parent: ViewGroup?): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.positions_new_cell,parent,false)
        viewHolder = PositionsNewViewHolder(view,this@PositionsNewFragment)
        return viewHolder!!
      }
    })
    recyclerView?.adapter = positionsRecyclerViewAdapter
  }
  // BaseViewHolderCallback
  override fun onViewClicked(viewHolder: RecyclerView.ViewHolder) {
    var positionsNewViewHolder = viewHolder as PositionsNewViewHolder
    PositionDetailsActivity.startDetailsActivity(
      activity as Activity,
      positionsNewViewHolder.positionNameTextView,
      positionsNewViewHolder.positionCompanyTextView
    ,positionsNewViewHolder.positionId)
  }
  // Diplay Error message from api
  override fun displayApiErrorMessage(message: String) {
    val mySnackbar = Snackbar.make(view!!, message, Snackbar.LENGTH_SHORT);
    mySnackbar.show();
  }
  // Display new positions
  override fun displayNewPositions(newPositionsArrayList: ArrayList<Position>) {
    positionsRecyclerViewAdapter?.stopLoading()
    positionsRecyclerViewAdapter?.addAll(newPositionsArrayList)
  }

}