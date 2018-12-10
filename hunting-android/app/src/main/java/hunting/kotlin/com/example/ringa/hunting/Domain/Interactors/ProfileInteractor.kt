package hunting.kotlin.com.example.ringa.hunting.Domain.Interactors

import hunting.kotlin.com.example.ringa.hunting.Domain.Entities.Profile
import hunting.kotlin.com.example.ringa.hunting.Infrastructure.Retrofit.Requests.ProfileRequest

class ProfileInteractor {
  fun getProfilesByPositionId(positionId:Int,completion:(isSuccess:Boolean, profileArrayList:ArrayList<Profile>?, errorMessage:String?)->(Unit)){
    ProfileRequest()
      .getProfilesByPositionId(positionId) { isSuccess, profileArrayList, errorMessage->
      if(isSuccess){
        completion(true,profileArrayList,errorMessage)
      }else{
        completion(false,null,errorMessage)
      }
    }
  }
}