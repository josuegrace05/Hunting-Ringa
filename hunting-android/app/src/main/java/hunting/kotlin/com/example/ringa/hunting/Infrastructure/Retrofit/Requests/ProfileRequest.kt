package hunting.kotlin.com.example.ringa.hunting.Infrastructure.Retrofit.Requests

import hunting.kotlin.com.example.ringa.hunting.Domain.Entities.Profile
import hunting.kotlin.com.example.ringa.hunting.Infrastructure.Retrofit.RequestConverter
import hunting.kotlin.com.example.ringa.hunting.Infrastructure.Retrofit.RingaApiService

class ProfileRequest{

  fun getProfilesByPositionId(positionId:Int,completion:(isSuccess:Boolean, profileArrayList: ArrayList<Profile>?, errorMessage:String?)->Unit){
    RingaApiService.create().getProfilesByPositionId(positionId.toString()).enqueue(
      RequestConverter(){
        if(it.success){
          completion(true,it.responseModel?.profileArrayList,null)
        }else{
          completion(false,null,it.errorMessage)
        }
      })
  }
}