package hunting.kotlin.com.example.ringa.hunting.Infrastructure.Retrofit.ResponseModel

import com.google.gson.annotations.SerializedName
import hunting.kotlin.com.example.ringa.hunting.Domain.Entities.Contact

class ContactsResponseModel (
  @SerializedName("contacts")
  var contactArrayList:ArrayList<Contact>
)