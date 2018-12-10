package hunting.kotlin.com.example.ringa.hunting.Infrastructure.Retrofit.Requests

import hunting.kotlin.com.example.ringa.hunting.Infrastructure.Retrofit.RequestConverter
import hunting.kotlin.com.example.ringa.hunting.Infrastructure.Retrofit.RingaApiService

class SessionRequest {
  fun login(email:String,password:String,completion:(isSuccess:Boolean, message: String?, errorMessage:String?)->Unit){
    RingaApiService.create().login(email,password).enqueue(
      RequestConverter(){
        if(it.success){
          completion(true,it.responseModel?.tokenVal,null)
        }else{
          completion(false,null,it.errorMessage)
        }
      })
  }
  fun logout(completion:(isSuccess:Boolean, message: String?, errorMessage:String?)->Unit){
    RingaApiService.create().logout().enqueue(
      RequestConverter(){
        if(it.success){
          completion(true,it.responseModel?.message,null)
        }else{
          completion(false,null,it.errorMessage)
        }
      })
  }
  fun signIn(email:String,password:String,completion:(isSuccess:Boolean, message: String?, errorMessage:String?)->Unit){
    RingaApiService.create().signIn().enqueue(
      RequestConverter(){
        if(it.success){
          completion(true,it.responseModel?.message,null)
        }else{
          completion(false,null,it.errorMessage)
        }
      })
  }
}