package com.example.unitconverterapp.data

import kotlinx.coroutines.flow.Flow



class ConverterRepositoryImpl(private  val dao: ConverterDAO) : ConverterRepository {
    override suspend fun insertResult(result: ConversionResult) {

        dao.insertResult(result)
    }

    override suspend fun deleteResult(result: ConversionResult) {
        dao.deleteResult(result)
    }

    override suspend fun deleteAllResults() {
        dao.deleteAll()
    }

    //getSavedResults used to invoke dao fun and get the flow
    override fun getSavedResults(): Flow<List<ConversionResult>> {
        return  dao.getResults()
    }
}