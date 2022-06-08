package com.example.notes.fragments

import android.os.Bundle
import android.text.format.DateFormat
import android.util.Log

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.notes.R

import com.example.notes.databinding.FragmentCreateNoteBinding
import com.example.notes.model.Notes
import com.example.notes.viewmodel.NotesViewModel

import java.util.*


class CreateNoteFragment : Fragment() {

     lateinit var binding: FragmentCreateNoteBinding
     var priority : String ="1"
     val viewModel: NotesViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCreateNoteBinding.inflate(layoutInflater,container,false)

        binding.pGreen.setImageResource(R.drawable.ic_baseline_done_24)
        binding.pGreen.setOnClickListener {
            priority="1"
            binding.pGreen.setImageResource(R.drawable.ic_baseline_done_24)
            binding.pRed.setImageResource(0)
            binding.pYellow.setImageResource(0)
        }
        binding.pYellow.setOnClickListener {
            priority="2"
            binding.pGreen.setImageResource(0)
            binding.pRed.setImageResource(0)
            binding.pYellow.setImageResource(R.drawable.ic_baseline_done_24)
        }
        binding.pRed.setOnClickListener {
            priority ="3"
            binding.pRed.setImageResource(R.drawable.ic_baseline_done_24)
            binding.pYellow.setImageResource(0)
            binding.pGreen.setImageResource(0)
        }
        binding.btnSaveNotes.setOnClickListener {
            createNotes(it)
            Log.d("@@", priority)
        }
        return binding.root
    }

    private fun createNotes(it: View?) {
        val title = binding.edtTitle.text
        val subtitle = binding.edtSubTitle.text
        val notes    = binding.edtNotes.text
        val date     = Date()
        val sdate: CharSequence = DateFormat.format("MMMM ,d, yyyy", date.time)

        val data = Notes(null, title = title.toString(), subtitle = subtitle.toString(), notes = notes.toString(), date = sdate.toString(),priority)

        viewModel.insertNotes(data)

        Toast.makeText(activity,"Notes registered successfully",Toast.LENGTH_SHORT).show()
        Navigation.findNavController(it!!).navigate(R.id.action_createNoteFragment_to_homeFragment)
    }
}

