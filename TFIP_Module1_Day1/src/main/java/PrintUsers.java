import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PrintUsers {

    public void printUsers() throws FileNotFoundException {
        File usernamesFile = new File("src/db/Usernames.db");
        Scanner scan = new Scanner(usernamesFile);

        while (scan.hasNextLine()){
            System.out.println(scan.nextLine());
        }
    }
}
