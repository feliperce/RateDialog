package br.com.mobileti.ratedialog

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.support.annotation.StringRes
import br.com.mobileti.ratedialog.utils.getDatePlusDays
import br.com.mobileti.ratedialog.utils.isFutureDate

class RateDialog(var context: Context) {

    private var launchedTimes = 0
    private var launchTimes: Int = 7
    private var days: Int = 7
    private var playstorePackage: String = ""
    private var dialogOption: DialogOption = DialogOption()

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

    fun create() {
        val pref = PreferenceHelper(context)

        pref.apply {

            if(getCanShowDialog()) {
                if (isDayToRateChanged(days) || isLaunchTimesChanged(launchTimes)) {
                    clearSharedPref()
                }

                setParams(this)
                launchedTimes = getLaunchedTimes()
                launchedTimes++
                setLaunchedTimes(launchedTimes)

                if (playstorePackage.isEmpty()) {
                    playstorePackage = context.packageName
                }

                if (isFutureDate(getRateDay())) {
                    if (launchedTimes >= getLaunchTimes()) {
                        showDialog()
                    }
                }
            }
        }
    }

    private fun setParams(pref: PreferenceHelper) {
        pref.apply {
            if(getRateDay() == -1L) {
                setRateDay(getDatePlusDays(days))
            }
            if(getDaysToRate() == -1) {
                setDaysToRate(days)
            }
            if(getLaunchTimes() == -1) {
                setLaunchTimes(launchTimes)
            }
        }
    }

    private fun showDialog() {
        val dialog = AlertDialog.Builder(context)
            .setTitle(getStringIfNotEmpty(dialogOption.title, R.string.dialog_title))
            .setMessage(getStringIfNotEmpty(dialogOption.msg, R.string.dialog_msg))
            .setCancelable(dialogOption.cancelable)
            .setPositiveButton(
                getStringIfNotEmpty(dialogOption.positiveButtonText, R.string.dialog_positive)
            ) { dialogInterface, i ->
                PreferenceHelper(context).setCanShowDialog(false)
                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=$playstorePackage")
                )
                context.startActivity(intent)
            }
        if (dialogOption.hasNeutralButton) {
            dialog.setNeutralButton(
                getStringIfNotEmpty(dialogOption.neutralButtonText, R.string.dialog_neutral)
            ) { dialogInterface, i ->
                PreferenceHelper(context).apply {
                    setCanShowDialog(true)
                    clearSharedPref()
                }
            }
        }
        if (dialogOption.hasNegativeButton) {
            dialog.setNegativeButton(
                getStringIfNotEmpty(dialogOption.negativeButtonText, R.string.dialog_negative)
            ) { dialogInterface, i ->
                PreferenceHelper(context).setCanShowDialog(false)
            }
        }
        if (dialogOption.cancelable) {
            dialog.setOnCancelListener {
                PreferenceHelper(context).apply {
                    setCanShowDialog(true)
                    clearSharedPref()
                }
            }
        }
        dialog.show()
    }

    private fun getStringIfNotEmpty(string: String, @StringRes resId: Int): String {
        var str = string

        if (str.isEmpty()) {
            str = context.resources.getString(resId)
        }
        return str
    }
}