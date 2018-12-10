package hunting.kotlin.com.example.ringa.hunting.Presentation.BottomNavigation

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import hunting.kotlin.com.example.ringa.hunting.HuntingApplication
import hunting.kotlin.com.example.ringa.hunting.Infrastructure.SessionManager
import hunting.kotlin.com.example.ringa.hunting.Presentation.Auth.Login.LoginActivity
import hunting.kotlin.com.example.ringa.hunting.Presentation.BottomNavigation.BottomNavigationItems.ContactsItem.ContactsFragment
import hunting.kotlin.com.example.ringa.hunting.Presentation.BottomNavigation.BottomNavigationItems.PositionItem.PositionsFragment
import hunting.kotlin.com.example.ringa.hunting.Presentation.BottomNavigation.BottomNavigationItems.ProfileItem.ProfileFragment
import hunting.kotlin.com.example.ringa.hunting.Presentation.BottomNavigation.BottomNavigationItems.RankingItem.RankingFragment
import hunting.kotlin.com.example.ringa.hunting.R


class MainActivity : AppCompatActivity() {

  var bottomNavigation: BottomNavigationView? = null

  val contactsFragment =
    ContactsFragment()
  val positionsFragment = PositionsFragment()
  val profileFragment =
    ProfileFragment()
  val rankingFragment =
    RankingFragment()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContentView(R.layout.activity_main)
    getContactsPermission()
    setupMainNavigationView()
      if(!SessionManager().isLogged()){
          startActivity(Intent(this,LoginActivity::class.java))
      }
  }

  fun setupMainNavigationView() {
    bottomNavigation = findViewById(R.id.main_bottom_navigation_view)
    bottomNavigation?.getMenu()?.findItem(R.id.bottom_navigatiom_item_positions)?.setChecked(true);
    bottomNavigation?.setOnNavigationItemSelectedListener() {
      when (it.itemId) {
        R.id.bottom_navigatiom_item_positions -> selectItemPosition()
        R.id.bottom_navigatiom_item_contacts -> selectItemContact()
        R.id.bottom_navigatiom_item_ranking -> selectItemRanking()
        R.id.bottom_navigatiom_item_profile -> selectItemProfile()
        else -> {
          selectItemPosition()
        }
      }
    }
    //select initial Item
    selectItemPosition()
  }

  fun selectItemPosition(): Boolean {
    setFragment(positionsFragment)
    return true
  }

  fun selectItemContact(): Boolean {
    setFragment(contactsFragment)
    return true
  }

  fun selectItemRanking(): Boolean {
    setFragment(rankingFragment)
    return true
  }

  fun selectItemProfile(): Boolean {
    setFragment(profileFragment)
    return true
  }

  fun setFragment(fragment: Fragment) {
    val fragmentManager = getSupportFragmentManager()
    fragmentManager.beginTransaction()
      .replace(R.id.bottom_navigatiom_frame, fragment, "bottom_bar_fragment")
      .commit();
  }

  fun getContactsPermission() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(
        Manifest.permission.READ_CONTACTS
      ) != PackageManager.PERMISSION_GRANTED
    ) {
      requestPermissions(
        arrayOf(Manifest.permission.READ_CONTACTS), 1
      )
      //callback onRequestPermissionsResult
    } else {
    }
  }
  override fun onRequestPermissionsResult(
    requestCode: Int, permissions: Array<out String>,
    grantResults: IntArray
  ) {
    if (requestCode == 1) {
      if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

      } else {
        //  toast("Permission must be granted in order to display contacts information")
      }
    }
  }
}
