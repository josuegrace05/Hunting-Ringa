package hunting.kotlin.com.example.ringa.hunting.Infrastructure

import android.app.Application
import android.content.SharedPreferences
import hunting.kotlin.com.example.ringa.hunting.Domain.Entities.User
import hunting.kotlin.com.example.ringa.hunting.HuntingApplication

class SessionManager(){

  val PREF_ID : String = "HuntingApp"

  enum class UserKeys(val key:String){
    Name("Name"),
    Email("Email"),
    Token("Token")
  }

  fun saveUserToken(){

  }

  fun getUser(): User{
    val pref: SharedPreferences = HuntingApplication.applicationContext()!!.getSharedPreferences(PREF_ID,0)
    return User(pref.getString(UserKeys.Name.key,"") ?: "",
      pref.getString(UserKeys.Email.key,"") ?: "",pref.getString(UserKeys.Token.key,"") ?: "")
  }

  fun saveUser(user:User){
    val pref: SharedPreferences = HuntingApplication.applicationContext()!!.getSharedPreferences(PREF_ID,0)
    val editor: SharedPreferences.Editor = pref.edit()
    editor.putString(UserKeys.Name.key,user.name)
    editor.putString(UserKeys.Email.key,user.email)
    editor.putString(UserKeys.Token.key,user.token)
    editor.apply()
  }

  fun isLogged():Boolean{
    val pref: SharedPreferences = HuntingApplication.applicationContext()!!.getSharedPreferences(PREF_ID,0)
    val token  = pref.getString(UserKeys.Token.key,"") ?: ""
    return token != ""
  }
}