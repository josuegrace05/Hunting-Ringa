package hunting.kotlin.com.example.ringa.hunting.Presentation.ReferPosition

import hunting.kotlin.com.example.ringa.hunting.Domain.Interactors.ProfileInteractor

class ReferPositionPresenter:ReferPositionPresenterLogic {
  var viewLogic: ReferPositionActivityLogic? = null
  override fun getProfilesByPositionId(positionId: Int) {
    ProfileInteractor().getProfilesByPositionId(positionId){ isSuccess, profileArrayList, errorMessage ->
      if(isSuccess){
        viewLogic?.displayProfiles(profileArrayList!!)
      }else{
        viewLogic?.displayApiErrorMessage(errorMessage!!)
      }
    }
  }
}