package com.example.mycoffee.repository

import com.example.mycoffee.dao.ProfileDAO
import com.example.mycoffee.model.Profile
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProfileRepository @Inject constructor(private val profileDAO: ProfileDAO) {
    fun getProfile(): Flow<Profile> = profileDAO.getProfile()
    suspend fun login(profile: Profile) = profileDAO.login(profile)
    suspend fun logout(profile: Profile) = profileDAO.logout(profile)
    suspend fun updateProfile(profile: Profile) = profileDAO.updateProfile(profile)
}