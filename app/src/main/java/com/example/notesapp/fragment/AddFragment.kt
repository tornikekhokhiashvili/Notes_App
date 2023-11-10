package com.example.notesapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.notesapp.R
import com.example.notesapp.Note
import com.example.notesapp.NoteViewModel
import com.example.notesapp.databinding.FragmentAddBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

import androidx.navigation.fragment.findNavController

class AddFragment : Fragment() {
    private lateinit var binding: FragmentAddBinding
    private lateinit var viewModel: NoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[NoteViewModel::class.java]
        binding.saveButton.setOnClickListener {
            val currentDate = Date()
            val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())
            val formattedDate = dateFormat.format(currentDate)

            val note = Note(0,
                binding.nameInput.editText?.text.toString(),
                binding.noteInput.editText?.text.toString(),
                formattedDate
            )
            viewModel.addNote(note)

            findNavController().navigate(R.id.action_addFragment_to_noteListFragment)
        }
        return binding.root
    }
}
