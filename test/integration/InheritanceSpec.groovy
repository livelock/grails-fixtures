import grails.plugin.spock.*

import inheritance.*
import spock.lang.*

class InheritanceSpec extends IntegrationSpec {

	def fixtureLoader
	
	def "basic inheritance"() {
		when:
		def f = fixtureLoader.build {
			p(Sub, common: "p")
			t(Thing, parent: p)
		}
		then:
		f.t.parent.common == "p"
	}

	@Issue("GRAILS-6714")
	def "other way"() {
		when:
		def f = fixtureLoader.build {
			t(Thing)
			p(Sub, common: "p", things: [t])
		}
		then:
		f.t.parent.common == "p"
	}
	

}