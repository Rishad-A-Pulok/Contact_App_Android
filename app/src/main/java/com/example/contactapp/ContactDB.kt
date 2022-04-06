package com.example.contactapp

data class Contact(
    val id: Long,
    val name: String,
    val phone: String,
    val email: String,
    val address: String
)

val contactList = mutableListOf<Contact>(
    Contact(1,"Rishad","01729973325","r.pulok98@gmail.com","Dhanmondi 27,Dhaka"),
    Contact(2,"Pulok","01633051616","pulok1717@gmail.com","EDB Trade Centre,Kawran Bazar,Dhaka"),
    Contact(3,"Sazedur","01786454360","sazedur@gmail.com","Bhola, Barisal"),
    Contact(4,"Siam","01518952550","simi@gmail.com","Comilla,Bangladesh"),

)