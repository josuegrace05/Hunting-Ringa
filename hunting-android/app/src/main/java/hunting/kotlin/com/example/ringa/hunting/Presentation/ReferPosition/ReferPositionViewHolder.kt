package hunting.kotlin.com.example.ringa.hunting.Presentation.ReferPosition

import android.view.View
import android.widget.TextView
import hunting.kotlin.com.example.ringa.hunting.Domain.Entities.Profile
import hunting.kotlin.com.example.ringa.hunting.Presentation.Helper.BaseRecyclerViewAdapter.BaseViewHolder
import hunting.kotlin.com.example.ringa.hunting.R

class ReferPositionViewHolder(itemView:View): BaseViewHolder<Profile>(itemView){
  val profileNameTextView: TextView = itemView.findViewById(R.id.refe_position_cell_name)
  override fun setupData(data: Profile) {
    profileNameTextView.setText((data.firstName + " " + data.secondName))
  }
}