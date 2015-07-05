<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="question" type="com.home.project.entities.Questions" %>

<div class="row">
    <ol class="breadcrumb">
        <li><a href="topics">Home</a></li>
        <c:if test="${not empty question}">
            <li><a href="list-questions?topicId=${question.topicId}">Topic</a></li>
            <c:if test="${not empty question.parentId}">
                <li><a href="view-question?questionId=${question.parentId}">Parent Question</a></li>
            </c:if>
        </c:if>
    </ol>
</div>