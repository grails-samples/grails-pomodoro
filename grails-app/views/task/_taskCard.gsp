<div class="task">
    <h4>${ task.summary }</h4>
    <div><pomo:textToParagraphs>${ task.details }</pomo:textToParagraphs></div>
    <div class="due">Due: <pomo:deadline date="${ task.deadline }"/></div>
    <div class="created">Created: <pomo:shortDate date="${ task.dateCreated }"/></div>
</div>
