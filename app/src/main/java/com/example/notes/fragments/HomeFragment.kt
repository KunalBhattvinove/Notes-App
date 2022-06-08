package com.example.notes.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.notes.R
import com.example.notes.adapter.NotesAdapter
import com.example.notes.databinding.FragmentHomeBinding
import com.example.notes.viewmodel.NotesViewModel



class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    val viewModel: NotesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

      binding = FragmentHomeBinding.inflate(layoutInflater,container,false)


      viewModel.getAllNotes().observe(viewLifecycleOwner) { notesList ->
          binding.RecyclerALLNotes.layoutManager = GridLayoutManager(requireContext(), 2)
          binding.RecyclerALLNotes.adapter = NotesAdapter(requireContext(), notesList)
      }

        binding.FABAdd.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_createNoteFragment)
        }

        binding.allNotes.setOnClickListener {

            viewModel.getAllNotes().observe(viewLifecycleOwner) { notesList ->
                binding.RecyclerALLNotes.layoutManager = GridLayoutManager(requireContext(), 2)
                binding.RecyclerALLNotes.adapter = NotesAdapter(requireContext(), notesList)
            }

        }

        binding.priorityHigh.setOnClickListener {
            viewModel.getHighNotes().observe(viewLifecycleOwner) { notesList ->
                binding.RecyclerALLNotes.layoutManager = GridLayoutManager(requireContext(), 2)
                binding.RecyclerALLNotes.adapter = NotesAdapter(requireContext(), notesList)
            }
        }

        binding.priorityMedium.setOnClickListener {
            viewModel.getMediumNotes().observe(viewLifecycleOwner) { notesList ->
                binding.RecyclerALLNotes.layoutManager = GridLayoutManager(requireContext(), 2)
                binding.RecyclerALLNotes.adapter = NotesAdapter(requireContext(), notesList)
            }
        }

        binding.priorityLow.setOnClickListener {
            viewModel.getLowNotes().observe(viewLifecycleOwner) { notesList ->
                binding.RecyclerALLNotes.layoutManager = GridLayoutManager(requireContext(), 2)
                binding.RecyclerALLNotes.adapter = NotesAdapter(requireContext(), notesList)
            }
        }

        return binding.root
    }


}