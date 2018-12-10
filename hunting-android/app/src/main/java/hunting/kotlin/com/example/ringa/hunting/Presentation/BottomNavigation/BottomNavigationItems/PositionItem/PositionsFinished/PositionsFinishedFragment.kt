package hunting.kotlin.com.example.ringa.hunting.Presentation.BottomNavigation.BottomNavigationItems.PositionItem.PositionsFinished

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import hunting.kotlin.com.example.ringa.hunting.Domain.Entities.Position
import hunting.kotlin.com.example.ringa.hunting.HuntingApplication
import hunting.kotlin.com.example.ringa.hunting.Presentation.Helper.BaseRecyclerViewAdapter.BaseAdapterInterface
import hunting.kotlin.com.example.ringa.hunting.Presentation.Helper.BaseRecyclerViewAdapter.BaseRecyclerViewAdapter
import hunting.kotlin.com.example.ringa.hunting.R


class PositionsFinishedFragment:PositionsFinishedFragmentLogic, Fragment(){


  var presenter:PositionsFinishedPresenterLogic? = null
  init {
    val positionsFinishedPresenter = PositionsFinishedPresenter()
    positionsFinishedPresenter.viewLogic = this@PositionsFinishedFragment
    presenter = positionsFinishedPresenter
  }

  var recyclerView: RecyclerView? = null
  var positionsRecyclerViewAdapter: BaseRecyclerViewAdapter<Position>? = null
  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    val view = inflater.inflate(R.layout.fragment_positions_finished, container,false)
    setupRecyclerView(view)
    positionsRecyclerViewAdapter?.startLoading()
    presenter?.getFinishedPositions()
    return view
  }
  fun setupRecyclerView(view:View){
    recyclerView = view.findViewById(R.id.fragment_positions_finished_recycler_view)
    recyclerView?.layoutManager = LinearLayoutManager(HuntingApplication.applicationContext())
    positionsRecyclerViewAdapter = BaseRecyclerViewAdapter<Position>(object : BaseAdapterInterface {
      override fun onCreateViewHolder(parent: ViewGroup?): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.positions_finished_cell,parent,false)
        return PositionsFinishedViewHolder(view)
      }
    })
    recyclerView?.adapter = positionsRecyclerViewAdapter
  }
  // Display error message from API
  override fun displayApiErrorMessage(message: String) {
    val mySnackbar = Snackbar.make(view!!, message, Snackbar.LENGTH_SHORT);
    mySnackbar.show();
  }

  override fun displayFinishedPositions(newPositionsArrayList: ArrayList<Position>) {
    positionsRecyclerViewAdapter?.stopLoading()
    positionsRecyclerViewAdapter?.addAll(newPositionsArrayList)
  }

}
