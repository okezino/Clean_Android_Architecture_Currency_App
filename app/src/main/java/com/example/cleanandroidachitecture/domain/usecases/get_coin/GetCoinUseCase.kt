package com.example.cleanandroidachitecture.domain.usecases.get_coin

import com.example.cleanandroidachitecture.common.Resource
import com.example.cleanandroidachitecture.domain.model.Coin
import com.example.cleanandroidachitecture.domain.model.toCoin
import com.example.cleanandroidachitecture.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    val repository: Repository
) {

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading(listOf<Coin>()))
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))

        }
        //response code that does not start with a 2 meaning unsuccessful
        catch (e: HttpException) {
            emit(
                Resource.Failure(
                    message = e.localizedMessage ?: "an unexpected error occur",
                    listOf<Coin>()
                )
            )
        }
        //response code that does not hite the endponit meaning internet error

        catch (e: IOException) {
            emit(Resource.Failure(e.localizedMessage ?: "internet error", listOf<Coin>()))
        }
    }
}