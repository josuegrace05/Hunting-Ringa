package hunting.kotlin.com.example.ringa.hunting.Infrastructure.Retrofit.Requests

import hunting.kotlin.com.example.ringa.hunting.Domain.Entities.Contact
import hunting.kotlin.com.example.ringa.hunting.Domain.Entities.Profile
import hunting.kotlin.com.example.ringa.hunting.Domain.Entities.Ranking
import hunting.kotlin.com.example.ringa.hunting.Domain.Entities.ReferredModel
import hunting.kotlin.com.example.ringa.hunting.Infrastructure.Retrofit.RequestConverter
import hunting.kotlin.com.example.ringa.hunting.Infrastructure.Retrofit.RingaApiService

class UserRequest {
  fun getUserContacts(completion:(isSuccess:Boolean, contactArrayList: ArrayList<Contact>?, errorMessage:String?)->Unit){
    RingaApiService.create().getMyContacts().enqueue(
      RequestConverter(){
        if(it.success){
          completion(true,it.responseModel?.contactArrayList,null)
        }else{
          completion(false,null,it.errorMessage)
        }
      })
  }
  fun addUserContacts(contactArrayList:ArrayList<Contact>, completion:(isSuccess:Boolean, message: String?, errorMessage:String?)->Unit){
    RingaApiService.create().addMyContact().enqueue(
      RequestConverter(){
        if(it.success){
          completion(true,it.responseModel?.message,null)
        }else{
          completion(false,null,it.errorMessage)
        }
      })
  }
  fun removeUserContact(contactId:Int,completion:(isSuccess:Boolean, message: String?, errorMessage:String?)->Unit){
    RingaApiService.create().removeMyContact(contactId.toString()).enqueue(
      RequestConverter(){
        if(it.success){
          completion(true,it.responseModel?.message,null)
        }else{
          completion(false,null,it.errorMessage)
        }
      })
  }
  fun getUserProfile(completion:(isSuccess:Boolean, profile: Profile?, errorMessage:String?)->Unit){
    RingaApiService.create().getMyProfile().enqueue(
      RequestConverter(){
        if(it.success){
          completion(true,it.responseModel?.profile,null)
        }else{
          completion(false,null,it.errorMessage)
        }
      })
  }
  fun getUserRanking(completion:(isSuccess:Boolean, ranking: Ranking?, errorMessage:String?)->Unit){
    RingaApiService.create().getMyRanking().enqueue(
      RequestConverter(){
        if(it.success){
          completion(true,it.responseModel?.ranking,null)
        }else{
          completion(false,null,it.errorMessage)
        }
      })
  }
  fun getUserRankingReferred(completion:(isSuccess:Boolean, referredModel: ReferredModel?, errorMessage:String?)->Unit){
    RingaApiService.create().getMyRankingReferred().enqueue(
      RequestConverter(){
        if(it.success){
          completion(true,it.responseModel?.referredModel,null)
        }else{
          completion(false,null,it.errorMessage)
        }
      })
  }
}