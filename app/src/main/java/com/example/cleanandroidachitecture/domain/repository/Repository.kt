package com.example.cleanandroidachitecture.domain.repository

import com.example.cleanandroidachitecture.data.remote.dto.CoinDetailDto
import com.example.cleanandroidachitecture.data.remote.dto.CoinDto

interface Repository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId : String) : CoinDetailDto
}