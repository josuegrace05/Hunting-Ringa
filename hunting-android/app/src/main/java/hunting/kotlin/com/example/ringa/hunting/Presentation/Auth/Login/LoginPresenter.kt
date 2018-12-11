package hunting.kotlin.com.example.ringa.hunting.Presentation.Auth.Login

import hunting.kotlin.com.example.ringa.hunting.Domain.Interactors.SessionInteractor

class LoginPresenter(): LoginPresenterInterface{

    var viewLoigc: LoginActivityInterface? = null

    override fun Login(email:String, password:String){
        SessionInteractor().login(email,password){isSuccess, token, errorMessage ->
            if(isSuccess){
                viewLoigc?.closeActivity(token!!)
            }else{
                viewLoigc?.displayApiErrorMessage(errorMessage!!)
            }
        }
    }
}