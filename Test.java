import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("probnoe.txt");
        File file1 = new File("temp.txt");
        PrintWriter printWriter = new PrintWriter(file1);
        Scanner scanner = new Scanner(file);
        printWriter.println("[");
        String question = "";
        ArrayList<String> list = new ArrayList<>();
        ArrayList<ArrayList<String>> options = new ArrayList<>();
        ArrayList<String> option = new ArrayList<>();
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
                        
                    } else if (word.charAt(0) >= '0' && word.charAt(0) <= '9' && word.charAt(1) >= '0'
                            && word.charAt(1) <= '9') {
                        System.out.println("condition detected");
                    }
                }
            } 
            else  {
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
                if (j==temp.size()-1) {
                    printWriter.println("\""+temp.get(j)+"\"");
                    break;
                }
                if (temp.get(j).length() == 2 && temp.get(j).charAt(0) == 'A' && temp.get(j).charAt(1) == ')') {
                    System.out.println(temp.get(j));
                    j++;
                    break;
                }
                String word = "";
                while (true) {
                    if (j==temp.size()-1) {
                        break;
                    }
                    if (temp.get(j).length() == 2 && temp.get(j).charAt(0) >= 'A' && temp.get(j).charAt(0) <= 'H' && temp.get(j).charAt(1) == ')') {
                        if (temp.get(j).length() == 2 && temp.get(j).charAt(0) == 'A' && temp.get(j).charAt(1) == ')') {
                            System.out.println(temp.get(j));
                            j--;
                        }
                        j++;
                        break;
                    }
                    word+=temp.get(j) + " ";
                    j++;
                }
                printWriter.println("\""+word+"\",");
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
        System.out.println("Hello");
    }
}