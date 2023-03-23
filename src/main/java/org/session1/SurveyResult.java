package org.session1;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SurveyResult {

    private Survey survey;

    private Candidate candidate;

    private Date dateTaken;

    private Map<Question, Answer> results;

    public SurveyResult(Survey survey, Candidate candidate, Map<Question, Answer> results) {
        this.survey = survey;
        this.candidate = candidate;
        this.results = results;
    }

    public Survey getSurvey() {
        return survey;
    }

    public Map<Question, Answer> candidateResults (Candidate candidate){
        Map<Question, Answer> placeholder = new HashMap<>();
        if (candidate.getFirstName().equals(this.candidate.getFirstName())){
            return this.getResults();
        }
        return placeholder;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Date getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(Date dateTaken) {
        this.dateTaken = dateTaken;
    }

    public Map<Question, Answer> getResults() {
        return results;
    }

    public void setResults(Map<Question, Answer> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "SurveyResult{" +
                "survey=" + survey +
                ", candidate=" + candidate +
                ", dateTaken=" + dateTaken +
                ", results=" + results +
                '}';
    }
}
