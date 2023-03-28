package org.session1;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Starting application...");

        Question q1 = new Question(1, "question 1");
        Question q2 = new Question(2, "question 2");
        Question q3 = new Question(3, "question 3");


        Candidate c1 = new Candidate();
        c1.setFirstName("first1");
        c1.setLastName("last1");
        c1.setEmail("flast1@gmail.com");
        c1.setPhone("123456789");

        Candidate c2 = new Candidate("first2", "last2", "flast2@gmail.com", "987654321");

        List<Candidate> candidateList = new ArrayList<>();
        candidateList.add(c1);
        candidateList.add(c2);

        List<Question> questions = new ArrayList<>();
        questions.add(q1);
        questions.add(q2);
        questions.add(q3);

        Survey survey = new Survey("Math Survey", "Mathematics", "A short survey about mathematics.", questions);


        System.out.println(survey.validateSurvey());
        List<SurveyResult> surveyResultList = new ArrayList<>();

        System.out.println("Welcome to Survey Application...");

        while (true){

            System.out.println("Enter your candidate data to take survey: ");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter first name: ");
            String fname = scanner.nextLine();
            System.out.println("Enter last name: ");
            String lname = scanner.nextLine();
            Candidate candidate = new Candidate();
            Integer check=0;


            for(Candidate c:candidateList){
                if(c.getFirstName().equals(fname)&&c.getLastName().equals(lname)){
                    check=1;
                    System.out.println("Valid candidate. Please continue to the survey");
                    candidate=c;
                    System.out.println("Please choose an answer for each question.");
                    Map<Question, Answer> questionAnswerMap = new HashMap<>();


                    for(Question q:survey.getQuestionList()) {
                        System.out.println("Question " + q.getIndex());
                        System.out.println(q.getQuestionDescription());
                        System.out.println("Agree   Disagree   Slightly Agree   Slightly Disagree");
                        while (true) {
                        String answer = scanner.nextLine();

                            if (answer.equalsIgnoreCase(Answer.AGREE.name())) {
                                questionAnswerMap.put(q, Answer.AGREE);
                                break;
                            } else if (answer.equalsIgnoreCase(Answer.SLIGHTLY_AGREE.name().replace('_',' '))) {
                                questionAnswerMap.put(q, Answer.SLIGHTLY_AGREE);
                                break;
                            } else if (answer.equalsIgnoreCase(Answer.SLIGHTLY_DISAGREE.name().replace('_',' '))) {
                                questionAnswerMap.put(q, Answer.SLIGHTLY_DISAGREE);
                                break;
                            } else if (answer.equalsIgnoreCase(Answer.DISAGREE.name())) {
                                questionAnswerMap.put(q, Answer.DISAGREE);
                                break;
                            } else {
                                System.out.println("Not valid answer. ");
                            }
                        }
                    }
                    SurveyResult surveyResult = new SurveyResult(survey, candidate, questionAnswerMap);
                    surveyResultList.add(surveyResult);
                    surveyResult.candidateResults(candidate);
                    break;
                }
            }
            if(check==0){
                System.out.println("Not a valid candidate.");
                continue;
            }

            System.out.println("You have finished your survey!");


        }

    }

//    public void surveyResults (List<SurveyResult> surveyResultList) {
//        for(SurveyResult surveyResult: surveyResultList){
//            List<Integer> counter = List.of(0,0,0,0);
//            for (Map.Entry<Question, Answer> entry : surveyResult.getResults().entrySet()) {
//                Question question = entry.getKey();
//                Answer answer = entry.getValue();
//
//                if(answer.name().equals(Answer.AGREE.name())){
//                    Integer var =counter.get(0);
//                    counter.set(0, var++);
//                }else if(answer.name().equals(Answer.SLIGHTLY_AGREE.name())){
//                    Integer var =counter.get(1);
//                    counter.set(1, var++);
//                }else if(answer.name().equals(Answer.SLIGHTLY_DISAGREE.name())){
//                    Integer var =counter.get(2);
//                    counter.set(2, var++);
//                }else if(answer.name().equals(Answer.DISAGREE.name())){
//                    Integer var =counter.get(3);
//                    counter.set(3, var++);
//                }
//
//            }
//
//        }
//    }
}