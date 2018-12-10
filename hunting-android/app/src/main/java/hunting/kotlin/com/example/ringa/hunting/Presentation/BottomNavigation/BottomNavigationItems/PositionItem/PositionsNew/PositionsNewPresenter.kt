package hunting.kotlin.com.example.ringa.hunting.Presentation.BottomNavigation.BottomNavigationItems.PositionItem.PositionsNew

import hunting.kotlin.com.example.ringa.hunting.Domain.Interactors.PositionsInteractor

class PositionsNewPresenter:PositionsNewPresenterLogic{
  var viewLogic: PositionsNewFragmentLogic? = null
  override fun getNewPositions(){
    PositionsInteractor()
      .getNewPositions { isSuccess, positionArray, errorMessage->
      if(isSuccess){
        viewLogic?.displayNewPositions(positionArray!!)
      }else{
        viewLogic?.displayApiErrorMessage(errorMessage!!)
      }
    }
  }
}