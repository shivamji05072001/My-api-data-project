package com.example.apidata

class Users : ArrayList<Users.UsersItem>(){
    data class UsersItem(
        val id: Int,
        val name: String,
        val profileImage: String,
        val qualification: List<String>,
        val subjects: List<String>
    )
}