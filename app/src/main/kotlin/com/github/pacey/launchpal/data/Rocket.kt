package com.github.pacey.launchpal.data

import com.fasterxml.jackson.annotation.JsonProperty
import kotlin.math.abs

data class Rocket(
    val id: Int,
    val name: String,
    val configuration: String,
    @JsonProperty("familyname") val family: String,
    @JsonProperty("imageURL") val imageUrl: String?,
    val imageSizes: List<Int>
) {
    fun getImageAt(width: Int): String? {
        val closestWidth = imageSizes.minBy { abs(width - it) }
        return imageUrl?.replace(imageSizes.last().toString(), closestWidth.toString())
    }
}
