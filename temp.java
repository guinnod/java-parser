import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class temp {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("probnoe.txt");
        File file1 = new File("temp.txt");
        PrintWriter printWriter = new PrintWriter(file1);
        Scanner scanner = new Scanner(file);
        String question = "";
        ArrayList<String> list = new ArrayList<>();
        ArrayList<ArrayList<String>> options = new ArrayList<>();
        ArrayList<String> option = new ArrayList<>();
        while (scanner.hasNext()) {
            String word = scanner.next();
            if (word.endsWith(".")) {
                if (word.length() == 2 || word.length() == 3) {
                    if (word.charAt(0) >= '0' && word.charAt(0) <= '9') {
                        if (!option.isEmpty()) {
                            options.add(option);
                            System.out.println(option);
                            option.clear();
                        }
                        while (true) {
                            String s = scanner.next();
                            if (s.length() == 2 && s.charAt(0) >= 'A' && s.charAt(0) <= 'H' && s.charAt(1) == ')') {
                                break;
                            }
                            question += s + " ";
                        }
                        list.add(question);
                        question = "";
                    } else if (word.charAt(0) >= '0' && word.charAt(0) <= '9' && word.charAt(1) >= '0'
                            && word.charAt(1) <= '9') {
                        System.out.println("condition detected");
                    }
                }
            } 
            else if (word.length() == 2 && word.charAt(0) >= 'A' && word.charAt(0) <= 'H' && word.charAt(1) == ')') {


            }
        }
        printWriter.println(list);
        printWriter.flush();
        printWriter.close();
        scanner.close();
        System.out.println("Hello");
    }
}
