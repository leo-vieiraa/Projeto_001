package com.example.projeto_001.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projeto_001.service.model.GuestModel
import com.example.projeto_001.service.repository.GuestRepository

class GuestFormViewModel : ViewModel() {

    private val mGuestRepository: GuestRepository = GuestRepository()
    private val mSaveGuest = MutableLiveData<Boolean>()
    val saveGuest: LiveData<Boolean> = mSaveGuest

    fun save (name: String, presence: Boolean) {

        val guest = GuestModel(name,presence)
        mGuestRepository.save(guest)

    }

}