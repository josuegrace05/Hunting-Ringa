package hunting.kotlin.com.example.ringa.hunting

import android.app.Application
import android.content.Context

class MyApplication: Application() {
  init {
    instance = this
  }

  companion object {
    private var instance: MyApplication? = null
    fun applicationContext() : Context? {
      return instance!!.applicationContext
    }
  }

  override fun onCreate() {
    super.onCreate()
  }

}