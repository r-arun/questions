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
<app:bootstrap-css-include />
</head>

<body onload="populateAnswersAndSubQuestions();">
<app:bootstrap-js-include />
<nav class="navbar navbar-default">
</nav>
<div id="answer-data" class="data">${answerList}</div>
<div class="container">
    <app:bread-crumb question="${question}" />
	<div class="row">
        <app:display-question questionText="${question.text.text}" />
    </div>
    <div class="row">
        <div class="col-md-6 well">
            <h4>Answers</h4>
            <app:display-answer-list />
            <app:answer-form questionId="${question.id}" />
        </div>
        <div class="col-md-6 well">
            <h4>Sub Questions</h4>
            <app:question-list questionList="${questionList}"/>
            <app:question-form parentId="${question.id}" topicId="${question.topicId}"/>
        </div>
    </div>
</div>
</body>
</html>