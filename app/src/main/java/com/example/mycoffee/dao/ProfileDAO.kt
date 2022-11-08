package com.example.mycoffee.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.mycoffee.model.Profile
import kotlinx.coroutines.flow.Flow

@Dao
interface ProfileDAO {

    @Query("SELECT * FROM profile LIMIT 1")
    fun getProfile(): Flow<Profile>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun login(profile: Profile)

    @Delete
    suspend fun logout(profile: Profile)

    @Update
    suspend fun updateProfile(profile: Profile)
}