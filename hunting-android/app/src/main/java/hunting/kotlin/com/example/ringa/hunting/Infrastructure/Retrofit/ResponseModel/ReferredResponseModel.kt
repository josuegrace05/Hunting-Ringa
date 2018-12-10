package hunting.kotlin.com.example.ringa.hunting.Infrastructure.Retrofit.ResponseModel

import com.google.gson.annotations.SerializedName
import hunting.kotlin.com.example.ringa.hunting.Domain.Entities.Profile
import hunting.kotlin.com.example.ringa.hunting.Domain.Entities.ReferredModel

class ReferredResponseModel(
  @SerializedName("referred")
  var referredModel:ReferredModel
)