package hunting.kotlin.com.example.ringa.hunting.Domain.Entities

import com.google.gson.annotations.SerializedName

class ReferredModel(
  @SerializedName("total_referred")
  val totalReferred:Int,
  @SerializedName("open_cv")
  val openCv:Int,
  @SerializedName("interview")
  val interviewed:Int,
  @SerializedName("hired")
  val hired:Int
)