package br.com.mobileti.ratedialog

import android.content.Context

class RateDialog(var context: Context) {

    private var launchedTimes = 0
    private var launchTimes: Int = 7
    private var days: Int = 7
    private var playstorePackage: String = ""
    private var dialogOption: DialogOption? = null

    fun setLaunchTimes(launchTimes: Int): RateDialog {
        this.launchTimes = launchTimes
        return this
    }

    fun setDays(days: Int): RateDialog {
        this.days = days
        return this
    }

    fun setDialogOptions(dialogOption: DialogOption): RateDialog {
        this.dialogOption = dialogOption
        return this
    }
}