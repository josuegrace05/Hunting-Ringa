package hunting.kotlin.com.example.ringa.hunting.Presentation.Helper.MenuFloatingButton

import android.support.design.widget.FloatingActionButton
import android.view.View
import hunting.kotlin.com.example.ringa.hunting.MyApplication
import hunting.kotlin.com.example.ringa.hunting.R

class MenuFloatingButton(menuFloatingButton:FloatingActionButton){
  var floatingButtonArray:ArrayList<MenuFloatingButtonItem> = ArrayList()
  var isFABOpen = false
  var listener:MenuFloatingButtonInterface? = null
  init{
    menuFloatingButton?.setOnClickListener(object : View.OnClickListener {
      override fun onClick(view: View) {
      if(isFABOpen){
        closeFABMenu()
      } else {
        openFABMenu()
      }
      }
    })
  }

  fun addFloatingActionButton(floatingButton:FloatingActionButton,tag:String){
    floatingButtonArray.add(MenuFloatingButtonItem(floatingButton,tag))
    floatingButton.setOnClickListener { view ->
      floatingButtonArray.forEach { menuFloatingButton ->
        if(view == menuFloatingButton.floatingActionButton){
         listener?.onFloatingActionButtonClicked(menuFloatingButton)
        }
      }
    }
  }
  private fun openFABMenu() {
    isFABOpen = true
    for(position in floatingButtonArray.indices){
      floatingButtonArray[position].floatingActionButton.animate()?.translationY(- getTranslation()*(position+1))
    }
  }
  private fun getTranslation():Float{
    return  MyApplication.applicationContext()?.resources?.getDimension(R.dimen.standard_64) ?: 0.toFloat()
  }

  private fun closeFABMenu() {
    isFABOpen = false
    for(position in floatingButtonArray.indices){
      floatingButtonArray[position].floatingActionButton.animate()?.translationY(0.toFloat())
    }}
}