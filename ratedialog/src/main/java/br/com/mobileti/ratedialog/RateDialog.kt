package br.com.mobileti.ratedialog

import android.content.Context

class RateDialog(var context: Context) {

    private var launchedTimes = 0
    private var launchTimes: Int = 7
    private var days: Int = 7
    private var playstorePackage: String = ""

    fun setLaunchTimes(launchTimes: Int): RateDialog {
        this.launchTimes = launchTimes
        return this
    }

    fun setDays(days: Int): RateDialog {
        this.days = days
        return this
    }

    companion object {
        private const val PREFERENCE = 0
    }

}