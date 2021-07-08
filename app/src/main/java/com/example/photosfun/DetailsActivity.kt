package com.example.photosfun

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {
    private lateinit var mGoogleSignInClient : GoogleSignInClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val bundle = intent.extras
        val personName = bundle!!.getString("name")

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()


        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);


        detailsTv.text = "Welcome $personName"
        SignOut.setOnClickListener{
            signOut()
        }
    }
    private fun signOut() {

        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this) {
                    finish()
                }
    }
}