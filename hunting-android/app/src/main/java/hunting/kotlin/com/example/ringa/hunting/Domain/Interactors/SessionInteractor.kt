package hunting.kotlin.com.example.ringa.hunting.Domain.Interactors

import hunting.kotlin.com.example.ringa.hunting.Domain.Entities.User
import hunting.kotlin.com.example.ringa.hunting.Infrastructure.Retrofit.Requests.SessionRequest

class SessionInteractor {
  fun login(email:String,password:String,completion:(isSuccess:Boolean, userData:User?, errorMessage:String?)->(Unit)){
    SessionRequest().
      login(email,password) { isSuccess, userData, errorMessage->
        if(isSuccess){
          completion(true,userData,errorMessage)
        }else{
          completion(false,null,errorMessage)
        }
      }
  }

  fun logout(completion:(isSuccess:Boolean, message:String?, errorMessage:String?)->(Unit)){
    SessionRequest().
      logout() { isSuccess, message, errorMessage->
        if(isSuccess){
          completion(true,message,errorMessage)
        }else{
          completion(false,null,errorMessage)
        }
      }
  }
  fun signIn(email:String,password:String,completion:(isSuccess:Boolean, message:String?, errorMessage:String?)->(Unit)){
    SessionRequest().
      logout() { isSuccess, message, errorMessage->
        if(isSuccess){
          completion(true,message,errorMessage)
        }else{
          completion(false,null,errorMessage)
        }
      }
  }

}