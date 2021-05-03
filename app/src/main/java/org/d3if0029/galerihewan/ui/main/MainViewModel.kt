package org.d3if0029.galerihewan.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.d3if0029.galerihewan.R
import org.d3if0029.galerihewan.model.Hewan
import org.d3if0029.galerihewan.network.HewanApi
import org.d3if0029.galerihewan.network.HewanApiService

class MainViewModel: ViewModel() {
    private val data = MutableLiveData<List<Hewan>>()
    init {
        data.value = initData()
        retrieveData()
    }
    private fun retrieveData() {
        viewModelScope.launch {
            try {
                val result = HewanApi.service.getHewan()
                Log.d("MainViewModel", "Success: $result")
            } catch (e: Exception) {
                Log.d("MainViewModel", "Failure: ${e.message}")
            }
        }
    }

    // Data ini akan kita ambil dari server di langkah selanjutnya
    private fun initData(): List<Hewan> {
        return listOf(
            Hewan("Angsa", "Cygnus olor", R.drawable.angsa, "Unggas"),
            Hewan("Ayam", "Gallus gallus", R.drawable.ayam, "Unggas"),
            Hewan("Bebek", "Cairina moschata", R.drawable.bebek, "Unggas"),
            Hewan("Domba", "Ovis ammon", R.drawable.domba, "Mamalia"),
            Hewan("Kalkun", "Meleagris gallopavo", R.drawable.kalkun, "Unggas"),
            Hewan("Kambing", "Capricornis sumatrensis", R.drawable.kambing, "Mamalia"),
            Hewan("Kelinci", "Oryctolagus cuniculus", R.drawable.kelinci, "Mamalia"),
            Hewan("Kerbau", "Bubalus bubalis", R.drawable.kerbau, "Mamalia"),
            Hewan("Kuda", "Equus caballus", R.drawable.kuda, "Mamalia"),
            Hewan("Sapi", "Bos taurus", R.drawable.sapi, "Mamalia"),
        )
    }
    fun getData(): LiveData<List<Hewan>> = data

}