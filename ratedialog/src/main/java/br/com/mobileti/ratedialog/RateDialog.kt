package br.com.mobileti.ratedialog

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.support.annotation.StringRes

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

        val dialog = AlertDialog.Builder(context)
            .setTitle(getStringIfNotEmpty(dialogOption.title, R.string.dialog_title))
            .setMessage(getStringIfNotEmpty(dialogOption.title, R.string.dialog_msg))
            .setCancelable(dialogOption.cancelable)
            .setPositiveButton(
                getStringIfNotEmpty(dialogOption.positiveButtonText, R.string.dialog_positive),
                DialogInterface.OnClickListener {
                        dialogInterface, i ->

                }
            )
        if (dialogOption.hasNeutralButton) {
            dialog.setNeutralButton(
                getStringIfNotEmpty(dialogOption.neutralButtonText, R.string.dialog_neutral),
                DialogInterface.OnClickListener {
                        dialogInterface, i ->

                }
            )
        }
        if (dialogOption.hasNegativeButton) {
            dialog.setNegativeButton(
                getStringIfNotEmpty(dialogOption.negativeButtonText, R.string.dialog_negative),
                DialogInterface.OnClickListener {
                        dialogInterface, i ->

                }
            )
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