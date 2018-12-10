package hunting.kotlin.com.example.ringa.hunting.Presentation.Auth.Login

import hunting.kotlin.com.example.ringa.hunting.Domain.Entities.User

interface LoginActivityInterface {
    fun finishActitity(userData:User)
    fun displayApiErrorMessage(errorMessage: String)
}