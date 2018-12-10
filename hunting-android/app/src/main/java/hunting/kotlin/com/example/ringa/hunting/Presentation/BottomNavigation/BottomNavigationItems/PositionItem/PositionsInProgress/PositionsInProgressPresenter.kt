package hunting.kotlin.com.example.ringa.hunting.Presentation.BottomNavigation.BottomNavigationItems.PositionItem.PositionsInProgress

import hunting.kotlin.com.example.ringa.hunting.Domain.Interactors.PositionsInteractor

class PositionsInProgressPresenter:PositionsInProgressPresenterLogic{
  var viewLogic: PositionsInProgressFragmentLogic? = null
  override fun getInProgressPositions(){
    PositionsInteractor()
      .getInProgressPositions { isSuccess, positionArray, errorMessage->
        if(isSuccess){
          viewLogic?.displayInProgressPositions(positionArray!!)
        }else{
          viewLogic?.displayApiErrorMessage(errorMessage!!)
        }
      }
  }

}