package com.example.noteapp.util

import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale
import java.util.UUID

fun formatDate(time:Long): String{
    val date = Date(time)
    val format = SimpleDateFormat("EEE, d MMM hh:mm aaa", Locale.getDefault())
    return format.format(date)
}

fun getIdAsString():String{
    return UUID.randomUUID().toString()
}

@RequiresApi(Build.VERSION_CODES.O)
fun getDateAsString(): String {
    val entryDateTime: LocalDateTime =
        LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault())
    val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
    return formatter.format(entryDateTime)
}