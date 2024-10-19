package com.example.notesapp.Presentation.fragment.Recycler

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notesapp.R
import com.example.notesapp.Presentation.fragment.NoteViewModel
import com.example.notesapp.databinding.FragmentNoteListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NoteListFragment : Fragment() {
    private var _binding: FragmentNoteListBinding?= null
    private val binding get() = _binding!!
    private val notesAdapter by lazy { NoteAdapter() }
    private val viewModel: NoteViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNoteListBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupNavController()
        observeData()
    }
    private fun setupRecyclerView() {
        binding.recycler.layoutManager = LinearLayoutManager(context)
        binding.recycler.adapter = notesAdapter
    }
    private fun setupNavController() {
        binding.createButton.setOnClickListener {
            findNavController().navigate(R.id.action_noteListFragment_to_addFragment)
        }
    }
    private fun observeData() {
      lifecycleScope.launch {
          viewModel.noteList.collect {
              notesAdapter.setData(it)
          }
      }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}