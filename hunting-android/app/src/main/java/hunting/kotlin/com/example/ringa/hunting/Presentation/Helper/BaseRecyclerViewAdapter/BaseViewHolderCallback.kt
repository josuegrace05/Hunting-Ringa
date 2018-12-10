package hunting.kotlin.com.example.ringa.hunting.Presentation.Helper.BaseRecyclerViewAdapter

import android.support.v7.widget.RecyclerView
import android.view.View

interface BaseViewHolderCallback{
  fun onViewClicked(viewHolder: RecyclerView.ViewHolder)
}