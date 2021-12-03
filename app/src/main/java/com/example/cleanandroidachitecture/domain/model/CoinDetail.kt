package com.example.cleanandroidachitecture.domain.model

import com.example.cleanandroidachitecture.data.remote.dto.*

data class CoinDetail(
    val coinId: String,
    val description: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val tags: List<Tag>,
    val team: List<Team>,

)

fun CoinDetailDto.toCoinDetail() : CoinDetail{
    return CoinDetail(
        coinId = id,
        description = description,
        isActive = is_active,
        name = name,
        rank = rank,
        symbol = symbol,
        tags = tags,
        team = team

    )
}
