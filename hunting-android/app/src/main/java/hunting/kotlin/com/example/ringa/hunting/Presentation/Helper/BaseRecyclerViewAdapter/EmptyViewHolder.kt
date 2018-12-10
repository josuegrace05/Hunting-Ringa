package hunting.kotlin.com.example.ringa.hunting.Presentation.Helper.BaseRecyclerViewAdapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import hunting.kotlin.com.example.ringa.hunting.R
/**
 * Created by ringa on 25/10/2018.
 */
class EmptyViewHolder : RecyclerView.ViewHolder{
  var emptyTextView:TextView
  constructor(itemView: View):super(itemView){
    emptyTextView = itemView.findViewById(R.id.empty_state_text_view)

  }

}