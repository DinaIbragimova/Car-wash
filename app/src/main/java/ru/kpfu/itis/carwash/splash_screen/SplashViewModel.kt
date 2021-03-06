package ru.kpfu.itis.carwash.splash_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.kpfu.itis.domain.AuthInteractor
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val interactor: AuthInteractor
) : ViewModel() {

    private val user: MutableLiveData<Boolean> = MutableLiveData()

    init {
        viewModelScope.launch {
            user.value = interactor.getCurrentUser()
        }
    }

    fun user(): LiveData<Boolean> = user
}
