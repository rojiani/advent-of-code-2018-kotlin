package day04

import java.lang.IllegalArgumentException
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

data class GuardLogEntry(
    val time: LocalDateTime,
    val guardID: Int? = null,
    val event: GuardAction
) {
    companion object {
        fun from(record: String): GuardLogEntry {
            val date = parseDate(record)
            val time = parseTime(record)
            if (date == null || time == null) {
                throw IllegalArgumentException("Unable to parse timestamp for record: $record")
            }

            val dateTime: LocalDateTime = date.atTime(time)
            val guardID: Int? = parseGuardID(record)
            val event: GuardAction = if (guardID != null) GuardAction.CHECK_IN else parseEvent(record)
            return GuardLogEntry(dateTime, guardID, event)
        }
        
        private fun parseDate(record: String): LocalDate? {
            val dateRegex = Regex("""\d{4}-\d{2}-\d{2}""")
            val dateString = dateRegex.find(record)?.value ?: return null 
            return LocalDate.parse(dateString)
        }

        private fun parseTime(record: String): LocalTime? {
            val timeRegex = Regex("""\d{2}:\d{2}""")
            val timeString = timeRegex.find(record)?.value ?: return null
            return LocalTime.parse(timeString)
        }
        
        private fun parseGuardID(record: String): Int? {
            val guardRegex = Regex("""Guard #\d+""")
            val matchString = guardRegex.find(record)?.value ?: return null
            return matchString.split('#').last().toInt()
        }
        
        private fun parseEvent(record: String): GuardAction = when {
            record.contains("wakes up") -> GuardAction.WAKES_UP
            record.contains("falls asleep") -> GuardAction.FALLS_ASLEEP
            record.contains("begins shift") -> GuardAction.CHECK_IN
            else -> throw IllegalArgumentException("Unable to parse event from record: $record")
        }
    }
}
