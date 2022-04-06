package com.example.contactapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactapp.databinding.ContactRowBinding
import com.example.contactapp.databinding.FragmentContactListBinding

class ContactListFragment : Fragment() {
    private lateinit var binding: FragmentContactListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentContactListBinding.inflate(inflater, container, false)
        val adapter = ContactAdapter{
            val bundle = Bundle().apply {
                putString("phone_value",it.phone)
                putString("email_value",it.email)
                putString("address_value",it.address)
            }
            findNavController().navigate(R.id.action_contactListFragment_to_contactDetailsFragment,bundle)
        }
        binding.contactRV.layoutManager = LinearLayoutManager(activity)
        binding.contactRV.adapter = adapter
        adapter.submitList(contactList)
        binding.contactAddBtn.setOnClickListener {
            findNavController().navigate(R.id.action_contactListFragment_to_newContactFragment)
        }
        return binding.root
    }
}