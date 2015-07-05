function populateAnswersAndSubQuestions() {
    populateAnswerContainer($("#answer-data").html());
}

function insertNewAnswer(answerText) {
	hideNoAnswer();
    insertIntoAnswerList(answerText);
}

function populateAnswerContainer(answerJSON) {
    var answers = JSON.parse(answerJSON);
    if (answers.length == 0) {
        displayNoAnswer();
    }
    else {
        displayAnswerList(answers);
    }
}

function displayNoAnswer() {
    $($("#no-answer-item")).removeClass("template");
}

function hideNoAnswer() {
    $($("#no-answer-item")).addClass("template");
}


function displayAnswerList(answers) {
	hideNoAnswer();
    for (var i = 0; i < answers.length; ++i) {
    	insertIntoAnswerList(answers[i].text.text);
    }
}

function insertIntoAnswerList(answerText) {
	var answerList = $("#answer-list");
    answerList.append(createNewAnswerItem(answerText));
}

function createNewAnswerItem(answerText) {
    var newAnswerItem = $("#valid-answer-item-template").clone();
    $(newAnswerItem).removeAttr("id");
    $(newAnswerItem).removeClass("template");
    setAnswerText(newAnswerItem, answerText);
    return newAnswerItem;
}

function setAnswerText(newAnswerItem, answerText) {
    var answerContainer = $(newAnswerItem).find("#answer-container")[0];
    var answerTextField = $(answerContainer).find("#answer-text")[0];
    $(answerTextField).html(answerText);
}