package hunting.kotlin.com.example.ringa.hunting.Domain.Entities

import com.google.gson.annotations.SerializedName

data class Profile(
  @SerializedName("id")
  val id: Int,
  @SerializedName("first_name")
  val firstName: String,
  @SerializedName("second_name")
  val secondName: String,
  @SerializedName("date_birth")
  val dateBirth: String,
  @SerializedName("country")
  val country: String,
  @SerializedName("city")
  val city: String,
  @SerializedName("linkedin_url")
  val linkedinUrl: String,
  @SerializedName("user_cv_url")
  val userCvUrl: String,
  @SerializedName("industries_ids")
  val industriesIds: ArrayList<Int>,
  @SerializedName("areas_ids")
  val areasIds: ArrayList<Int>,
  @SerializedName("positions_ids")
  val positionsIds: ArrayList<Int>
)