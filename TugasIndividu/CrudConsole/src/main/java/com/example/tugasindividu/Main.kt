package com.example.tugasindividu

fun main() {
    val manager = MovieManager()

    println("================================")
    println("        MOVIE COLLECTION       ")
    println("================================")

    print("Enter collector's name: ")
    manager.collectorName = readlnOrNull() ?: ""

    println("Welcome, ${manager.collectorName}. Get ready to manage your collection!")

    var isRunning = true
    while (isRunning) {
        println("\n=== MAIN MENU ===")
        println("1. Add Data")
        println("2. List Data")
        println("3. Edit Data")
        println("4. Delete Data")
        println("5. Show Data")
        println("6. Exit")
        print("Choose menu: ")

        val choices = readlnOrNull() ?: ""

        when (choices) {
            "1" -> manager.addMovie()
            "2" -> manager.listData()
            "3" -> manager.editMovie()
            "4" -> manager.deleteMovie()
            "5" -> manager.showDataKeyValue()
            "6" -> {
                println("Thank you and goodbye, ${manager.collectorName}.")
                isRunning = false
            }
            else -> {
                println("Invalid input. please choose a number from 1 to 6.")
            }
        }
    }
}