package hunting.kotlin.com.example.ringa.hunting.Presentation.BottomNavigation.BottomNavigationItems.PositionItem.PositionDetails

import hunting.kotlin.com.example.ringa.hunting.Domain.Interactors.PositionsInteractor


class PositionDetailsPresenter:PositionDetailsPresenterLogic {
  var viewLogic: PositionDetailsActivityLogic? = null
  override fun getPositionById(positionId: Int) {
    PositionsInteractor().getPositionById(positionId){ isSuccess, position, errorMessage ->
      if(isSuccess){
        viewLogic?.displayPosition(position!!)
      }else{
        viewLogic?.displayApiErrorMessage(errorMessage!!)
      }
    }
  }
}