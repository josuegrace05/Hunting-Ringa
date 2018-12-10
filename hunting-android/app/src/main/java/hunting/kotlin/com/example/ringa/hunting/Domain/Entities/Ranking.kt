package hunting.kotlin.com.example.ringa.hunting.Domain.Entities

import com.google.gson.annotations.SerializedName

class Ranking(
  @SerializedName("statistics_graphic")
  val statisticsGraphic: ArrayList<Int>,
  @SerializedName("account_graphic")
  val accountGraphic:  ArrayList<Int>,
  @SerializedName("view_graphic")
  val viewGraphic: ArrayList<Int>,
  @SerializedName("withdraw_graphic")
  val withDrawGraphic: ArrayList<Int>,
  @SerializedName("referred_profile")
  val referredProfile: Int,
  @SerializedName("referred_profile")
  val earned: Int,
  @SerializedName("referred_profile")
  val rating: Float,
  @SerializedName("referred_profile")
  val referredModel: ReferredModel

)