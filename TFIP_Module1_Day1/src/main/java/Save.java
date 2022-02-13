import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class Save {
    private String userDir;
    private List<String> itemsArray;
    private String username;

    public void save(String username,String userDir, List<String> itemsArray) throws FileNotFoundException {
        this.userDir = userDir;
        this.itemsArray = itemsArray;
        this.username = username;

        String cartFile = userDir + username + ".db";
        System.out.println(cartFile);

        PrintWriter writer = new PrintWriter(cartFile);
        writer.print("");

        int i = 1;

        for(String items : itemsArray) {
            if (i < itemsArray.size()) {
                writer.write(items + "\n");
            } else {
                writer.write(items);
            }
            i++;
        }

        writer.close();
    }
}
