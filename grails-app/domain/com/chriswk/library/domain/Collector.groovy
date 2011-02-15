package com.chriswk.library.domain

class Collector {

	String username
	String password
	boolean enabled
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

    static hasMany = {
        [openIds: OpenID, collection: Item]
    }
	static constraints = {
		username blank: false, unique: true
		password blank: false
	}

	static mapping = {
		password column: '`password`'
	}

	Set<Role> getAuthorities() {
		CollectorRole.findAllByCollector(this).collect { it.role } as Set
	}
}
