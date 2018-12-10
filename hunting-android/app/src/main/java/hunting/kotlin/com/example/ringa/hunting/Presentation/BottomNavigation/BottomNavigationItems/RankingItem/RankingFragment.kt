package hunting.kotlin.com.example.ringa.hunting.Presentation.BottomNavigation.BottomNavigationItems.RankingItem

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.DataPoint
import hunting.kotlin.com.example.ringa.hunting.R
import com.jjoe64.graphview.series.LineGraphSeries



class RankingFragment:Fragment() {
  var graphView: GraphView? = null

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
  {
    val view = inflater.inflate(R.layout.fragment_ranking,container, false)
    graphView = view.findViewById(R.id.ranking_graph_view)
    val series = LineGraphSeries<DataPoint>(
      arrayOf<DataPoint>(
        DataPoint(0.toDouble(), 1.toDouble()),
        DataPoint(1.toDouble(), 5.toDouble()),
        DataPoint(2.toDouble(), 3.toDouble()),
        DataPoint(3.toDouble(), 2.toDouble()),
        DataPoint(4.toDouble(), 6.toDouble())
      )
    )
    graphView?.addSeries(series)
    return view
  }

}