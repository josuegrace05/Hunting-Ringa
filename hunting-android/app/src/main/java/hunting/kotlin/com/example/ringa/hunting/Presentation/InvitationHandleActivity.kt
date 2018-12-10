package hunting.kotlin.com.example.ringa.hunting.Presentation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import hunting.kotlin.com.example.ringa.hunting.R

class InvitationHandleActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val appLinkIntent = intent
    val appLinkAction = appLinkIntent.action
    val appLinkData = appLinkIntent.data

    handleIntent(intent)
  }

  override fun onNewIntent(intent: Intent) {
    super.onNewIntent(intent)
    handleIntent(intent)
  }

  private fun handleIntent(intent: Intent) {
    val appLinkAction = intent.action
    val appLinkData: Uri? = intent.data
    if (Intent.ACTION_VIEW == appLinkAction) {
      appLinkData?.lastPathSegment?.also { recipeId ->
        Uri.parse("content://com.recipe_app/recipe/")
          .buildUpon()
          .appendPath(recipeId)
          .build().also { appData ->
            Log.d("teste", appData.toString())
          }
      }
    }
  }
}