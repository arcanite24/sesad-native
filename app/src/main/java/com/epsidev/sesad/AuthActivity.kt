package com.epsidev.sesad

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import com.github.kittinunf.fuel.Fuel
import com.github.salomonbrys.kotson.*
import com.google.gson.JsonObject

class AuthActivity : Activity() {

    fun Activity.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, duration).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        val api: String = "http:/test.epsidev.com"

        val loginButton = findViewById(R.id.loginButton)
        val loginData: JsonObject = jsonObject(
                "username" to "admin",
                "password" to "123"
        )
        loginButton.setOnClickListener {
            Fuel.post(api + "/user/auth").body(loginData.asString).response {
                req, res, data -> toast(data.toString())
            }
        }

    }

}
