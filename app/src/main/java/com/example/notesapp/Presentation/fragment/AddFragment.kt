package com.example.notesapp.Presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.notesapp.R
import com.example.notesapp.Data.model.Note
import com.example.notesapp.databinding.FragmentAddBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddFragment : Fragment() {
    private var _binding: FragmentAddBinding?= null
    private val binding get() = _binding!!
    private val viewModel: NoteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddBinding.inflate(inflater, container, false)
        binding.saveButton.setOnClickListener {
            val currentDate = getCurrentFormattedDate()
            val note = Note(0,
                binding.nameInput.editText?.text.toString(),
                binding.noteInput.editText?.text.toString(),
                currentDate
            )
            viewModel.addNote(note)
            findNavController().navigate(R.id.action_addFragment_to_noteListFragment)
        }
        return binding.root
    }
    private fun getCurrentFormattedDate(): String{
        val currentDate = Date()
        val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())
        return dateFormat.format(currentDate)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
