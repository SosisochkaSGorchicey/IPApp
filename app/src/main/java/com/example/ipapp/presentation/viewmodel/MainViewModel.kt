package com.example.ipapp.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    init {
        Log.v("alice", this.toString())
    }
}