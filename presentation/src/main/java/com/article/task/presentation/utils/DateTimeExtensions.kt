package com.article.task.presentation.utils

import android.util.LruCache
import com.article.task.presentation.utils.CommonFormats.FORMAT_DATE
import org.threeten.bp.Instant
import org.threeten.bp.LocalDate
import org.threeten.bp.LocalDateTime
import org.threeten.bp.ZoneId
import org.threeten.bp.ZoneOffset
import org.threeten.bp.ZonedDateTime
import org.threeten.bp.format.DateTimeFormatter
import java.util.Locale

object DateTimeFormatterCache {
    private const val CACHE_SIZE = 16
    private val cache = LruCache<String, DateTimeFormatter?>(CACHE_SIZE)

    operator fun get(name: String): DateTimeFormatter? = cache[name]

    operator fun set(name: String, formatter: DateTimeFormatter) {
        cache.put(name, formatter)
    }

    fun getOrCreateFormatter(pattern: String, locale: Locale = Locale.getDefault()): DateTimeFormatter {
        val key = "$pattern${locale.displayName ?: ""}"
        var format = this[key]
        if (format == null) {
            format = DateTimeFormatter.ofPattern(pattern, locale)
            this[key] = format
        }
        return checkNotNull(format)
    }
}

fun LocalDate.toFormattedString(): String = this.format(
    DateTimeFormatterCache.getOrCreateFormatter(FORMAT_DATE)
)

fun systemOffset(): ZoneOffset = ZoneOffset.systemDefault().rules.getOffset(LocalDateTime.now())

fun ZonedDateTime.toMillis() = toInstant().toEpochMilli()

fun Long.toZonedDateTime() = ZonedDateTime.ofInstant(
    Instant.ofEpochMilli(this), ZoneId.systemDefault()
)

object CommonFormats {
    const val FORMAT_DATE = "EEE, MMM d, ''yy"
}
