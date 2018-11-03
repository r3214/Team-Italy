package com.muhrez.teamitalia.Ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.gson.Gson
import com.muhrez.schedulematch.R
import com.muhrez.teamitalia.Adapter.TeamAdapter
import com.muhrez.teamitalia.Api.ApiRepository
import com.muhrez.teamitalia.Model.Team
import com.muhrez.teamitalia.Ui.Presenter.TeamPresenter
import com.muhrez.teamitalia.Ui.Presenter.TeamView
import com.muhrez.teamitalia.Util.invisible
import com.muhrez.teamitalia.Util.visible
import kotlinx.android.synthetic.main.fragment_team.*
import org.jetbrains.anko.support.v4.onRefresh

class SerieC : Fragment(), TeamView {

    private var teamList: MutableList<Team> = mutableListOf()
    private lateinit var presenter: TeamPresenter
    private lateinit var adapter: TeamAdapter
    private lateinit var idleague: String

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val request = ApiRepository()
        val gson = Gson()
        idleague = "4398"

        presenter = TeamPresenter(this, request, gson)
        presenter.getTeamList(idleague)

        adapter = TeamAdapter(teamList, object : TeamAdapter.ListenerAdapter {
            override fun onClick(teams: Team) {
                Toast.makeText(context, teams.teamName, Toast.LENGTH_SHORT).show()

            }
        })

        list_team_fragment.adapter = adapter
        list_team_fragment.layoutManager = LinearLayoutManager(context)
        adapter.notifyDataSetChanged()
        teamList.clear()

        swipe_refresh_fragment.onRefresh {
            presenter.getTeamList(idleague)
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_team, container, false)


    override fun showLoading() {
        progress_bar_fragment.visible()
    }

    override fun hideLoading() {
        progress_bar_fragment.invisible()
    }

    override fun showTeamList(data: List<Team>?) {
        swipe_refresh_fragment.isRefreshing = false
        teamList.clear()
        data?.let {
            teamList.addAll(data)
            adapter.notifyDataSetChanged()
        }
    }
}