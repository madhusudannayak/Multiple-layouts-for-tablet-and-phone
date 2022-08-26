package com.example.multitab2

data class DataModel(
    val id: Int,
    val title: String,
    val address: String,
)

val data = arrayListOf(
    DataModel(1, "Madhusudan nayak", "Vill : Mirjapur,p.s: Tamluk"),
    DataModel(2, "Amit nayak", "Vill : Kurpai,p.s: kolkata"),
    DataModel(3, "R nayak", "Vill : sample,p.s: sample"),
)