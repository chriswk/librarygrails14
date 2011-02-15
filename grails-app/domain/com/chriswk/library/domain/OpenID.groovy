package com.chriswk.library.domain



class OpenID {

	String url

	static belongsTo = [user: Collector]

	static constraints = {
		url unique: true
	}
}
