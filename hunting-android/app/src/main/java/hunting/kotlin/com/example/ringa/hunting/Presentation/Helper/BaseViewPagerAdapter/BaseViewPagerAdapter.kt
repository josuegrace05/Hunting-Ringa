package hunting.kotlin.com.example.ringa.hunting.Presentation.Helper.BaseViewPagerAdapter


import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class BaseViewPagerAdapter: FragmentPagerAdapter {
  var tabLayoutItemArrayList:ArrayList<TabLayoutItem>
  constructor(fragmentManager: FragmentManager, tabLayoutItemArrayList:ArrayList<TabLayoutItem>):super(fragmentManager){
    this.tabLayoutItemArrayList= tabLayoutItemArrayList
  }

  override fun getItem(position: Int): Fragment {
    return tabLayoutItemArrayList[position].fragment
  }

  override fun getCount(): Int {
    return tabLayoutItemArrayList.size
  }

  override fun getPageTitle(position: Int): CharSequence? {
    return tabLayoutItemArrayList[position].itemTitle
  }
}