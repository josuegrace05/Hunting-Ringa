package hunting.kotlin.com.example.ringa.hunting.Presentation.BottomNavigation.BottomNavigationItems.PositionItem.PositionDetails

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import hunting.kotlin.com.example.ringa.hunting.Domain.Entities.Position
import hunting.kotlin.com.example.ringa.hunting.MyApplication
import hunting.kotlin.com.example.ringa.hunting.Presentation.Helper.BaseLayoutHolders.TextFieldWithImageAndDescriptionHolder
import hunting.kotlin.com.example.ringa.hunting.Presentation.ReferPosition.ReferPositionActivity
import hunting.kotlin.com.example.ringa.hunting.R

class PositionDetailsActivity : PositionDetailsActivityLogic, AppCompatActivity() {

  var presenter:PositionDetailsPresenterLogic? = null
  init {
    val positionDetailsPresenter = PositionDetailsPresenter()
    positionDetailsPresenter.viewLogic = this@PositionDetailsActivity
    presenter = positionDetailsPresenter
  }

  enum class IntentExtra(val tag:String){
    POSITION_ID("idIntentTag"),
    NAME("nameIntentTag"),
    COMPANY_NAME("companyNameIntentTag")
  }

  var nameTextView: TextView? = null
  var companyNameTextView: TextView? = null
  var companySizeTextViewHolder: TextFieldWithImageAndDescriptionHolder? = null
  var companyTypeTextViewHolder: TextFieldWithImageAndDescriptionHolder? = null
  var experienceTextViewHolder: TextFieldWithImageAndDescriptionHolder? = null
  var languageTextViewHolder: TextFieldWithImageAndDescriptionHolder? = null
  var countryTextViewHolder: TextFieldWithImageAndDescriptionHolder? = null
  var cityTextViewHolder: TextFieldWithImageAndDescriptionHolder? = null
  var salaryTextViewHolder: TextFieldWithImageAndDescriptionHolder? = null
  var descriptionTextView: TextView? = null
  var contentProgressBarLayout: RelativeLayout? = null
  var referButton:Button? = null
  var isProgressLayoutHidden:Boolean = false
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_positions_details)
    initLayoutVariables()
    hideContent()
    populateView()
  }

  override fun onStart() {
    super.onStart()
    if(isProgressLayoutHidden){
      showContent()
    }else{
      hideContent()
    }
  }
  fun referButtonClicked(view: View) {
    val intent = Intent(this, ReferPositionActivity::class.java)
    startActivity(intent)
  }
  fun populateView(){
    val intent = getIntent()
    val name = intent.getStringExtra(IntentExtra.NAME.tag)
    val companyName = intent.getStringExtra(IntentExtra.COMPANY_NAME.tag)
    val positionId = intent.getIntExtra(IntentExtra.POSITION_ID.tag,-1)
    nameTextView?.setText(name)
    companyNameTextView?.setText(companyName)
    presenter?.getPositionById(positionId)
  }

  fun initLayoutVariables() {
    nameTextView = findViewById(R.id.positions_details_name)
    companyNameTextView = findViewById(R.id.positions_details_company_name)

    companySizeTextViewHolder = TextFieldWithImageAndDescriptionHolder(findViewById(R.id.positions_details_company_size))
    companySizeTextViewHolder?.valueTextView?.text = ""
    companySizeTextViewHolder?.setFormattedDescription(getString(R.string.positions_details_company_size))
    companySizeTextViewHolder?.iconImageView?.setImageDrawable(getDrawable(R.drawable.ic_contact_24dp))

    companyTypeTextViewHolder = TextFieldWithImageAndDescriptionHolder(findViewById(R.id.positions_details_company_type))
    companyTypeTextViewHolder?.valueTextView?.text = ""
    companyTypeTextViewHolder?.setFormattedDescription(getString(R.string.positions_details_company_type))
    companyTypeTextViewHolder?.iconImageView?.setImageDrawable(getDrawable(R.drawable.ic_contact_24dp))

    experienceTextViewHolder = TextFieldWithImageAndDescriptionHolder(findViewById(R.id.positions_details_experience))
    experienceTextViewHolder?.valueTextView?.text = ""
    experienceTextViewHolder?.setFormattedDescription(getString(R.string.positions_details_experience))
    experienceTextViewHolder?.iconImageView?.setImageDrawable(getDrawable(R.drawable.ic_contact_24dp))

    languageTextViewHolder = TextFieldWithImageAndDescriptionHolder(findViewById(R.id.positions_details_language))
    languageTextViewHolder?.valueTextView?.text = ""
    languageTextViewHolder?.setFormattedDescription(getString(R.string.positions_details_language))
    languageTextViewHolder?.iconImageView?.setImageDrawable(getDrawable(R.drawable.ic_contact_24dp))

    countryTextViewHolder = TextFieldWithImageAndDescriptionHolder(findViewById(R.id.positions_details_country))
    countryTextViewHolder?.valueTextView?.text = ""
    countryTextViewHolder?.setFormattedDescription(getString(R.string.positions_details_country))
    countryTextViewHolder?.iconImageView?.setImageDrawable(getDrawable(R.drawable.ic_contact_24dp))

    cityTextViewHolder = TextFieldWithImageAndDescriptionHolder(findViewById(R.id.positions_details_city))
    cityTextViewHolder?.valueTextView?.text = ""
    cityTextViewHolder?.setFormattedDescription(getString(R.string.positions_details_city))
    cityTextViewHolder?.iconImageView?.setImageDrawable(getDrawable(R.drawable.ic_contact_24dp))

    salaryTextViewHolder = TextFieldWithImageAndDescriptionHolder(findViewById(R.id.positions_details_salary))
    salaryTextViewHolder?.valueTextView?.text = ""
    salaryTextViewHolder?.setFormattedDescription(getString(R.string.positions_details_salary))
    salaryTextViewHolder?.iconImageView?.setImageDrawable(getDrawable(R.drawable.ic_contact_24dp))

    descriptionTextView = findViewById(R.id.positions_details_description) as TextView
    contentProgressBarLayout =  findViewById(R.id.positions_details_progress_bar_layout) as RelativeLayout

    referButton = findViewById(R.id.positions_details_refer_button) as Button
  }

  fun showContent(){
    //hide progress bar and show content
    referButton?.isEnabled = true
    contentProgressBarLayout?.setVisibility(View.GONE)
    isProgressLayoutHidden = true
  }
  fun hideContent(){
    //show progress bar and hide content
    referButton?.isEnabled = false
    contentProgressBarLayout?.setVisibility(View.VISIBLE)
    isProgressLayoutHidden = false
  }

  fun setupLayout(position: Position?) {
  //  nameTextView?.setText(position?.name ?: "")
  //  companyNameTextView?.setText(position?.companyName ?: "")
    companySizeTextViewHolder?.valueTextView?.setText(position?.companySize ?: "")
    companyTypeTextViewHolder?.valueTextView?.setText(position?.companyType ?: "")
    experienceTextViewHolder?.valueTextView?.setText(position?.expirience ?: "")
    languageTextViewHolder?.valueTextView?.setText(position?.language ?: "")
    countryTextViewHolder?.valueTextView?.setText(position?.country ?: "")
    cityTextViewHolder?.valueTextView?.setText(position?.city ?: "")
    salaryTextViewHolder?.valueTextView?.setText(position?.salary?: "")
    descriptionTextView?.setText(position?.description?: "")
  }
  // Display error message from API
  override fun displayApiErrorMessage(message: String) {
    val layoutView = findViewById(R.id.activity_positions_details_layout) as View
    val mySnackbar = Snackbar.make(layoutView, message, Snackbar.LENGTH_LONG);
    mySnackbar.show();
    setupLayout(null)
    showContent()
  }

  override fun displayPosition(position: Position) {
    setupLayout(position)
    showContent()
  }
  companion object {
    fun startDetailsActivity(activity: Activity, positionNameTextView: TextView, positionCompanyTextView: TextView,positionId:Int) {
      val intent = Intent(activity, PositionDetailsActivity::class.java)
      if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
          activity,
          Pair.create<View, String>(
            positionCompanyTextView,
            MyApplication.applicationContext()?.getString(R.string.positions_details_transition_company)
          ),
          Pair.create<View, String>(
            positionNameTextView,
            MyApplication.applicationContext()?.getString(R.string.positions_details_transition_name)
          )
        )
        intent.putExtra(IntentExtra.POSITION_ID.tag,positionId)
        intent.putExtra(IntentExtra.NAME.tag,positionNameTextView.text.toString())
        intent.putExtra(IntentExtra.COMPANY_NAME.tag,positionCompanyTextView.text.toString())
        activity.startActivity(intent, options.toBundle())
      } else {
        activity.startActivity(intent)
      }
    }
  }
}