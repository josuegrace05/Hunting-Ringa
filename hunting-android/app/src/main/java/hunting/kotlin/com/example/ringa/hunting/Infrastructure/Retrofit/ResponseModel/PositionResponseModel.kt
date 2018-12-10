package hunting.kotlin.com.example.ringa.hunting.Infrastructure.Retrofit.ResponseModel

import com.google.gson.annotations.SerializedName
import hunting.kotlin.com.example.ringa.hunting.Domain.Entities.Position

class PositionResponseModel (
  @SerializedName("position")
  var position: Position
)