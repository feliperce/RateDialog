package br.com.mobileti.ratedialog

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper(var context: Context) {

    private fun getSharedPreference(): SharedPreferences {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    private fun incrementLaunchedTimes() {
        var launchedTimes = getLaunchedTimes()
        launchedTimes++
        setLaunchedTimes(launchedTimes)
    }

    fun getLaunchedTimes(): Int {
        return getSharedPreference().getInt(PREF_KEY_LAUNCHED_TIMES, 0)
    }

    fun setLaunchedTimes(launchedTimes: Int) {
        with(getSharedPreference().edit()) {
            putInt(PREF_KEY_LAUNCHED_TIMES, launchedTimes)
            apply()
        }
    }

    fun setRateDay(rateDay: Long) {
        with(getSharedPreference().edit()) {
            putLong(PREF_KEY_RATE_DAY, rateDay)
            apply()
        }
    }

    fun getRateDay(): Long {
        return getSharedPreference().getLong(PREF_KEY_RATE_DAY, -1)
    }

    companion object {
        private const val PREF_NAME = "ratedialog"
        private const val PREF_KEY_LAUNCHED_TIMES = "launched_times"
        private const val PREF_KEY_RATE_DAY = "rate_day"
        private const val PREF_CAN_SHOW_DIALOG = "show_dialog"
    }
}