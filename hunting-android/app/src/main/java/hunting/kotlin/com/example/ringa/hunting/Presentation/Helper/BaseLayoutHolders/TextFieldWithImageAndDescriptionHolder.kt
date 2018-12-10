package hunting.kotlin.com.example.ringa.hunting.Presentation.Helper.BaseLayoutHolders

import android.opengl.Visibility
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import hunting.kotlin.com.example.ringa.hunting.R
import kotlinx.android.synthetic.main.base_layout_text_field_with_image_and_description.view.*

class TextFieldWithImageAndDescriptionHolder(view: View) {
  val iconImageView = view.findViewById(R.id.text_field_image_description_icon_image) as ImageView
  val descriptionTextView = view.findViewById(R.id.text_field_image_description_name) as TextView
  val valueTextView = view.findViewById(R.id.text_field_image_description_value) as TextView

  fun hide(){
    iconImageView.visibility = View.INVISIBLE
    descriptionTextView.visibility = View.INVISIBLE
    valueTextView.visibility = View.INVISIBLE
  }

  fun show(){
    iconImageView.visibility = View.VISIBLE
    descriptionTextView.visibility = View.VISIBLE
    valueTextView.visibility = View.VISIBLE
  }
  fun setFormattedDescription(description:String){
    descriptionTextView.setText((description+" :"))
  }
}