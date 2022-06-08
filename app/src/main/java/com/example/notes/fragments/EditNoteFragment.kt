package com.example.notes.fragments

import android.os.Bundle
import android.provider.SyncStateContract.Helpers.update
import android.text.format.DateFormat
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.notes.R
import com.example.notes.databinding.FragmentEditNoteBinding
import com.example.notes.model.Notes
import com.example.notes.viewmodel.NotesViewModel
import java.util.*


class EditNoteFragment : Fragment() {

    val notes by navArgs<EditNoteFragmentArgs>()
    var priority : String ="1"
    lateinit var binding: FragmentEditNoteBinding
    val viewModel: NotesViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEditNoteBinding.inflate(layoutInflater,container,false)

        binding.edtTitle2.setText(notes.data.title)
        binding.edtSubTitle2.setText(notes.data.subtitle)
        binding.edtNotes2.setText(notes.data.notes)

        when(notes.data.priority)
        {
            "1"->{
                priority="1"
                binding.pGreen2.setImageResource(R.drawable.ic_baseline_done_24)
                binding.pRed2.setImageResource(0)
                binding.pYellow2.setImageResource(0)
            }
            "2"->{
                priority="2"
                binding.pGreen2.setImageResource(0)
                binding.pRed2.setImageResource(0)
                binding.pYellow2.setImageResource(R.drawable.ic_baseline_done_24)
            }
            "3"->{
                priority ="3"
                binding.pRed2.setImageResource(R.drawable.ic_baseline_done_24)
                binding.pYellow2.setImageResource(0)
                binding.pGreen2.setImageResource(0)
            }
        }

        binding.pGreen2.setOnClickListener {
            priority="1"
            binding.pGreen2.setImageResource(R.drawable.ic_baseline_done_24)
            binding.pRed2.setImageResource(0)
            binding.pYellow2.setImageResource(0)
        }
        binding.pYellow2.setOnClickListener {
            priority="2"
            binding.pGreen2.setImageResource(0)
            binding.pRed2.setImageResource(0)
            binding.pYellow2.setImageResource(R.drawable.ic_baseline_done_24)
        }
        binding.pRed2.setOnClickListener {
            priority ="3"
            binding.pRed2.setImageResource(R.drawable.ic_baseline_done_24)
            binding.pYellow2.setImageResource(0)
            binding.pGreen2.setImageResource(0)
        }


        binding.btnSaveNotes2.setOnClickListener {

            update(it)
        }
        return binding.root
    }

    private fun update(it: View?) {
        val title = binding.edtTitle2.text
        val subtitle = binding.edtSubTitle2.text
        val note    = binding.edtNotes2.text
        val date     = Date()
        val sdate: CharSequence = DateFormat.format("MMMM ,d, yyyy", date.time)

        val data = Notes(notes.data.id, title = title.toString(), subtitle = subtitle.toString(), notes = note.toString(), date = sdate.toString(),priority)

        viewModel.updateNotes(data)

        Toast.makeText(activity,"Notes updated successfully", Toast.LENGTH_SHORT).show()
        Navigation.findNavController(it!!).navigate(R.id.action_editNoteFragment_to_homeFragment)
    }


}