package hunting.kotlin.com.example.ringa.hunting.Infrastructure.Retrofit

import hunting.kotlin.com.example.ringa.hunting.Infrastructure.Retrofit.ResponseModel.*
import retrofit2.Call
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.util.concurrent.TimeUnit


/**
 * Created by ringa on 19/10/2018.
 */

interface RingaApiService {

  @FormUrlEncoded
  @POST("user/login")
  fun login(@Field("email") email:String, @Field("password") password:String): Call<LoginResponseModel>

  @GET("position/{positionId}")
  fun getPositionById(@Path("positionId")positionId:String): Call<PositionResponseModel>

  @GET("position/new")
  fun getPositionsNew(): Call<PositionsResponseModel>

  @GET("position/inprogress")
  fun getPositionsInProgress(): Call<PositionsResponseModel>

  @GET("position/finished")
  fun getPositionsFinished(): Call<PositionsResponseModel>

  @GET("position/{positionId}/profiles")
  fun getProfilesByPositionId(@Path("positionId") positionId:String):Call<ProfilesResponseModel>

  @GET("user/me/profile")
  fun getMyProfile():Call<ProfileResponseModel>

  @GET("user/me/contacts")
  fun getMyContacts():Call<ContactsResponseModel>

  @POST("user/me/contacts")
  fun addMyContact():Call<MessageResponseModel>

  @DELETE("user/me/contact/{contactId}")
  fun removeMyContact(@Path("contactId")contactId:String):Call<MessageResponseModel>

  @POST("user/logout")
  fun logout(): Call<MessageResponseModel>

  @POST("user/signIn")
  fun signIn(): Call<MessageResponseModel>

  @GET("user/me/ranking")
  fun getMyRanking(): Call<RankingResponseModel>

  @GET("user/me/ranking/referred")
  fun getMyRankingReferred(): Call<ReferredResponseModel>

  @GET("code/generate")
  fun generateMyCode(): Call<CodeResponseModel>

  /** * Companion object to create the RingaApiService */
  companion object Factory {
    fun create(): RingaApiService {
      val httpClient = OkHttpClient.Builder()

      httpClient.addInterceptor(object : Interceptor {
        override fun intercept(chain: Interceptor.Chain?): okhttp3.Response {
          val request = chain?.request()?.newBuilder()
          //request?.addHeader("x-api-key", "bc4559e4c005f6a7fc69eca73f4edc5090cc105ae328e0880de7677b01b7d76cc")
          //request?.addHeader("Content-Type", "application/x-www-form-urlencoded")
          //request?.addHeader("Accept", "application/json")
          //request?.addHeader("token", "")
          return chain!!.proceed(request?.build())
        }
      })
      httpClient.readTimeout(60, TimeUnit.SECONDS);
      httpClient.connectTimeout(5, TimeUnit.SECONDS);
      val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://489dc93c-3bc7-49e9-829c-e2ae96b090a0.mock.pstmn.io/")
        .client(httpClient.build())
        .build()
      return retrofit.create(RingaApiService::class.java);
    }
  }
}