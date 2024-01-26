package org.edu.yamini.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.edu.yamini.data.repositories.UserRepository
import org.edu.yamini.viewmodel.UserViewModel

class UserViewModelFactory (
    private val repository: UserRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserViewModel(repository) as T
    }

}