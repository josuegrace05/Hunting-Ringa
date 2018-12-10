package hunting.kotlin.com.example.ringa.hunting.Domain.Interactors

import hunting.kotlin.com.example.ringa.hunting.Domain.Entities.Contact
import hunting.kotlin.com.example.ringa.hunting.Domain.Entities.Profile
import hunting.kotlin.com.example.ringa.hunting.Domain.Entities.Ranking
import hunting.kotlin.com.example.ringa.hunting.Domain.Entities.ReferredModel
import hunting.kotlin.com.example.ringa.hunting.Infrastructure.Retrofit.Requests.UserRequest

class UserInteractor {
  fun getUserContacts(completion:(isSuccess:Boolean, contactArrayList: ArrayList<Contact>?, errorMessage:String?)->(Unit)){
    UserRequest().getUserContacts(){ isSuccess, contactArrayList, errorMessage->
      if(isSuccess){
        completion(true,contactArrayList,errorMessage)
      }else{
        completion(false,null,errorMessage)
      }
    }
  }
  fun addUserContacts(contactArrayList:ArrayList<Contact>,completion:(isSuccess:Boolean, message: String?, errorMessage:String?)->(Unit)){
    UserRequest().addUserContacts(contactArrayList) { isSuccess, message, errorMessage->
      if(isSuccess){
        completion(true,message,errorMessage)
      }else{
        completion(false,null,errorMessage)
      }
    }
  }
  fun removeUserContact(contactId:Int,completion:(isSuccess:Boolean, message: String?, errorMessage:String?)->(Unit)){
    UserRequest().removeUserContact(contactId) { isSuccess, message, errorMessage->
      if(isSuccess){
        completion(true,message,errorMessage)
      }else{
        completion(false,null,errorMessage)
      }
    }
  }
  fun getUserProfile(completion:(isSuccess:Boolean, profile: Profile?, errorMessage:String?)->(Unit)){
    UserRequest().getUserProfile() { isSuccess, profile, errorMessage->
      if(isSuccess){
        completion(true,profile,errorMessage)
      }else{
        completion(false,null,errorMessage)
      }
    }
  }
  fun getUserRanking(completion:(isSuccess:Boolean, ranking: Ranking?, errorMessage:String?)->(Unit)){
    UserRequest().getUserRanking() { isSuccess, ranking, errorMessage->
      if(isSuccess){
        completion(true,ranking,errorMessage)
      }else{
        completion(false,null,errorMessage)
      }
    }
  }
  fun getUserRankingReferred(interval:String,completion:(isSuccess:Boolean, referredModel: ReferredModel?, errorMessage:String?)->(Unit)){
    UserRequest().getUserRankingReferred() { isSuccess,referredModel, errorMessage->
      if(isSuccess){
        completion(true,referredModel,errorMessage)
      }else{
        completion(false,null,errorMessage)
      }
    }
  }
}