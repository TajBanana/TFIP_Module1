import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cookie {
    private File cookieFile;

    public String getCookieMsg(String cookieFileName) throws IOException {
        InputStream in = getClass().getResourceAsStream("/" + cookieFileName);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        System.out.println(getClass().getResourceAsStream("/" + cookieFileName));

        List<String> cookieArrayList = new ArrayList<>();
        String cookieMsg;

        String cookieFileMsg;
        while ((cookieFileMsg = br.readLine())!= null) {
            cookieArrayList.add(cookieFileMsg);
        }

//        System.out.println(cookieArrayList);
        int randomInt = (int) (Math.random()*360);
        cookieMsg = cookieArrayList.get(randomInt);

        br.close();
        return cookieMsg;
    }
}