package hunting.kotlin.com.example.ringa.hunting.Infrastructure.Retrofit.Requests

import hunting.kotlin.com.example.ringa.hunting.Domain.Entities.Position
import hunting.kotlin.com.example.ringa.hunting.Infrastructure.Retrofit.RequestConverter
import hunting.kotlin.com.example.ringa.hunting.Infrastructure.Retrofit.RingaApiService

class PositionsRequest(){
  fun getNewPositions(completion:(isSuccess:Boolean, positionArrayList: ArrayList<Position>?, errorMessage:String?)->Unit){
    RingaApiService.create().getPositionsNew().enqueue(
      RequestConverter(){
        if(it.success){
          completion(true,it.responseModel?.positionArrayList,null)
        }else{
          completion(false,null,it.errorMessage)
        }
      }
    )
  }
  fun getInProgressPositions(completion:(isSuccess:Boolean, positionArrayList: ArrayList<Position>?, errorMessage:String?)->Unit){
    RingaApiService.create().getPositionsInProgress().enqueue(
      RequestConverter(){
        if(it.success){
          completion(true,it.responseModel?.positionArrayList,null)
        }else{
          completion(false,null,it.errorMessage)
        }
      }
    )
  }
  fun getFinishedPositions(completion:(isSuccess:Boolean, positionArrayList: ArrayList<Position>?, errorMessage:String?)->Unit){
    RingaApiService.create().getPositionsFinished().enqueue(
      RequestConverter(){
        if(it.success){
          completion(true,it.responseModel?.positionArrayList,null)
        }else{
          completion(false,null,it.errorMessage)
        }
      }
    )
  }
  fun getPositionById(positionId:Int,completion:(isSuccess:Boolean, position: Position?, errorMessage:String?)->Unit){
      RingaApiService.create().getPositionById(positionId.toString()).enqueue(
        RequestConverter(){
          if(it.success){
            completion(true,it.responseModel?.position,null)
          }else{
            completion(false,null,it.errorMessage)
          }
        }
      )
  }
}
