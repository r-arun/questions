<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="parentId" type="java.lang.Integer" %>
<%@ attribute name="topicId" type="java.lang.Integer" %>

<script src="resources/add-question-form-script.js"></script>
<form action="create-question" method="POST" id="question-form-element" onsubmit="return onQuestionSubmit();">
<div class="form-group">
    <label>Add a new question</label>
    <textarea id="question-element" class="form-control" name="content"></textarea>
</div>
<c:if test="${not empty parentId}">
        <input type="hidden" name="parentId" value="${parentId}" />
</c:if>
<input type="hidden" name="topicId" value="${topicId}" />
<div class="form-group">
    <button type="submit"class="btn btn-primary">Save</button>
</div>
</form>