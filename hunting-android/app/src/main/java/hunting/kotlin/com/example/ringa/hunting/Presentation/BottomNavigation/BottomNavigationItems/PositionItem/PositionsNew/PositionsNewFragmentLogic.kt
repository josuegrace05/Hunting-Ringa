package hunting.kotlin.com.example.ringa.hunting.Presentation.BottomNavigation.BottomNavigationItems.PositionItem.PositionsNew

import hunting.kotlin.com.example.ringa.hunting.Domain.Entities.Position

interface PositionsNewFragmentLogic {
  fun displayApiErrorMessage(message:String)
  fun displayNewPositions(newPositionsArrayList:ArrayList<Position>)
}