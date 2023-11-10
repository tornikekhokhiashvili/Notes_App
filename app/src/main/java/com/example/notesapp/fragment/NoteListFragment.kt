package com.example.notesapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.Note
import com.example.notesapp.R
import com.example.notesapp.adapter.NoteAdapter
import com.example.notesapp.NoteViewModel
import com.example.notesapp.databinding.FragmentNoteListBinding

class NoteListFragment : Fragment() {
    private lateinit var binding: FragmentNoteListBinding
    private lateinit var notesAdapter: NoteAdapter
    private lateinit var viewModel: NoteViewModel
    private lateinit var noteList: List<Note>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteListBinding.inflate(inflater, container, false)
        noteList = ArrayList()
        viewModel = ViewModelProvider(this)[NoteViewModel::class.java]

        binding.recycler.layoutManager = LinearLayoutManager(context)
        notesAdapter = NoteAdapter(requireContext(), noteList)
        binding.recycler.adapter = notesAdapter

        binding.createButton.setOnClickListener {
            findNavController().navigate(R.id.action_noteListFragment_to_addFragment)
        }

        viewModel.readAllData.observe(viewLifecycleOwner) { noteList ->
            notesAdapter.setData(noteList)
        }

        return binding.root
    }

}