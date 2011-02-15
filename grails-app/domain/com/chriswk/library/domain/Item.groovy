package com.chriswk.library.domain

class Item {
    String name
    String tmdbId
    String imdbId
    String country
    Date releaseDate
    SortedSet<Cast> castMembers
    double budget

    static hasMany = {
        [categories: Category, castMembers: Cast]
    }

    static constraints = {
    }
    
}
