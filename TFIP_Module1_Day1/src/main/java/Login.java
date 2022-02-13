import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Login {
    private String username;
    private String userDir;
    private String usernameFilePath = "src/db/Usernames.db";
    private File usernameFile = new File("src/db/Usernames.db");


    public boolean exists(String username, String userDir) throws IOException {
        List<String> usersList = new ArrayList<>();

        //check username with the existing files to see if they have an account
        this.username = username;
        this.userDir = userDir;
        
        Scanner scanUsernameFile = new Scanner(usernameFile);

        while (scanUsernameFile.hasNextLine()) {
            usersList.add(scanUsernameFile.nextLine());
        }

        if (usersList.contains(username)) {
            return true;
        } else {

            String newUsername;
            if (usernameFile.length() == 0){
                newUsername = username;
            } else {
                newUsername = "\n" + username;
            }

            Files.write(Paths.get(usernameFilePath), newUsername.getBytes(), StandardOpenOption.APPEND);
            String cartFile = userDir + username + ".db";
            FileWriter writer = new FileWriter(cartFile);
            return false;
        }
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}