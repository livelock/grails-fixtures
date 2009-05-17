package grails.fixture

class FixtureBeanPostProcessor extends AbstractFixtureBeanPostProcessor {

    def getDomainClass(clazz) {
        this.parentCtx.getBean('grailsApplication').getDomainClass(clazz.name)
    }
    
    def getMessageSource() {
        this.parentCtx.getBean('messageSource')
    }
}