package com.example.notes.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.R
import com.example.notes.databinding.ItemsNotesBinding
import com.example.notes.fragments.HomeFragmentDirections
import com.example.notes.model.Notes

class NotesAdapter(val requireContext: Context, val notesList: List<Notes>) : RecyclerView.Adapter<NotesAdapter.NotesViewHolder> (){

    class NotesViewHolder(val binding: ItemsNotesBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {

        return NotesViewHolder(ItemsNotesBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val data = notesList[position]
        holder.binding.notesTitle.text = data.title
        holder.binding.notesSubTitle.text= data.subtitle
        holder.binding.notesDate.text = data.date

        when(data.priority)
        {
            "1"->{
                holder.binding.viewPriority.setBackgroundResource(R.drawable.greendot)
            }
            "2"->{
                holder.binding.viewPriority.setBackgroundResource(R.drawable.yellowdot)
            }
            "3"->{
                holder.binding.viewPriority.setBackgroundResource(R.drawable.reddot)
            }
        }
        holder.binding.root.setOnClickListener {
           val action = HomeFragmentDirections.actionHomeFragmentToEditNoteFragment(data)
           Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int = notesList.size


}