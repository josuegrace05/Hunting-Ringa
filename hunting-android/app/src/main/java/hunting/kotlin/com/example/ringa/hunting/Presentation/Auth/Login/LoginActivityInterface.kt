package hunting.kotlin.com.example.ringa.hunting.Presentation.Auth.Login

import hunting.kotlin.com.example.ringa.hunting.Domain.Entities.User

interface LoginActivityInterface {
    fun closeActivity(token:String)
    fun displayApiErrorMessage(errorMessage: String)
}