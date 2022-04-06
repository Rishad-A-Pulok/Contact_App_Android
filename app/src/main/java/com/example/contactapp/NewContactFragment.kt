package com.example.contactapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.contactapp.databinding.FragmentNewContactBinding

class NewContactFragment : Fragment() {
    private lateinit var binding: FragmentNewContactBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewContactBinding.inflate(inflater, container, false)
        binding.saveBtn.setOnClickListener {
            saveInfo()
        }
        return binding.root
    }

    private fun saveInfo() {
        val name = binding.nameET.text.toString()
        val phone = binding.phoneET.text.toString()
        val email = binding.emailET.text.toString()
        val address = binding.addressET.text.toString()

        val contact =Contact(
            id = System.currentTimeMillis(),
            name = name,
            phone = phone,
            email = email,
            address = address
        )
        contactList.add(contact)
        findNavController().navigate(R.id.action_newContactFragment_to_contactListFragment)
    }
}