package org.session1;

public class Question {

    private Integer index;

    private String questionDescription;

    private Answer answer;

    public Question(Integer index, String questionDescription) {
        this.index = index;
        this.questionDescription = questionDescription;
    }

    @Override
    public int hashCode() {
        return questionDescription.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Question))
            return false;

        Question question = (Question) obj;
        return question.questionDescription.equals(questionDescription);
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getQuestionDescription() {
        return questionDescription;
    }

    public void setQuestionDescription(String questionDescription) {
        this.questionDescription = questionDescription;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "index=" + index +
                ", questionDescription='" + questionDescription + '\'' +
                '}';
    }

}
