package com.example.unitconverterapp.di

import android.app.Application
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import com.example.unitconverterapp.data.ConverterDatabase
import com.example.unitconverterapp.data.ConverterRepository
import com.example.unitconverterapp.data.ConverterRepositoryImpl


@Module
@InstallIn(SingletonComponent :: class)
object AppModule {
 @Provides
 @Singleton
    fun provideConverterDatabase(app:Application) : ConverterDatabase {
        return Room.databaseBuilder(
            app,
            ConverterDatabase :: class.java,
            "converter_data_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideConverterRepository(db: ConverterDatabase) : ConverterRepository{
        return ConverterRepositoryImpl(db.converterDAO)
    }

}