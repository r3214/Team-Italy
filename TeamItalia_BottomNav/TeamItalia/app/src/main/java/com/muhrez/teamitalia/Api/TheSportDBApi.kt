package com.muhrez.teamitalia.Api

import android.net.Uri
import com.muhrez.schedulematch.BuildConfig

object TheSportDBApi {

    fun getTeams(idLeague: String?): String {

        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
                .appendPath("api")
                .appendPath("v1")
                .appendPath("json")
                .appendPath(BuildConfig.TSDB_API_KEY)
                .appendPath("lookup_all_teams.php")
                .appendQueryParameter("id", idLeague)
                .build()
                .toString()

    }
}