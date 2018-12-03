package br.com.mobileti.ratedialog.utils

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

fun isFutureDate(date: Long): Boolean {
    val futureCalendar = Calendar.getInstance().apply {
        time = Date(date)
    }

    return Calendar.getInstance().let {
        it.time = Date()
        it.after(futureCalendar)
    }
}