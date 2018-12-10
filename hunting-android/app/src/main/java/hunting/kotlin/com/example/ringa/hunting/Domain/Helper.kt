package hunting.kotlin.com.example.ringa.hunting.Domain

import hunting.kotlin.com.example.ringa.hunting.Domain.Entities.Contact

class Helper {
  fun mergeContacts(firstArray: ArrayList<Contact>, secondArray: ArrayList<Contact>):ArrayList<Contact>{
    firstArray.forEach { firstContact ->
      secondArray.forEach { secondContact ->
        if(!firstContact.name.equals(secondContact.name)){
          firstArray.add(secondContact)
        }
      }
    }
    return firstArray
  }
}