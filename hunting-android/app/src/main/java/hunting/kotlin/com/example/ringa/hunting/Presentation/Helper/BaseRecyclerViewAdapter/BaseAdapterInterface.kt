package hunting.kotlin.com.example.ringa.hunting.Presentation.Helper.BaseRecyclerViewAdapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import hunting.kotlin.com.example.ringa.hunting.Presentation.Helper.BaseRecyclerViewAdapter.FullLoadingViewHolder
import hunting.kotlin.com.example.ringa.hunting.Presentation.Helper.BaseRecyclerViewAdapter.LoadingViewHolder
import hunting.kotlin.com.example.ringa.hunting.R
interface BaseAdapterInterface {
  fun onCreateViewHolder(parent: ViewGroup?): RecyclerView.ViewHolder
  fun onCreateEmptyViewHolder(parent: ViewGroup?): RecyclerView.ViewHolder{
    var view : View = LayoutInflater.from(parent!!.getContext()).inflate(R.layout.empty_view,parent,false)
    return EmptyViewHolder(view)
  }
  fun onCreateFullLoadingViewHolder(parent:ViewGroup):RecyclerView.ViewHolder{
    var view : View = LayoutInflater.from(parent!!.getContext()).inflate(R.layout.full_loading_cell,parent,false)
    return FullLoadingViewHolder(view)
  }
  fun onCreateLoadingViewHolder(parent:ViewGroup):RecyclerView.ViewHolder{
    var view : View = LayoutInflater.from(parent!!.getContext()).inflate(R.layout.loading_cell,parent,false)
    return LoadingViewHolder(view)
  }
}