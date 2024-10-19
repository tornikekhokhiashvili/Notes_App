package com.example.notesapp.Presentation.fragment.Recycler

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.Data.model.Note
import com.example.notesapp.databinding.NoteItemBinding

class NoteAdapter: RecyclerView.Adapter<NoteAdapter.NotesViewHolder>() {
    private var noteList = emptyList<Note>()
    class NotesViewHolder(val binding: NoteItemBinding) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val binding = NoteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NotesViewHolder(binding)
    }
    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val note = noteList[position]
        val myHolder = holder.binding
        myHolder.noteNameTv.text = note.name
        myHolder.dateTv.text = note.date
        myHolder.root.setOnClickListener {
            val action = NoteListFragmentDirections.actionNoteListFragmentToDetailFragment(note)
            it.findNavController().navigate(action)
        }
    }
    override fun getItemCount()= noteList.size
    @SuppressLint("NotifyDataSetChanged")
    fun setData(newNotesList: List<Note>) {
        noteList = newNotesList
        notifyDataSetChanged()
    }
}