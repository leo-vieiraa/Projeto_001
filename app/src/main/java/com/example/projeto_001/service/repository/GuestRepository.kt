package com.example.projeto_001.service.repository

import com.example.projeto_001.service.model.GuestModel

class GuestRepository {

    fun getAll(): List<GuestModel> {
        val list: MutableList<GuestModel> = ArrayList()
        return list
    }

    fun getPresent(): List<GuestModel> {
        val list: MutableList<GuestModel> = ArrayList()
        return list
    }

    fun getAbsent(): List<GuestModel> {
        val list: MutableList<GuestModel> = ArrayList()
        return list
    }

    fun save(guest: GuestModel) {

    }

    fun update(guest: GuestModel) {

    }

    fun delete(guest: GuestModel) {

    }

}