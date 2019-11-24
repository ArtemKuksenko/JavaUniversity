//Поиск вхождения каждого слова с предложение
import java.util.*;
import java.lang.String;

public class FirstTask {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите предложение\n");
        String words = in.nextLine();
        ArrayList<String> checkArr = new ArrayList<>(words.length());
        System.out.println("Result:");
        for (String word : words.split(" "))
            if (checkArr.indexOf(word) == -1) {
                checkArr.add(word);
                System.out.println(Count(word, words) + String.format(" %s", word));
            }
        in.close();
    }

    private static int Count(String word, String words) {
        int cnt = 0;
        for (String el : words.split(" "))
            if (el.equals(word))
                cnt ++;
        return cnt;
    }

}
