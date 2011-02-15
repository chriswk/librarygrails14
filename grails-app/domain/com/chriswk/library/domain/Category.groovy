package com.chriswk.library.domain

class Category {
    String name
    String url

    static constraints = {
        name(unique: true)
        url(unique: true)
    }
}
