package com.example.cleanandroidachitecture.domain.model

import com.example.cleanandroidachitecture.data.remote.dto.CoinDto
import com.google.gson.annotations.SerializedName

data class Coin(
    val id: String,
    val is_active: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
)


fun CoinDto.toCoin(): Coin{
    return Coin(
        id = id,
        is_active = is_active,
        name = name,
        rank = rank,
        symbol = symbol
    )
}