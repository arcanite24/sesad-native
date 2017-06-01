package com.epsidev.sesad

import android.app.Activity
import android.os.Bundle
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class HomeActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        HomeUI().setContentView(this)
    }
}

class HomeUI : AnkoComponent<HomeActivity> {
    override fun createView(ui: AnkoContext<HomeActivity>) = with(ui) {
        verticalLayout {
            editText {
                hint = "Wea de prueba"
            }
            button("Hola :3") {
                onClick {toast("Hola mundo :3")}
            }
        }
    }
}