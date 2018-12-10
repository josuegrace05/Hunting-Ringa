package hunting.kotlin.com.example.ringa.hunting

import android.app.Application
import android.content.Context

class HuntingApplication: Application() {
  init {
    instance = this
  }

  companion object {
    private var instance: HuntingApplication? = null
    fun applicationContext() : Context? {
      return instance!!.applicationContext
    }
  }

  override fun onCreate() {
    super.onCreate()
  }

}