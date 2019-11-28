import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class ThirdTask {

    public static void main(String[] args) {

        RandomWords randomWord = new RandomWords();
        System.out.println("Рандомное слово: "+randomWord.getRandomWord());

        File[] arrFiles = new File[10];
        File dir = new File("/home/co/IdeaProjects/1stTask/src/files");
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            arrFiles[i] = new File(dir,String.valueOf(i) + ".txt" );
            try {
                arrFiles[i].createNewFile();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }
    }
}

class RandomWords {
    private String[] words;
    Random random;
    RandomWords(){
        this.random = new Random();
        String str = "Емкость в ArrayList представляет размер массива," +
                " который будет использоваться для хранения объектов. " +
                "При добавлении элементов фактически происходит " +
                "перераспределение памяти - создание нового массива " +
                "и копирование в него элементов из старого массива. " +
                "Изначальное задание емкости ArrayList позволяет " +
                "снизить подобные перераспределения памяти, " +
                "тем самым повышая производительность.";
        this.words = str.split(" ");
    }

    public String getRandomWord(){
        return this.words[ random.nextInt( this.words.length ) ];
    }
}
