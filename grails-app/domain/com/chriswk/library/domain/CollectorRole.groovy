package com.chriswk.library.domain

import org.apache.commons.lang.builder.HashCodeBuilder

class CollectorRole implements Serializable {

	Collector collector
	Role role

	boolean equals(other) {
		if (!(other instanceof CollectorRole)) {
			return false
		}

		other.collector?.id == collector?.id &&
			other.role?.id == role?.id
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		if (collector) builder.append(collector.id)
		if (role) builder.append(role.id)
		builder.toHashCode()
	}

	static CollectorRole get(long collectorId, long roleId) {
		find 'from CollectorRole where collector.id=:collectorId and role.id=:roleId',
			[collectorId: collectorId, roleId: roleId]
	}

	static CollectorRole create(Collector collector, Role role, boolean flush = false) {
		new CollectorRole(collector: collector, role: role).save(flush: flush, insert: true)
	}

	static boolean remove(Collector collector, Role role, boolean flush = false) {
		CollectorRole instance = CollectorRole.findByCollectorAndRole(collector, role)
		instance ? instance.delete(flush: flush) : false
	}

	static void removeAll(Collector collector) {
		executeUpdate 'DELETE FROM CollectorRole WHERE collector=:collector', [collector: collector]
	}

	static void removeAll(Role role) {
		executeUpdate 'DELETE FROM CollectorRole WHERE role=:role', [role: role]
	}

	static mapping = {
		id composite: ['role', 'collector']
		version false
	}
}
