package com.muhrez.teamitalia.Ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import com.muhrez.teamitalia.Adapter.TabAdapter
import com.muhrez.schedulematch.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tab_layout.setupWithViewPager(tab_viewpager)
        setupViewPager(tab_viewpager)
    }

    private fun setupViewPager(viewPage: ViewPager){
        val tabsAdapter = TabAdapter(supportFragmentManager)
        tabsAdapter.add(SerieA(), "Serie A")
        tabsAdapter.add(SerieB(), "Serie B")
        viewPage.adapter = tabsAdapter
    }
}
