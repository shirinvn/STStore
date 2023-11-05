package com.example.stsotre.viewmodel

import androidx.lifecycle.ViewModel
import com.example.stsotre.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository) : ViewModel() {

}