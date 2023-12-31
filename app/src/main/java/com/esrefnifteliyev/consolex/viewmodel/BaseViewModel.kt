package com.esrefnifteliyev.consolex.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
open class BaseViewModel @Inject constructor(

) : ViewModel() , CoroutineScope {

    val job = Job()

    override val coroutineContext : CoroutineContext
        get() = job

}