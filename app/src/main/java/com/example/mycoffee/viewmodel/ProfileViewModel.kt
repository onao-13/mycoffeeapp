package com.example.mycoffee.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycoffee.model.Profile
import com.example.mycoffee.repository.ProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val repository: ProfileRepository): ViewModel() {
    private val _profile = MutableStateFlow<Profile>(Profile(0, "", "", ""))
    val profile: StateFlow<Profile> = _profile.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getProfile().distinctUntilChanged()
                .collect { profile ->
                    if (profile == null) _profile.value = Profile(0, "", "", "")
                    else _profile.value = profile
                }
        }
    }

    fun getProfile() = viewModelScope.launch { repository.getProfile() }
    fun login(profile: Profile) = viewModelScope.launch { repository.login(profile) }
    fun logout(profile: Profile) = viewModelScope.launch { repository.logout(profile) }
    fun updateProfile(profile: Profile) = viewModelScope.launch { repository.updateProfile(profile) }
}