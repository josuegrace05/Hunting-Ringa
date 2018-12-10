package hunting.kotlin.com.example.ringa.hunting.Presentation.BottomNavigation.BottomNavigationItems.PositionItem

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import hunting.kotlin.com.example.ringa.hunting.Presentation.BottomNavigation.BottomNavigationItems.PositionItem.PositionsFinished.PositionsFinishedFragment
import hunting.kotlin.com.example.ringa.hunting.Presentation.BottomNavigation.BottomNavigationItems.PositionItem.PositionsInProgress.PositionsInProgressFragment
import hunting.kotlin.com.example.ringa.hunting.Presentation.BottomNavigation.BottomNavigationItems.PositionItem.PositionsNew.PositionsNewFragment
import hunting.kotlin.com.example.ringa.hunting.Presentation.Helper.BaseViewPagerAdapter.BaseViewPagerAdapter
import hunting.kotlin.com.example.ringa.hunting.Presentation.Helper.BaseViewPagerAdapter.TabLayoutItem
import hunting.kotlin.com.example.ringa.hunting.R

class PositionsFragment(): Fragment() {

  var viewPager : ViewPager? = null
  var tabLayout: TabLayout? = null
  var positionsAdapter:BaseViewPagerAdapter? = null


  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
  {
    val myView = inflater.inflate(R.layout.fragment_positions,container,false)
    viewPager = myView.findViewById(R.id.positions_fragment_view_pager)
    tabLayout = myView.findViewById(R.id.positions_fragment_tab_layout)
    setupAdapter()
    setupViewPager()
    setupTabLayout()
    return myView
  }

  fun setupAdapter(){
    val tabLayoutItemArray:ArrayList<TabLayoutItem> = ArrayList()
    tabLayoutItemArray.add(
      TabLayoutItem(
        PositionsFinishedFragment(),
        getString(R.string.position_tab_layout_finished)
      )
    )
    tabLayoutItemArray.add(
      TabLayoutItem(
        PositionsNewFragment(),
        getString(R.string.position_tab_layout_new)
      )
    )
    tabLayoutItemArray.add(
      TabLayoutItem(
        PositionsInProgressFragment(),
        getString(R.string.position_tab_layout_in_progress)
      )
    )
    positionsAdapter = BaseViewPagerAdapter(childFragmentManager,tabLayoutItemArray)
  }

  fun setupTabLayout(){
    tabLayout?.setupWithViewPager(viewPager)
  }
  fun setupViewPager(){
    viewPager!!.adapter = positionsAdapter
    positionsAdapter?.notifyDataSetChanged()
  }

}

