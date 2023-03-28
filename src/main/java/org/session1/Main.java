package org.session1;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Starting application...");

        Question q1 = new Question(1, "question 1");
        Question q2 = new Question(2, "question 2");
        Question q3 = new Question(3, "question 3");

        System.out.println(q1 + "\n");
        System.out.println(q2 + "\n");
        System.out.println(q3 + "\n");

//        Answer a1 = Answer.AGREE;

        Candidate c1 = new Candidate();
        c1.setFirstName("first1");
        c1.setLastName("last1");
        c1.setEmail("flast1@gmail.com");
        c1.setPhone("123456789");

        System.out.println(c1 + "\n");

        Candidate c2 = new Candidate("first2", "last2", "flast2@gmail.com", "987654321");
        System.out.println(c2 + "\n");

        List<Candidate> candidateList = new ArrayList<>();
        candidateList.add(c1);
        candidateList.add(c2);

        List<Question> questions = new ArrayList<>();
        questions.add(q1);
        questions.add(q2);
        questions.add(q3);

//        Set<Question> set = new HashSet<Question>(questions);
//
//        System.out.println("list of questions "+questions + "\n");
//        System.out.println("set of questions "+set + "\n");
//        System.out.println("are they equal "+q1.equals(q2));
//        List<Integer> listeProve = new ArrayList<>();
//        listeProve.add(1);
//        listeProve.add(1);
//        listeProve.add(2);
//
//        System.out.println(listeProve);
//        Set<Integer> set2 = new HashSet<Integer>(listeProve);
//        System.out.println(set2);

        Survey survey = new Survey("Math Survey", "Mathematics", "A short survey about mathematics.", questions);

        System.out.println(survey + "\n");

        System.out.println(survey.validateSurvey());
        List<SurveyResult> surveyResultList = new ArrayList<>();
//        Map<Question, Answer> result = new HashMap<>();
//        result.put(q1, Answer.AGREE);
//        result.put(q2, Answer.AGREE);
//        result.put(q3, Answer.DISAGREE);
//
//        Map<Question, Answer> result2 = new HashMap<>();
//        result2.put(q1, Answer.SLIGHLTY_AGREE);
//        result2.put(q2, Answer.DISAGREE);
//        result2.put(q3,Answer.SLIGHTLY_DISAGREE);
//
//        SurveyResult surveyResult1 = new SurveyResult(survey, c1, result);
//        SurveyResult surveyResult2 = new SurveyResult(survey, c2, result2);
//
//        System.out.println(surveyResult1);
//        System.out.println(surveyResult2);
//
//        System.out.println(surveyResult1.candidateResults(c1));
//        System.out.println(surveyResult2.candidateResults(c2));


//
//
//        Map<Question, Answer> result = new HashMap<>();
//
//
//        Scanner scanner = new Scanner(System.in);

//        System.out.println("Enter answer: ");
//
//        String answer = scanner.nextLine();
//
//        System.out.println("answer is: "+ Answer.AGREE.name());
//
//        if (answer.equals(Answer.AGREE.name())){
//            result.put(q1, Answer.AGREE);
//            result.put(q2, Answer.AGREE);
//            System.out.println(true);
//        }else {
//            System.out.println(false);
//        }
//        System.out.println(result + "\n");
//
//        SurveyResult surveyResult1 = new SurveyResult(survey, c1, result);
//        SurveyResult surveyResult2 = new SurveyResult(survey, c2, result);
//        System.out.println(surveyResult1);
//        System.out.println(surveyResult2);
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
                        while (true) {
                        String answer = scanner.nextLine();

                            if (answer.equalsIgnoreCase(Answer.AGREE.name())) {
                                questionAnswerMap.put(q, Answer.AGREE);
                                break;
                            } else if (answer.equalsIgnoreCase(Answer.SLIGHLTY_AGREE.name())) {
                                questionAnswerMap.put(q, Answer.SLIGHLTY_AGREE);
                                break;
                            } else if (answer.equalsIgnoreCase(Answer.SLIGHTLY_DISAGREE.name())) {
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

}