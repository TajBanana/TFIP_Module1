import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestResources {
    public void readFile() throws FileNotFoundException {
        String fileName = "cookie_file.txt";

        System.out.println(getClass().getResource(fileName));
        File file = new File(getClass().getResource(fileName).getPath());
        Scanner scan = new Scanner(file);

        int i = 0;
        while(i <= 3 && scan.hasNextLine()) {
            System.out.println(scan.nextLine());
            i++;
        }
    }
}