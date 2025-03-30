package edu.syr.hw4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Questionnaire {
    List<String> questions;
    List<String> Liekertquestions;
    public Questionnaire() {
        questions = new ArrayList<>();
        Liekertquestions = new ArrayList<>();
    }
    public void addQuestion(String s) {
        questions.add(s);
    }
    public void addLikertQuestion(String s) {
        Liekertquestions.add(s);
    }
    public List<String> administerQuestionnaire() {
        List<String> answers = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (String s: questions) {
            System.out.println("True or False: ");
            System.out.println(s);
            String response = "";
            boolean validResponse = false;

            while (!validResponse) {
                try {
                    response = reader.readLine();
                    if (response.equalsIgnoreCase("true") || response.equalsIgnoreCase("false")) {
                        validResponse = true;
                    } else {
                        System.out.println("Invalid response. Please enter 'True' or 'False");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            answers.add(response);
        }
        return answers;
    }
    public List<String> administerLikertQuestionnaire() {
        List<String> likertAnswers = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (String s : Liekertquestions) {
            System.out.println("Likert Scale (1-5): ");
            System.out.println(s);
            System.out.println("1: Strongly Disagree");
            System.out.println("2: Somewhat Disagree");
            System.out.println("3: Neutral");
            System.out.println("4: Somewhat Agree");
            System.out.println("5: Strongly Agree");

            String response = "";
            boolean validResponse = false;
            while (!validResponse) {
                try {
                    System.out.print("Your response (1-5): ");
                    response = reader.readLine();
                    int responseInt = Integer.parseInt(response);

                    if (responseInt >= 1 && responseInt <= 5) {
                        validResponse = true;
                        // Convert numerical response to a Likert scale text
                        switch (responseInt) {
                            case 1:
                                response = "Strongly Disagree";
                                break;
                            case 2:
                                response = "Somewhat Disagree";
                                break;
                            case 3:
                                response = "Neutral";
                                break;
                            case 4:
                                response = "Somewhat Agree";
                                break;
                            case 5:
                                response = "Strongly Agree";
                                break;
                        }
                    } else {
                        System.out.println("Invalid response. Please enter an integer between 1 and 5.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid response. Please enter an integer between 1 and 5.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            likertAnswers.add(response);
        }
        return likertAnswers;
    }


    public static void main(String[] args) {
        Questionnaire q = new Questionnaire();
        q.addQuestion("Are you awake?");
        q.addQuestion("Have you had coffee?");
        q.addQuestion("Are you ready to get to work?");
        q.addLikertQuestion("Is CSE 687 Awesome? ");
        List<String> answers = q.administerQuestionnaire();
        List<String> answers2 = q.administerLikertQuestionnaire();
        System.out.println("complete!");
        System.out.println(answers);
        System.out.println(answers2);
    }
}
