import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File source = new File("probnoe.txt");
        File toJson = new File("variant.txt");
        PrintWriter printWriter = new PrintWriter(toJson);
        Scanner scanner = new Scanner(source);
        printWriter.println("[");
        String question = "";
        String temp = "";
        ArrayList<String> questions = new ArrayList<>();
        ArrayList<ArrayList<String>> options = new ArrayList<>();
        ArrayList<String> option = new ArrayList<>();
        String word = scanner.next();
        while (scanner.hasNext()) {
            if (word.endsWith(".")) {
                if (word.length() == 2 || word.length() == 3) {
                    if (word.charAt(0) >= '0' && word.charAt(0) <= '9') {
                        System.out.println("test");
                        if (!option.isEmpty()) {
                            System.out.println("added");
                            options.add(option);
                            System.out.println(option);
                            option.clear();
                        }
                        while (true) {
                            try {
                                String wordForQuestion = scanner.next();
                                if (wordForQuestion.length() == 2 && wordForQuestion.charAt(0) >= 'A'
                                        && wordForQuestion.charAt(0) <= 'H' && wordForQuestion.charAt(1) == ')') {
                                    temp = wordForQuestion;
                                    break;
                                }
                                question += wordForQuestion + " ";
                            } catch (Exception e) {
                                break;
                            }
                        }
                        questions.add(question);
                        question = "";
                    } else if (word.charAt(0) >= '0' && word.charAt(0) <= '9' && word.charAt(1) >= '0'
                            && word.charAt(1) <= '9') {
                        System.out.println("condition detected");
                    }
                }
            } else if (temp.charAt(0) >= 'A' && temp.charAt(0) <= 'H') {
                String optionWord = "";

                while (true) {
                    String s = scanner.next();
                    word = s;
                    if (s.length() == 2 && s.charAt(0) >= 'A' && s.charAt(0) <= 'H' && s.charAt(1) == ')') {
                        // System.out.println(temp);
                        temp = s;

                        // System.out.println("braked");
                        break;
                    }
                    optionWord += s + " ";
                }
                option.add(optionWord);
            }
        }
        for (int i = 0; i < questions.size(); i++) {
            printWriter.println("{");
            printWriter.print("\"question\": \"");
            printWriter.print(questions.get(i));
            printWriter.println("\",");
            printWriter.println("\"options\": [");
            for (int j = 0; j < options.get(i).size(); j++) {
                printWriter.print("\"");
                printWriter.print(options.get(i).get(j));
                if (j != options.get(i).size() - 1) {
                    printWriter.println("\",");
                } else {
                    printWriter.println("\"");
                }
            }
            printWriter.println("]");
            printWriter.println("},");
        }
        printWriter.println("]");
        printWriter.flush();
        printWriter.close();
        scanner.close();
        System.out.println("Hello");
    }
}