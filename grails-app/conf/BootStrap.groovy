import org.example.pomodoro.Tag;
import org.example.pomodoro.Task;

class BootStrap {

    def init = { servletContext ->
        def workTag = new Tag(name: "Work").save(failOnError: true)
        def homeTag = new Tag(name: "Home").save(failOnError: true)
        
        def task = new Task(
                summary: "Do 2nd intro screencast",
                details: "Create the second intro screencast for Grails",
                status: "Open",
                deadline: new Date() + 15)
        task.addToTags(workTag)
        task.addToTags(homeTag)
        task.save(failOnError: true)
        
        task = new Task(
                summary: "Shopping",
                details: "Do the grocery shopping - and don't forget the tomatoes!",
                status: "Open",
                deadline: new Date() + 3)
        task.addToTags(homeTag)
        task.save(failOnError: true)
        
        task = new Task(
                summary: "Finish Grails presentation",
                details: "The last presentation on Grails & AMQP for SpringOne 2GX needs finishing.",
                status: "Open",
                deadline: new Date() + 30)
        task.addToTags(workTag)
        task.addToTags(homeTag)
        task.save(failOnError: true)
    }
    def destroy = {
    }
}
