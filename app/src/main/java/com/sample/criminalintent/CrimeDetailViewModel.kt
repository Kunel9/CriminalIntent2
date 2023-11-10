package com.sample.criminalintent

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.UUID

class CrimeDetailViewModel {
        private val crimeRepository = CrimeRepository.get()
        private val crimeIdLiveData = MutableLiveData<UUID>()
        var crimeLiveData: LiveData<Crime?> =
            Transformations.switchMap(crimeIdLiveData) {
                    crimeId -> crimeRepository.getCrime(crimeId)
            }
        fun loadCrime(crimeId: UUID) {
            crimeIdLiveData.value = crimeId
        }
}