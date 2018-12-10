package hunting.kotlin.com.example.ringa.hunting.Presentation.BottomNavigation.BottomNavigationItems.PositionItem.PositionsNew

import android.view.View
import android.widget.TextView
import hunting.kotlin.com.example.ringa.hunting.Domain.Entities.Position
import hunting.kotlin.com.example.ringa.hunting.Presentation.Helper.BaseRecyclerViewAdapter.BaseViewHolder
import hunting.kotlin.com.example.ringa.hunting.Presentation.Helper.BaseRecyclerViewAdapter.BaseViewHolderCallback
import hunting.kotlin.com.example.ringa.hunting.R

class PositionsNewViewHolder(view: View,listener:BaseViewHolderCallback? = null): BaseViewHolder<Position>(view,listener){
  var positionNameTextView = view.findViewById(R.id.position_new_cell_position_name) as TextView
  var positionCompanyTextView = view.findViewById(R.id.position_new_cell_position_company) as TextView
  var positionId = -1
  override fun setupData(data: Position) {
    positionNameTextView.text = data.name
    positionCompanyTextView.text = data.companyName
    positionId = data.id
  }

}