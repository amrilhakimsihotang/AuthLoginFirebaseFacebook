package com.amrilhs.authloginfirebasefacebook

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.amrilhs.authloginfirebasefacebook.databinding.ActivityMainBinding
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    var  firebaseAuth: FirebaseAuth?= null
    var callbackManager:CallbackManager? = null
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        callbackManager = CallbackManager.Factory.create()

        binding.loginFacebook.setReadPermissions("email")
        binding.loginFacebook.setOnClickListener {
            signin()
        }



    /*   private fun printkeyHash() {
           try {
               val info = packageManager.getPackageInfo(
                   "com.amrilhs.authloginfirebasefacebook",
                   PackageManager.GET_SIGNATURES
               )
               for (signature in info.signatures) {
                   val md = MessageDigest.getInstance("SHA")
                   md.update(signature.toByteArray())
                   Log.e("KEYHASH", Base64.encodeToString(md.digest(), Base64.DEFAULT))
               }
           }catch (e:PackageManager.NameNotFoundException){

           }catch (e:NoSuchAlgorithmException){

           }
       } */
}

    private fun signin() {
        binding.loginFacebook.registerCallback(callbackManager, object : FacebookCallback<LoginResult>{
            override fun onSuccess(result: LoginResult?) {
               handleFacebookAccessToken(result!!.accessToken)
            }

            override fun onCancel() {
                TODO("Not yet implemented")
            }

            override fun onError(error: FacebookException?) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun handleFacebookAccessToken(accessToken: AccessToken?){
        val credentials = FacebookAuthProvider.getCredential(accessToken!!.token)
        firebaseAuth!!.signInWithCredential(credentials)
            .addOnSuccessListener { result->
                val email = result.user?.email
                Toast.makeText(applicationContext,"You Logged" + email, Toast.LENGTH_LONG).show()

            }
            .addOnFailureListener { e->
                Toast.makeText(applicationContext,e.message,Toast.LENGTH_LONG).show()
            }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager?.onActivityResult(requestCode,resultCode,data)
    }

}