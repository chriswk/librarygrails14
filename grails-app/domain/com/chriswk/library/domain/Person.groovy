package com.chriswk.library.domain

class Person {
    String firstName
    String lastName
    Date birthDate
    String country

    static constraints = {
        
    }

    Set<Cast> getProjects() {
        Cast.findAllByCastMember(this).collect { it } as Set
    }
}
