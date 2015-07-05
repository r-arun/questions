function onQuestionSubmit() {
    var questionText = $($("#question-form-element").find("#question-element")[0]).val();
    $.ajax({
        type: "POST",
        url: "create-question",
        data: $("#question-form-element").serialize(),
        success: function(content, status) {
            $("#question-list").append('<li class="list-group-item">'
                    + '<a href="view-question?questionId=' + content + '">'
                    + questionText + "</a></li>");
            $($("#question-form-element").find("#question-element")[0]).val("");
        }
    });
    return false;
};