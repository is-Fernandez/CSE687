package edu.syr.hw5;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Question {
    private String q;
    private String prompt;
    private List<String> acceptableAnswers;
    private boolean isLikertScale;

    // Constructor for text-based questions
    public Question(String q, String prompt, List<String> acceptable) {
        this.q = q;
        this.prompt = prompt;
        this.acceptableAnswers = acceptable;
        this.isLikertScale = false;
    }

    // Constructor for Likert scale-based questions
    public Question(String q, String prompt) {
        this.q = q;
        this.prompt = prompt;
        this.isLikertScale = true;
    }

    public void render(PrintStream p) {
        p.println(q);
        p.println(prompt);
        if (isLikertScale) {
            p.println("Please respond with a number between 1 and 5:");
            p.println("1 - Strongly Disagree, 2 - Somewhat Disagree, 3 - Neutral, 4 - Somewhat Agree, 5 - Strongly Agree");
        }
    }

    // Checks if the answer is acceptable
    public boolean isAcceptableAnswer(String s) {
        if (isLikertScale) {
            try {
                int answer = Integer.parseInt(s);
                return answer >= 1 && answer <= 5;  // Likert scale validation
            } catch (NumberFormatException e) {
                return false;
            }
        } else {
            return acceptableAnswers.contains(s);
        }
    }

    // Converts numerical response to Likert scale text
    public String getLikertResponse(int answer) {
        switch (answer) {
            case 1:
                return "Strongly Disagree";
            case 2:
                return "Somewhat Disagree";
            case 3:
                return "Neutral";
            case 4:
                return "Somewhat Agree";
            case 5:
                return "Strongly Agree";
            default:
                return "Invalid";
        }
    }
    public boolean isLikertScale() {
        return isLikertScale;
    }
    // Converts numerical response to Likert scale text


}

public class Questionnaire1 {
    List<Question> questions;
    public Questionnaire1() {
        questions = new ArrayList<>();
    }
    public void addQuestion(Question q) {
        questions.add(q);
    }
    public List<String> administerQuestionnaire() {
        List<String> answers = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (Question q: questions) {
            q.render(System.out);
            String response = "";
            do {
                try {
                    response = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } while (!q.isAcceptableAnswer(response));

            if (q.isLikertScale()) {
                int numericAnswer = Integer.parseInt(response);
                String wordResponse = q.getLikertResponse(numericAnswer); // Convert to word response
                answers.add(wordResponse); // Add the word-based response
            } else {
                answers.add(response); // Text-based response
            }
        }
        return answers;
    }

    public static void main(String[] args) {
        Questionnaire1 q = new Questionnaire1();
        q.addQuestion(new Question("Are you awake?", "True or False: ", Arrays.asList("True", "False", "true", "false", "t", "f", "T", "F")));
        q.addQuestion(new Question("Have you had coffee?", "True or False: ", Arrays.asList("True", "False", "true", "false", "t", "f", "T", "F")));
        q.addQuestion(new Question("Are you ready to get to work?", "True or False: ", Arrays.asList("True", "False", "true", "false", "t", "f", "T", "F")));
        q.addQuestion(new Question("CSE 687 is awesome", "Rate your agreement with the statement below:"));
        List<String> answers = q.administerQuestionnaire();
        System.out.println("complete!");
        System.out.println(answers);
    }
}
