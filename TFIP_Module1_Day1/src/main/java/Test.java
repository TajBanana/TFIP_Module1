import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {

/*        FileWriter writer = new FileWriter("/Users/taj/Desktop/file.txt");
        writer.write("this is my file");*/

//        File file = new File("src/db/Usernames.db");
//        System.out.println(file.exists());
//        System.out.println(file.length());

//        read strings into cart array

//        File readFile = new File("src/db/paul.db");
//        Scanner scanFile = new Scanner(readFile);
//
//        List<String> list = new ArrayList<>();
//        while(scanFile.hasNextLine()) {
//            list.add(scanFile.next());
//        }
//
//        System.out.println(list);

//        Write list into file

        List<String> arr = new ArrayList<>();
        arr.add("123");
        arr.add("123");
        arr.add("123");
        arr.add("123");
        arr.add("456");
        arr.add("456");
        arr.add("456");

        PrintWriter writer = new PrintWriter("src/db/text.txt");
        writer.print("");

        for(String str: arr) {
            writer.write(str + System.lineSeparator());
        }
        writer.close();
    }
}

