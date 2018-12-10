package hunting.kotlin.com.example.ringa.hunting.Infrastructure.Retrofit.ResponseModel

import com.google.gson.annotations.SerializedName
import hunting.kotlin.com.example.ringa.hunting.Domain.Entities.Ranking

class RankingResponseModel(
  @SerializedName("ranking")
  var ranking:Ranking
)