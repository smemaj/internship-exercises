package org.session1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Survey {
    private String title;

    private String topic;

    private String description;

    private List<Question> questionList;

//    private List<Answer> answerList;
//
//    private List<Candidate> candidateList;

    public Survey(String title, String topic, String description, List<Question> questionList) {
        this.title = title;
        this.topic = topic;
        this.description = description;
        this.questionList = questionList;
    }


    public void addQuestion(Question question){
        questionList.add(question);
    }

    public void removeQuestion(Question question){
        questionList.remove(question);
    }

    public String validateSurvey (){
        List<Question> questionList = this.getQuestionList();

        if(questionList.size()<10){
            return "Survey not valid! Minimum number of questions (10) not reached";
        }else if (questionList.size()>40){
            return "Survey not valid! Maximum number of questions (40) reached";
        }

        Set<Question> questionSet = new HashSet<>(questionList);

        if(questionSet.size()!=questionList.size()){
            return "Survey is not valid! There are duplicate questions.";
        }

        return "Survey is valid!";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    @Override
    public String toString() {
        return "Survey{" +
                "title='" + title + '\'' +
                ", topic='" + topic + '\'' +
                ", description='" + description + '\'' +
                ", questionList=" + questionList +
                '}';
    }
}
