package org.example.pomodoro

class Task {
    String summary
    String details
    Date dateCreated
    Date deadline
    Long timeSpent = 0L
	
    static hasMany = [tags: Tag]

    static constraints = {
        summary blank: false, unique: true
        details blank: false, maxSize: 1000
        deadline nullable: true
        timeSpent min: 0L
    }
}
