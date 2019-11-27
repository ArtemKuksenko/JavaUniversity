import java.io.File;
import java.io.IOException;

public class ThirdTask {

    public static void main(String[] args) {
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
