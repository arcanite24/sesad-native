package com.epsidev.sesad

import android.app.Activity
import android.os.Bundle
import com.github.kittinunf.fuel.Fuel
import com.github.salomonbrys.kotson.*
import com.google.gson.JsonObject
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class AuthActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        val api: String = "http:/test.epsidev.com"

        val loginButton = findViewById(R.id.loginButton)
        val goButton = findViewById(R.id.enterButton)

        val loginData: JsonObject = jsonObject(
                "username" to "admin",
                "password" to "123"
        )

        loginButton.setOnClickListener {
            Fuel.post(api + "/user/auth").body(loginData.asString).response {
                req, res, data -> toast("Request aceptado")
            }
        }

        goButton.setOnClickListener {
            startActivity<HomeActivity>()
        }

    }

}
