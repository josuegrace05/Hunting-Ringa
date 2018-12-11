package hunting.kotlin.com.example.ringa.hunting.Presentation.Auth.Login

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.Button
import android.widget.EditText
import hunting.kotlin.com.example.ringa.hunting.Domain.Entities.User
import hunting.kotlin.com.example.ringa.hunting.Infrastructure.Helper.SessionManager
import hunting.kotlin.com.example.ringa.hunting.R

class LoginActivity : AppCompatActivity(), LoginActivityInterface {

    var presenter: LoginPresenterInterface? = null
    private lateinit var email:EditText
    private lateinit var password:EditText
    private lateinit var loginBt:Button

    init {

        val loginPresenter = LoginPresenter()
        loginPresenter.viewLoigc = this@LoginActivity
        presenter = loginPresenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        email = findViewById(R.id.email_editText_loginActvity)
        password = findViewById(R.id.password_edit_text_loginActivity)
        loginBt = findViewById(R.id.login_bt_loginActivity)

        loginBt.setOnClickListener {presenter?.Login(email.text.toString(),password.text.toString())}
    }

    override fun closeActivity(token:String) {
        SessionManager().saveUser(User("","",
            token))
        this.finish()
    }

    override fun displayApiErrorMessage(errorMessage: String) {
        val layoutView = findViewById(R.id.login_activity_layout) as View
        val mySnackbar = Snackbar.make(layoutView, errorMessage, Snackbar.LENGTH_LONG);
        mySnackbar.show();
    }
}
