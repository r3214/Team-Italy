package com.muhrez.teamitalia.Adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.muhrez.teamitalia.Model.Team
import com.muhrez.schedulematch.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.team_adapter.view.*

class TeamAdapter (private val listTeam: List<Team>, private val listenerAdapter: ListenerAdapter)
    : RecyclerView.Adapter<TeamAdapter.ViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.team_adapter, parent, false))

    override fun getItemCount(): Int = listTeam.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(listTeam[position], listenerAdapter)
    }

    class ViewHolder (view : View) : RecyclerView.ViewHolder (view) {

        fun bindItem(teams: Team, listenerAdapter: ListenerAdapter) {

            val teamBadge = teams.strTeamBadge
            if (teamBadge == null || teamBadge == "") {
                Picasso.get().load(R.drawable.ic_football).placeholder(R.drawable.ic_football).into(itemView.badge_team)
            } else {
                Picasso.get().load(teamBadge).into(itemView.badge_team)
            }

            itemView.team_name.text = teams.teamName
            itemView.container_team.setOnClickListener {
                listenerAdapter.onClick(teams)
            }
        }
    }

    interface ListenerAdapter {
        fun onClick(teams: Team)
    }
}