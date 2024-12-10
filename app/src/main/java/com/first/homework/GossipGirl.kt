package com.first.homework

import androidx.annotation.ColorRes

data class GossipGirl(
    val id: Int,
    val character: String,
    val quote: String,
    val url: String,
    val isFav: Boolean = false
)

sealed class GGItem {
    data class GGUiModel(
        val id: Int,
        val character: String,
        val quote: String,
        val url: String,
        val isFav: Boolean = false,
        @ColorRes val titleColor: Int
    ) : GGItem()

    data class Title(
        val title: String
    ): GGItem()


}
