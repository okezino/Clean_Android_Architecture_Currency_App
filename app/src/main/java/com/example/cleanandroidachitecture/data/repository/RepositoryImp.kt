package com.example.cleanandroidachitecture.data.repository

import com.example.cleanandroidachitecture.data.remote.CoinPaprikaApi
import com.example.cleanandroidachitecture.data.remote.dto.CoinDetailDto
import com.example.cleanandroidachitecture.data.remote.dto.CoinDto
import com.example.cleanandroidachitecture.domain.repository.Repository
import javax.inject.Inject

class RepositoryImp @Inject constructor(
    private val api: CoinPaprikaApi
) : Repository {


    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoin()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId = coinId)
    }
}