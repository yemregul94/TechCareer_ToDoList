package com.works.todolist.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.google.android.material.snackbar.Snackbar
import com.works.todolist.R
import com.works.todolist.databinding.FragmentRegisterBinding
import com.works.todolist.ui.viewmodel.RegisterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding
    private lateinit var viewModel: RegisterViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false)
        binding.registerFragment = this
        binding.registerToolbarTitle = "Yapılacak İş Kayıt"

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: RegisterViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonRegister(view:View, toDo_detail:String){
        viewModel.register(toDo_detail)
        Snackbar.make(view, "$toDo_detail kaydedildi", Snackbar.LENGTH_LONG).show()
    }

}