package hunting.kotlin.com.example.ringa.hunting.Presentation.BottomNavigation.BottomNavigationItems.PositionItem.PositionsFinished

import hunting.kotlin.com.example.ringa.hunting.Domain.Interactors.PositionsInteractor

class PositionsFinishedPresenter:PositionsFinishedPresenterLogic{
  var viewLogic: PositionsFinishedFragmentLogic? = null
  override fun getFinishedPositions(){
    PositionsInteractor()
      .getFinishedPositions { isSuccess, positionArray, errorMessage->
        if(isSuccess){
          viewLogic?.displayFinishedPositions(positionArray!!)
        }else{
          viewLogic?.displayApiErrorMessage(errorMessage!!)
        }
      }
  }
}