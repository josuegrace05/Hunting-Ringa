package hunting.kotlin.com.example.ringa.hunting.Infrastructure.Retrofit

import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * Created by ringa on 30/10/2018.
 */

class RequestConverter<T>: Callback<T> {
  constructor(callbackHandler:((converterResponse : ConverterResponse<T>) -> Unit)){
    this.callbackHandler = callbackHandler
  }
  data class ConverterResponse<T>(var success:Boolean, var responseModel:T?, var errorMessage:String?, var status:Int)
  var callbackHandler: ((converterReponse : ConverterResponse<T>)->Unit)? = null

  override fun onFailure(call: Call<T>?, t: Throwable?) {
    callbackHandler?.invoke(ConverterResponse(false,null,t?.localizedMessage.toString(),-1))
    callbackHandler = null
  }

  override fun onResponse(call: Call<T>?, response: Response<T>?) {
    if(response != null && response.isSuccessful()){
      callbackHandler?.invoke(ConverterResponse(true,response.body(),null,response.code()))
    }else{
      val jObjError = JSONObject (response?.errorBody()?.string())
      callbackHandler?.invoke(ConverterResponse(false,null,jObjError.toString(),response?.code() ?: -1))
    }
    callbackHandler = null
  }
}