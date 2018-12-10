package hunting.kotlin.com.example.ringa.hunting.Presentation.BottomNavigation.BottomNavigationItems.PositionItem.PositionsInProgress

import hunting.kotlin.com.example.ringa.hunting.Domain.Entities.Position

interface PositionsInProgressFragmentLogic {
  fun displayApiErrorMessage(message:String)
  fun displayInProgressPositions(newPositionsArrayList:ArrayList<Position>)
}