package hunting.kotlin.com.example.ringa.hunting.Presentation.BottomNavigation.BottomNavigationItems.PositionItem.PositionDetails

import hunting.kotlin.com.example.ringa.hunting.Domain.Entities.Position

interface PositionDetailsActivityLogic {
  fun displayApiErrorMessage(message:String)
  fun displayPosition(position: Position)
}