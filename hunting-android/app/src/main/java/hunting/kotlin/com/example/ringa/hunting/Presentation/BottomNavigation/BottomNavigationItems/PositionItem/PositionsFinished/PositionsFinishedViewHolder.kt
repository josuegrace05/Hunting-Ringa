package hunting.kotlin.com.example.ringa.hunting.Presentation.BottomNavigation.BottomNavigationItems.PositionItem.PositionsFinished


import android.view.View
import android.widget.ImageView
import android.widget.TextView
import hunting.kotlin.com.example.ringa.hunting.Domain.Entities.Position
import hunting.kotlin.com.example.ringa.hunting.Presentation.Helper.BaseRecyclerViewAdapter.BaseViewHolder
import hunting.kotlin.com.example.ringa.hunting.R

class PositionsFinishedViewHolder(view: View): BaseViewHolder<Position>(view){
  val positionNameTextView = view.findViewById(R.id.position_finished_cell_name) as TextView
  val positionCompanyTextView= view.findViewById(R.id.position_finished_cell_company) as TextView
  val positionIsAvalableImageView = view.findViewById(R.id.position_finished_cell_is_avalable) as ImageView
  override fun setupData(data: Position) {
    positionNameTextView.text = data.name
    positionCompanyTextView.text = data.companyName
  }


}