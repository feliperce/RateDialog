package br.com.mobileti.ratedialog

import android.content.Context

data class DialogOption (
    var title: String = "",
    var msg: String = "",
    var cancelable: Boolean = false,
    var hasNegativeButton: Boolean = true,
    var hasNeutralButton: Boolean = true,
    var neutralButtonText: String = "",
    var negativeButtonText: String = "",
    var positiveButtonText: String = ""
)