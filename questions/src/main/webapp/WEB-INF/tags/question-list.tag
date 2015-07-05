<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="questionList" type="java.util.List" %>
<ul id="question-list" class="list-group">
    <c:choose>
        <c:when test="${not empty questionList}">
                <c:forEach var="question" items="${questionList}"> 
                    <li class="list-group-item">
                        <a href="view-question?questionId=${question.id}">
                            ${question.text.text}
                        </a>
                    </li>
                </c:forEach>
        </c:when>
    <c:otherwise>
    </c:otherwise>
    </c:choose>
</ul>