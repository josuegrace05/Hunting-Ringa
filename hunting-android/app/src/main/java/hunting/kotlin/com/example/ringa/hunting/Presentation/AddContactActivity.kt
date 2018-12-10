package hunting.kotlin.com.example.ringa.hunting.Presentation

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import hunting.kotlin.com.example.ringa.hunting.R

class AddContactActivity:AppCompatActivity(){
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_add_contact)
  }
  fun sendButtonClicked(view: View){
    val sendIntent = Intent()
    sendIntent.action = Intent.ACTION_SEND
    sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
    sendIntent.type = "text/plain"
    startActivity(Intent.createChooser(sendIntent,"Continuar com"))
  }
}