package hunting.kotlin.com.example.ringa.hunting.Presentation.BottomNavigation.BottomNavigationItems.PositionItem.PositionsFinished

import hunting.kotlin.com.example.ringa.hunting.Domain.Entities.Position

interface PositionsFinishedFragmentLogic {
  fun displayApiErrorMessage(message:String)
  fun displayFinishedPositions(newPositionsArrayList:ArrayList<Position>)
}