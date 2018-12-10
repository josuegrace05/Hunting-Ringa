package hunting.kotlin.com.example.ringa.hunting.Presentation.Helper.BaseRecyclerViewAdapter

import android.support.v7.widget.RecyclerView
import android.view.View
import hunting.kotlin.com.example.ringa.hunting.Presentation.Helper.BaseRecyclerViewAdapter.BaseViewHolderCallback

/**
 * Created by ringa on 25/10/2018.
 */
abstract class BaseViewHolder<T> :RecyclerView.ViewHolder{

  abstract fun setupData(data:T);
  constructor(itemView:View,listener: BaseViewHolderCallback? = null):super(itemView){
    itemView.setOnClickListener {
      listener?.onViewClicked(this)
    }
  }
}