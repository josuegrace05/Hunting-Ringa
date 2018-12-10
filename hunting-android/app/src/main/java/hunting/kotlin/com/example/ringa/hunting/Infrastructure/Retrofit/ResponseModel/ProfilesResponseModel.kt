package hunting.kotlin.com.example.ringa.hunting.Infrastructure.Retrofit.ResponseModel


import com.google.gson.annotations.SerializedName
import hunting.kotlin.com.example.ringa.hunting.Domain.Entities.Profile


data class ProfilesResponseModel(
  @SerializedName("profiles")
  var profileArrayList:ArrayList<Profile>
)