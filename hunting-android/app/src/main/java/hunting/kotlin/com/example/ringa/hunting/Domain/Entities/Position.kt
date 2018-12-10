package hunting.kotlin.com.example.ringa.hunting.Domain.Entities

import com.google.gson.annotations.SerializedName

data class Position(
  @SerializedName("id")
  val id:Int,
  @SerializedName("name")
  val name:String,
  @SerializedName("company_name")
  var companyName:String,
  @SerializedName("company_size")
  val companySize:String,
  @SerializedName("company_type")
  val companyType:String,
  @SerializedName("experience")
  val expirience:String,
  @SerializedName("language")
  val language:String,
  @SerializedName("country")
  val country:String,
  @SerializedName("city")
  val city:String,
  @SerializedName("salary")
  val salary:String,
  @SerializedName("description")
  val description:String,
  @SerializedName("referred")
  val referredProfile:Int,
  @SerializedName("status_code")
  val statusCode:Int,
  @SerializedName("is_avaiable")
  var isAvailable:Boolean
  )
