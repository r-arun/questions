<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<ul class="list-group" id="answer-list">
    <li id="no-answer-item" class="list-group-item template">No answers yet.</li>
    <li id="valid-answer-item-template" class="list-group-item template">
        <app:display-answer />
    </li>
</ul>