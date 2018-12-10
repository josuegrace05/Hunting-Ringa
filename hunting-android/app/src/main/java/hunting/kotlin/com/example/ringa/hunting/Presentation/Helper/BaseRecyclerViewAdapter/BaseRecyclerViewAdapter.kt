package hunting.kotlin.com.example.ringa.hunting.Presentation.Helper.BaseRecyclerViewAdapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import hunting.kotlin.com.example.ringa.hunting.Presentation.Helper.BaseRecyclerViewAdapter.FullLoadingViewHolder
import hunting.kotlin.com.example.ringa.hunting.Presentation.Helper.BaseRecyclerViewAdapter.LoadingViewHolder

/**
 * Created by ringa on 25/10/2018.
 */

class BaseRecyclerViewAdapter<T> : RecyclerView.Adapter<RecyclerView.ViewHolder> {

  private var isLoading: Boolean = false
  private var itemArrayList: ArrayList<T>
  private var listener: BaseAdapterInterface
  private var defaultEmptyStateLabel: String = "Empty State"

  var emptyStateDescription: String? = null

  enum class ViewHolderType(val viewHolderType: Int) {
    EMPTY_STATE(0),
    NORMAL_VIEW_HOLDER(1),
    LOADING_VIEW(2),
    FULL_LODING_VIEW(3)
  }

  constructor(listener: BaseAdapterInterface) : super() {
    itemArrayList = ArrayList()
    this.listener = listener
  }

  constructor(emptyStateDescription: String, listener: BaseAdapterInterface) : this(listener) {
    this.emptyStateDescription = emptyStateDescription
  }

  // PUBLIC METHODS
  fun startLoading(){
    isLoading = true
  }
  fun stopLoading(){
    isLoading = false
  }
  fun add(item: T) {
    itemArrayList.add(item)
    this.notifyDataSetChanged()
  }

  fun addAll(itemArray: ArrayList<T>) {
    itemArrayList.addAll(itemArray)
    this.notifyDataSetChanged()
  }

  fun setItemList(itemArray: ArrayList<T>) {
    itemArrayList.clear()
    itemArrayList.addAll(itemArray)
    this.notifyDataSetChanged()
  }

  fun clearItemArray() {
    itemArrayList.clear()
    this.notifyDataSetChanged()
  }

  // OVERRIDE RECYCLER VIEW ADAPTER METHODS
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    when (viewType) {
      ViewHolderType.EMPTY_STATE.viewHolderType -> return listener.onCreateEmptyViewHolder(parent)
      ViewHolderType.NORMAL_VIEW_HOLDER.viewHolderType -> return listener.onCreateViewHolder(parent)
      ViewHolderType.FULL_LODING_VIEW.viewHolderType -> return listener.onCreateFullLoadingViewHolder(parent)
      ViewHolderType.LOADING_VIEW.viewHolderType -> return listener.onCreateLoadingViewHolder(parent)
    }
    return listener.onCreateEmptyViewHolder(parent)
  }

  override fun getItemViewType(position: Int): Int {
    if(isLoading && itemArrayList.size == 0){
      return ViewHolderType.FULL_LODING_VIEW.viewHolderType
    }else if(isLoading && position == itemArrayList.lastIndex+1) {
      return ViewHolderType.LOADING_VIEW.viewHolderType
    } else if (itemArrayList.size == 0) {
      return ViewHolderType.EMPTY_STATE.viewHolderType
    } else {
      return ViewHolderType.NORMAL_VIEW_HOLDER.viewHolderType
    }
  }

  override fun getItemCount(): Int {
    if(isLoading){
      return itemArrayList.size + 1
    }else{
      return if (itemArrayList.size == 0) 1 else itemArrayList.size
    }
  }

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    when (holder.itemViewType) {
      ViewHolderType.EMPTY_STATE.viewHolderType -> bindEmptyStateViewHolder(holder)
      ViewHolderType.NORMAL_VIEW_HOLDER.viewHolderType -> mBindViewHolder(holder, position)
      ViewHolderType.FULL_LODING_VIEW.viewHolderType -> bindFullLoadingViewHolder(holder)
      ViewHolderType.LOADING_VIEW.viewHolderType -> bindLoadingViewHolder(holder)
    }
  }

  // PRIVATE FUNCTIONS

  //bind normal view holder
  private fun mBindViewHolder(holder: RecyclerView.ViewHolder, postion: Int) {
    val viewHolder = holder as BaseViewHolder<T>
    viewHolder.setupData(itemArrayList[postion])
  }

  //bind empty view holder
  private fun bindEmptyStateViewHolder(holder: RecyclerView.ViewHolder) {
    val emptyViewHolder = holder as EmptyViewHolder
    if (emptyStateDescription != null) {
      emptyViewHolder.emptyTextView.text = emptyStateDescription
    } else {
      emptyViewHolder.emptyTextView.text = defaultEmptyStateLabel
    }
  }
  private fun bindFullLoadingViewHolder(holder:RecyclerView.ViewHolder){
    val fullLoadingViewHolder = holder as FullLoadingViewHolder
  }
  private fun bindLoadingViewHolder(holder:RecyclerView.ViewHolder){
    val loadingViewHolder = holder as LoadingViewHolder
  }
}