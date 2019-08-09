package com.github.pacey.launchpal.data

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.Instant

data class Launch(
    val id: Int,
    val name: String,
    @JsonProperty("isostart") @JsonFormat(pattern = "yyyyMMdd'T'HHmmss'Z'", timezone = "UTC") val windowStart: Instant?,
    @JsonProperty("isoend") @JsonFormat(pattern = "yyyyMMdd'T'HHmmss'Z'", timezone = "UTC") val windowEnd: Instant?,
    @JsonProperty("isonet") @JsonFormat(pattern = "yyyyMMdd'T'HHmmss'Z'", timezone = "UTC") val noEarlierThan: Instant,
    val status: Int,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC") val changed: Instant,
    val rocket: Rocket?,
    val location: Location?
) {
    fun getDate(): Instant {
        if (windowStart == null || windowEnd == null) {
            return noEarlierThan
        }
        return windowStart
    }
}
