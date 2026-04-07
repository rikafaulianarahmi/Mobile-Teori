package com.example.tugasindividu

class MovieManager {
    var collectorName: String = ""
        get() = if (field.isEmpty()) "GUEST" else field
        set(value) {
            field = value.uppercase()
        }

    val movieList = ArrayList<Movie>()

    fun addMovie() {
        println("\n=== ADD NEW MOVIE ===")
        print("Enter the title of the movie: ")
        val inputTitle = readlnOrNull() ?: ""

        var inputYear: Int
        while (true) {
            print("Enter the year of release: ")
            val yearStr = readlnOrNull()?.trim() ?: ""
            val yearNum = yearStr.toIntOrNull()

            if (yearNum != null && yearStr.length == 4) {
                inputYear = yearNum
                break
            } else {
                println("Invalid input. Year must be 4 digits number.")
            }
        }

        var inputRating: Int
        while (true) {
            print("Enter your personal rating (1-10): ")
            val ratingNum = readlnOrNull()?.toIntOrNull()

            if (ratingNum != null && ratingNum in 1..10) {
                inputRating = ratingNum
                break
            } else {
                println("Invalid input. Rating must be a number between 1 to 10")
            }
        }

        val newMovie = Movie(inputTitle, inputYear, inputRating)
        movieList.add(newMovie)

        println("Great, '$inputTitle' succesfully added.")
    }

    fun listData() {
        println("\n=== MOVIE LIST COLLECTION ===")
        if (movieList.isEmpty()) {
            println("Collection still empty.")
            return
        }

        for ((index, movie) in movieList.withIndex()) {
            println("${index + 1}. ${movie.title} (${movie.year}), Rating ${movie.personalRating}")
        }
    }

    fun showDataKeyValue() {
        println("\n=== DETAIL DATA ===")
        if (movieList.isEmpty()) {
            println("Collection still empty.")
        }

        for ((index, movie) in movieList.withIndex()) {
            println("--- Data ${index + 1} ---")
            println("Title              : ${movie.title}")
            println("Year               : ${movie.year}")
            println("Personal Rating    : ${movie.personalRating}")
        }
    }

    fun editMovie() {
        print("\nEnter the movie title that you want to edit: ")
        val findTitle = readlnOrNull() ?: ""
        val movie = movieList.find { it.title.equals(findTitle, ignoreCase = true) }

        if (movie != null) {
            println("Data found! Title: ${movie.title}")

            while (true) {
                print("New Rating (1-10): ")
                val ratingStr = readlnOrNull()?.trim() ?: ""

                val ratingNum = ratingStr.toIntOrNull()
                if (ratingNum != null && ratingNum in 1..10) {
                    movie.personalRating = ratingNum
                    break
                } else {
                    println("Invalid input. Rating must be a number between 1 to 10")
                }
            }

            println("Your data is succesfully updated")
        } else {
            println("The movie title not found.")
        }
    }

    fun deleteMovie() {
        print("\nEnter the movie title to delete: ")
        val searchTitle = readlnOrNull() ?: ""

        val movie = movieList.find { it.title.equals(searchTitle, ignoreCase = true) }

        if (movie != null) {
            movieList.remove(movie)
            println("Movie '${movie.title}' has deleted from your collection.")
        } else {
            println("Movie not found.")
        }
    }
}