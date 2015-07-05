<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Questions</title>
</head>
<body>
<p>${question.text.text}</p>
<c:if test="${not empty question.parentId}">
<a href="view-question?questionId=${question.parentId}">View</a> parent question.
</c:if>
<c:if test="${empty answerList}">
No answers yet.
</c:if>
<c:forEach var="answer" items="${answerList}">
<ul>
<li>${answer.text.text}</li>
</ul>
</c:forEach>
<form action="submit-answer">
    <textarea name="answer" rows="5" cols="100"></textarea>
    <input type="hidden" name="questionId" value="${question.id}"/>
    <input type="submit" />
</form>
<app:question-form parentId="${question.id}" topicId="${question.topicId}"></app:question-form>
</body>
</html>