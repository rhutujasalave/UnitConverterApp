package com.example.unitconverterapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

// we define query fun named getresults to get list of saved conversionResults as a flow
// ConverterDAO is dependancy for converterRepositoryImpl
@Dao
interface ConverterDAO {

        @Insert
    suspend fun  insertResult (result:ConversionResult)

    @Delete
    suspend fun  deleteResult (result:ConversionResult)

    @Query("DELETE FROM result_table")
    suspend fun  deleteAll()

    @Query("SELECT * FROM result_table")
    fun getResults():Flow<List<ConversionResult>>
}
