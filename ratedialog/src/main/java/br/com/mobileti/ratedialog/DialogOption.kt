package br.com.mobileti.ratedialog

/**
 * Optional options for the dialog
 *
 * @param title Dialog title
 * @param msg Dialog message
 * @param cancelable is Dialog cancelable
 * @param hasNegativeButton has negative Button
 * @param hasNeutralButton has neutral Button
 * @param neutralButtonText Neutral button text, empty String for default text
 * @param negativeButtonText Negative button text, empty String for default text
 * @param positiveButtonText Positive button text, empty String for default text
 */
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