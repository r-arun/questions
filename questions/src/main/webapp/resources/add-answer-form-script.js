function onAnswerSubmit() {
    var answerText = $($("#new-answer-form").find("#answer-element")[0]).val();
    $.ajax({
        type: "POST",
        url: "submit-answer",
        data: $("#new-answer-form").serialize(),
        success: function(content, status) {
            insertNewAnswer(answerText);
            $($("#new-answer-form").find("#answer-element")[0]).val("");
        }
    });
    return false;
};