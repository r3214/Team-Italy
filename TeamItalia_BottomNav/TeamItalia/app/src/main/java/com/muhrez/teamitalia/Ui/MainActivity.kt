package com.muhrez.teamitalia.Ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.muhrez.schedulematch.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation.setOnNavigationItemSelectedListener {
            item ->
            when (item.itemId) {
                R.id.serie_a -> {
                    serieAFragment(savedInstanceState)
                }
                R.id.serie_b -> {
                    serieBFragment(savedInstanceState)
                }
                R.id.serie_c -> {
                    serieCFragment(savedInstanceState)
                }
            }
            true
        }
        bottom_navigation.selectedItemId = R.id.serie_a

    }

    private fun serieAFragment(savedInstanceState: Bundle?){
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().
                    replace(R.id.main_container, SerieA(), SerieA::class.java.name).
                    commit()
        }
    }

    private fun serieBFragment(savedInstanceState: Bundle?){
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().
                    replace(R.id.main_container, SerieB(), SerieB::class.java.name).
                    commit()
        }
    }

    private fun serieCFragment(savedInstanceState: Bundle?){
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().
                    replace(R.id.main_container, SerieC(), SerieC::class.java.name).
                    commit()
        }
    }

}
