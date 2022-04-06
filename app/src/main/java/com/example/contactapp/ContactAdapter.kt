package com.example.contactapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.contactapp.databinding.ContactRowBinding

class ContactAdapter(val callback: (Contact) -> Unit): ListAdapter<Contact, ContactAdapter.ContactViewHolder>(ContactDiffUtil()) {

    class ContactViewHolder(val binding: ContactRowBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(contact: Contact){
            binding.contacts = contact
        }
    }

    class ContactDiffUtil: DiffUtil.ItemCallback<Contact>(){
        override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val binding = ContactRowBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = getItem(position)
        holder.bind(contact)
        /*holder.itemView.setOnClickListener {
            callback(contact)
        }
        for making toast when cardview is tapped*/
        holder.binding.showInfoIV.setOnClickListener {
            callback(contact)
        }
    }
}