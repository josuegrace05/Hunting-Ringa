package hunting.kotlin.com.example.ringa.hunting.Presentation.BottomNavigation.BottomNavigationItems.PositionItem.PositionsInProgress

import android.view.View
import android.widget.TextView
import hunting.kotlin.com.example.ringa.hunting.Domain.Entities.Position
import hunting.kotlin.com.example.ringa.hunting.Presentation.Helper.BaseRecyclerViewAdapter.BaseViewHolder
import hunting.kotlin.com.example.ringa.hunting.Presentation.Helper.BaseRecyclerViewAdapter.BaseViewHolderCallback
import hunting.kotlin.com.example.ringa.hunting.R

class PositionsInProgressViewHolder(view: View,listener:BaseViewHolderCallback? = null): BaseViewHolder<Position>(view,listener){
  var positionNameTextView = view.findViewById(R.id.positions_in_progress_cell_name) as TextView
  var positionCompanyTextView = view.findViewById(R.id.positions_in_progress_cell_company) as TextView
  var positionProfileCountTextView = view.findViewById(R.id.positions_in_progress_cell_profiles_count) as TextView
  var positionId:Int = -1
  override fun setupData(data: Position) {
    positionNameTextView.text = data.name
    positionCompanyTextView.text = data.companyName
    positionProfileCountTextView.text = ("Profiles" +" : "+ data.referredProfile.toString())
    positionId = data.id
  }
}