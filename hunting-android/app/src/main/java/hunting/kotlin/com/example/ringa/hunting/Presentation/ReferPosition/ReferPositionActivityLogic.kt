package hunting.kotlin.com.example.ringa.hunting.Presentation.ReferPosition

import hunting.kotlin.com.example.ringa.hunting.Domain.Entities.Profile

interface ReferPositionActivityLogic {
  fun displayApiErrorMessage(message:String)
  fun displayProfiles(profileArrayList: ArrayList<Profile>)
}