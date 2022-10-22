package com.works.todolist.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.works.todolist.R
import com.works.todolist.databinding.FragmentDetailsBinding
import com.works.todolist.ui.viewmodel.DetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    private lateinit var viewModel: DetailsViewModel
    private lateinit var oldValue: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)
        binding.detailsFragment = this
        binding.detailsToolbarTitle = "Yapılacak İş Detay"

        val bundle: DetailsFragmentArgs by navArgs()
        val toDoItem = bundle.toDoItem
        binding.toDoObject = toDoItem

        oldValue = toDoItem.toDo_detail

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: DetailsViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonUpdate(view: View, toDo_id:Int, toDo_detail:String){
        viewModel.update(toDo_id, toDo_detail)
        Snackbar.make(view, "$oldValue, $toDo_detail olarak güncellendi", Snackbar.LENGTH_LONG).show()
    }

}