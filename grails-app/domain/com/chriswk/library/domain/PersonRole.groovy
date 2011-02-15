package com.chriswk.library.domain

class PersonRole {
    String roleName
    static constraints = {
        rolename(unique: true)
    }
}
