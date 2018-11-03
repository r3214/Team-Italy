package com.muhrez.teamitalia.Ui.Presenter

import com.google.gson.Gson
import com.muhrez.teamitalia.Api.ApiRepository
import com.muhrez.teamitalia.Api.TheSportDBApi
import com.muhrez.teamitalia.Model.TeamResponse
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class TeamPresenter(private val view: TeamView,
                    private val apiRepository: ApiRepository,
                    private val gson: Gson) {

    fun getTeamList(idLeague: String?) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                    .doRequest(TheSportDBApi.getTeams(idLeague)),
                    TeamResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showTeamList(data.teams)
            }
        }
    }
}