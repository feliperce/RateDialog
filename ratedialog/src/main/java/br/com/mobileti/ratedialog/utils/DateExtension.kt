package br.com.mobileti.ratedialog.utils

import android.text.format.DateUtils
import java.time.LocalDateTime
import java.util.*

fun getDatePlusDays(days: Int): Long {
    var date = Date()
    Calendar.getInstance().apply {
        time = date
        add(Calendar.DATE, days)
        date = time
    }
    return date.time
}