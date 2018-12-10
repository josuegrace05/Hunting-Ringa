package hunting.kotlin.com.example.ringa.hunting.Domain.Interactors

import hunting.kotlin.com.example.ringa.hunting.Domain.Entities.Position
import hunting.kotlin.com.example.ringa.hunting.Infrastructure.Retrofit.Requests.PositionsRequest

class PositionsInteractor {
  fun getNewPositions(completion:(isSuccess:Boolean, positionArray:ArrayList<Position>?, errorMessage:String?)->(Unit)){
    PositionsRequest()
      .getNewPositions { isSuccess, positionArrayList, errorMessage->
      if(isSuccess){
        completion(true,positionArrayList,errorMessage)
      }else{
        completion(false,null,errorMessage)
      }
    }
  }
  fun getInProgressPositions(completion:(isSuccess:Boolean, positionArray:ArrayList<Position>?, errorMessage:String?)->(Unit)){
    PositionsRequest()
      .getInProgressPositions { isSuccess, positionArrayList, errorMessage->
      if(isSuccess){
        completion(true,positionArrayList,errorMessage)
      }else{
        completion(false,null,errorMessage)
      }
    }
  }
  fun getFinishedPositions(completion:(isSuccess:Boolean, positionArray:ArrayList<Position>?, errorMessage:String?)->(Unit)){
    PositionsRequest()
      .getFinishedPositions { isSuccess, positionArrayList, errorMessage->
      if(isSuccess){
        completion(true,positionArrayList,errorMessage)
      }else{
        completion(false,null,errorMessage)
      }
    }
  }
  fun getPositionById(positionId:Int,completion:(isSuccess:Boolean, position: Position?, errorMessage:String?)->(Unit)){
    PositionsRequest()
      .getPositionById(positionId) { isSuccess, position, errorMessage->
      if(isSuccess){
        completion(true,position,errorMessage)
      }else{
        completion(false,null,errorMessage)
      }
    }
  }
}