package hunting.kotlin.com.example.ringa.hunting.Domain.Entities

import com.google.gson.annotations.SerializedName

data class Contact (
  @SerializedName("id")
  val id:Int,
  @SerializedName("name")
  val name:String,
  @SerializedName("phone_number")
  val phone:String)