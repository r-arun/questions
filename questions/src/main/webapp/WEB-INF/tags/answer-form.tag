<%@ attribute name="questionId" type="java.lang.Integer" %>
<form action="submit-answer" id="new-answer-form" onsubmit="return onAnswerSubmit();">
    <div class="form-group">
    	<label>Add a new answer</label>
        <textarea id="answer-element" class="form-control" name="answer" rows="5" cols="100"></textarea>
    </div>
    <input type="hidden" name="questionId" value="${questionId}"/>
    <button type="submit"class="btn btn-primary">Submit Answer</button>
</form>