package com.home.project;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.home.project.entities.Answers;
import com.home.project.entities.Questions;
import com.home.project.entities.Texts;
import com.home.project.entities.Topics;
import com.home.project.entity.managers.AnswersDAOManager;
import com.home.project.entity.managers.QuestionsDAOManager;
import com.home.project.entity.managers.TopicsDAOManager;

@Controller
public class HomePageController {
	private final TopicsDAOManager topicsManager = new TopicsDAOManager();
	private final QuestionsDAOManager questionsManager = new QuestionsDAOManager();
	private final AnswersDAOManager answersManager = new AnswersDAOManager();
	private final Gson gson = new Gson();

	@RequestMapping(value = "/topics", method = RequestMethod.GET)
	public String listTopics(Model model) {
		List<Topics> topicList = topicsManager.getTopicList();
		for (Topics topic : topicList) {
			System.out.println(topic.getTopicName());
		}
		model.addAttribute(ModelAttributes.TOPIC_LIST.getName(), topicList);
		return "topics";
	}

	@RequestMapping(value = "/list-questions", method = RequestMethod.GET)
	public String listQuestionsForTopic(@RequestParam("topicId") int topicId, Model model) {
		List<Questions> questionsList = topicsManager.getParentQuestionsInATopic(topicId);
		for (Questions question : questionsList) {
			System.out.println(question.getId() + " " + question.getText().getText());
		}
		model.addAttribute(ModelAttributes.QUESTION_LIST.getName(), questionsList);
		model.addAttribute(ModelAttributes.TOPIC_ID.getName(), topicId);
		return "questions";
	}

	@RequestMapping(value = "/view-question", method = RequestMethod.GET)
	public String listAnswersForQuestion(@RequestParam("questionId") int questionId, Model model) {
		Questions question = questionsManager.getQuestionsById(questionId);
		List<Answers> answersList = answersManager.getAnswersForQuestion(questionId);
		List<Questions> childQuestionsList = questionsManager.getAllChildrenQuestions(questionId);
		model.addAttribute(ModelAttributes.ANSWER_LIST.getName(), gson.toJson(answersList));
		model.addAttribute(ModelAttributes.QUESTION_LIST.getName(), childQuestionsList);
		model.addAttribute(ModelAttributes.QUESTION.getName(), question);
		return "detailed-question-view";
	}

	@RequestMapping(value = "/submit-answer", method = RequestMethod.POST)
	public String submitAnswerForQuestion(@RequestParam("questionId") int questionId, @RequestParam("answer") String answerText, Model model) {
		Answers answer = new Answers();
		answer.setCreatedTimeStamp(new Date());
		answer.setQuestionId(questionId);
		answer.setRelevance(1);
		Texts text = new Texts();
		text.setLastUpdated(new Date());
		text.setText(answerText);
		text.setVersion(1);
		answer.setText(text);
		answersManager.persist(answer);
		
		return "answers";
	}
	
	@ResponseBody
	@RequestMapping(value = "/create-question", method = RequestMethod.POST)
	public String createQuestion(@RequestParam(value="parentId", required=false) String parentId, @RequestParam("topicId") int topicId, @RequestParam("content") String content) {
		Questions question = new Questions();
		question.setCreatedTimestamp(new Date());
		System.out.println("Parent id is " + parentId);
        if (parentId != null) {
                question.setParentId(Integer.parseInt(parentId));
		}
		question.setTopicId(topicId);
		question.setState("Unanswered");
		question.setRelevance(1);
		Texts text = new Texts();
		text.setLastUpdated(new Date());
		text.setText(content);
		text.setVersion(1);
		question.setText(text);
		questionsManager.persist(question);
		return String.valueOf(question.getId());
	}

	@AllArgsConstructor
	@Getter
	private enum ModelAttributes {
		TOPIC_ID("topicId"),
		TOPIC_LIST("topicList"),
		QUESTION_LIST("questionList"),
		QUESTION("question"),
		ANSWER_LIST("answerList");

		private String name;
	}

}
