package org.example.pomodoro

class MainTagLib {
    static namespace = "pomo"
    
    /**
     * @attr date REQUIRED The date that is to be formatted.
     */
    def shortDate = { attrs ->
        out << g.formatDate(date: attrs.date, format: "dd MMM yyyy")
    }
    
    /**
     * @attr date REQUIRED The date that is to be formatted.
     */
    def deadline = { attrs ->
        def cssClass = ""
        def today = new Date()
        def dateWithoutTime = attrs.date
        today.clearTime()
        dateWithoutTime.clearTime()
        
        def diff = dateWithoutTime - today
        if (diff < 0) {
            cssClass = "past"
        }
        else if (diff == 0) {
            cssClass = "today"
        }
        else if (diff < 5) {
            cssClass = "imminent"
        }
        
        out << "<span class=\"$cssClass\">" << pomo.shortDate(date: attrs.date) << "</span>"
    }
    
    def textToParagraphs = { attrs, body ->
        out << "<p>" << body().trim().replaceAll(/(\s*\n)+/, "<p></p>") << "</p>"
    }
}
