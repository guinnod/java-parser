import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File source = new File("source.txt");
        File raw = new File("raw.txt");
        PrintWriter printWriter = new PrintWriter(raw);
        Scanner scanner = new Scanner(source);
        printWriter.println("[");
        String question = "";
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        while (scanner.hasNext()) {
            String word = scanner.next();
            if (word.endsWith(".")) {
                if (word.length() == 2 || word.length() == 3) {
                    if (word.charAt(0) >= '0' && word.charAt(0) <= '9') {
                        while (true) {
                            String s = scanner.next();
                            if (s.length() == 2 && s.charAt(0) >= 'A' && s.charAt(0) <= 'H' && s.charAt(1) == ')') {
                                temp.add(s);
                                break;
                            }
                            question += s + " ";
                        }
                        list.add(question);
                        question = "";

                    }
                }
            } else {
                temp.add(word);
            }
        }
        int j = 1;
        for (int i = 0; i < list.size(); i++) {
            printWriter.println("{");
            printWriter.print("\"question\": \"");
            printWriter.print(list.get(i));
            printWriter.println("\",");
            printWriter.println("\"options\": [");
            while (true) {
                if (j == temp.size() - 1) {
                    printWriter.println("\"" + temp.get(j) + "\"");
                    break;
                }
                if (temp.get(j).length() == 2 && temp.get(j).charAt(0) == 'A' && temp.get(j).charAt(1) == ')') {

                    j++;
                    break;
                }
                String word = "";
                while (true) {
                    if (j == temp.size() - 1) {
                        break;
                    }
                    if (temp.get(j).length() == 2 && temp.get(j).charAt(0) >= 'A' && temp.get(j).charAt(0) <= 'H'
                            && temp.get(j).charAt(1) == ')') {
                        if (temp.get(j).length() == 2 && temp.get(j).charAt(0) == 'A' && temp.get(j).charAt(1) == ')') {

                            j--;
                        }
                        j++;
                        break;
                    }
                    word += temp.get(j) + " ";
                    j++;
                }
                printWriter.println("\"" + word + "\",");
            }
            printWriter.println("],");
            printWriter.print("\"content\": \"");
            printWriter.println("\",");
            printWriter.print("\"task\": \"");
            printWriter.println("\",");
            printWriter.print("\"taskContent\": \"");
            printWriter.println("\"");
            printWriter.println("},");
        }
        printWriter.println("]");
        printWriter.flush();
        printWriter.close();
        scanner.close();
    }
}