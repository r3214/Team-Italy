package com.muhrez.teamitalia.Ui.Presenter

import com.muhrez.teamitalia.Model.Team

interface TeamView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>?)
}