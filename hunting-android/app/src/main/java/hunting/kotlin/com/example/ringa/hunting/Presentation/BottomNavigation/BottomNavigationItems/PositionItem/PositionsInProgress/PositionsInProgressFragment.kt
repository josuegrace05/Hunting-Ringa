package hunting.kotlin.com.example.ringa.hunting.Presentation.BottomNavigation.BottomNavigationItems.PositionItem.PositionsInProgress

import android.app.Activity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import hunting.kotlin.com.example.ringa.hunting.Domain.Entities.Position
import hunting.kotlin.com.example.ringa.hunting.MyApplication
import hunting.kotlin.com.example.ringa.hunting.Presentation.BottomNavigation.BottomNavigationItems.PositionItem.PositionDetails.PositionDetailsActivity
import hunting.kotlin.com.example.ringa.hunting.Presentation.Helper.BaseRecyclerViewAdapter.BaseAdapterInterface
import hunting.kotlin.com.example.ringa.hunting.Presentation.Helper.BaseRecyclerViewAdapter.BaseRecyclerViewAdapter
import hunting.kotlin.com.example.ringa.hunting.Presentation.Helper.BaseRecyclerViewAdapter.BaseViewHolderCallback
import hunting.kotlin.com.example.ringa.hunting.R
class PositionsInProgressFragment : PositionsInProgressFragmentLogic,Fragment(), BaseViewHolderCallback {


  var presenter:PositionsInProgressPresenterLogic? = null
  init {
    val positionsInProgressPresenter = PositionsInProgressPresenter()
    positionsInProgressPresenter.viewLogic = this@PositionsInProgressFragment
    presenter = positionsInProgressPresenter
  }

  var recyclerView: RecyclerView? = null
  var positionsRecyclerViewAdapter: BaseRecyclerViewAdapter<Position>? = null

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    val view = inflater.inflate(R.layout.fragment_positions_in_progress, container, false)
    setupRecyclerView(view)
    positionsRecyclerViewAdapter?.startLoading()
    presenter?.getInProgressPositions()
    return view
  }
  fun setupRecyclerView(view:View){
    recyclerView = view.findViewById(R.id.fragment_positions_in_progress_recycler_view)
    recyclerView?.layoutManager = LinearLayoutManager(MyApplication.applicationContext())
    positionsRecyclerViewAdapter = BaseRecyclerViewAdapter<Position>(object : BaseAdapterInterface {
      override fun onCreateViewHolder(parent: ViewGroup?): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.positions_in_progress_cell, parent, false)
        return PositionsInProgressViewHolder(view, this@PositionsInProgressFragment)
      }
    })
    recyclerView?.adapter = positionsRecyclerViewAdapter
  }
  // BaseViewHolderCallback
  override fun onViewClicked(viewHolder: RecyclerView.ViewHolder) {
    var positionsInProgressViewHolder = viewHolder as PositionsInProgressViewHolder
    PositionDetailsActivity.startDetailsActivity(
      activity as Activity,
      positionsInProgressViewHolder.positionNameTextView,
      positionsInProgressViewHolder.positionCompanyTextView
    ,positionsInProgressViewHolder.positionId)
  }
  // Display error message from API
  override fun displayApiErrorMessage(message: String) {
    val mySnackbar = Snackbar.make(view!!, message, Snackbar.LENGTH_SHORT);
    mySnackbar.show();
  }
  // Display In Progress Positions
  override fun displayInProgressPositions(newPositionsArrayList: ArrayList<Position>) {
    positionsRecyclerViewAdapter?.stopLoading()
    positionsRecyclerViewAdapter?.addAll(newPositionsArrayList)
  }
}