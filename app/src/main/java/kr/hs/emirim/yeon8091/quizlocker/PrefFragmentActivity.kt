package kr.hs.emirim.yeon8091.quizlocker

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceFragment
import kotlin.concurrent.fixedRateTimer

class PrefFragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pre_fragment)
        fragmentManager.beginTransaction().replace(android.R.id.content,MyPrefFragmanet()).commit()
    }
        class MyPrefFragmanet:PreferenceFragment(){
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                addPreferencesFromResource(R.xml.ex_pref)
            }

        }
    }

