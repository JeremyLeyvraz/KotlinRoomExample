package com.lj.libraryExample

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Module to inject/provide dao.
 */
@InstallIn(SingletonComponent::class)
@Module
object Module {

    /**
     * Provide the user DAO.
     *
     * @param appDatabase The application database.
     *
     * @return The user DAO.
     */
    @Provides
    fun provideBankrollDao(appDatabase: AppDatabase): UserDao {
        return appDatabase.userDao()
    }

    /**
     * Provide the application database.
     *
     * @param appContext The application context.
     *
     * @return The application database.
     */
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return AppDatabase.getDatabase(appContext)
    }
}
