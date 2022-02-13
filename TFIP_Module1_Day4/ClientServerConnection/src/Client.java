import java.io.*;
import java.net.Socket;


public class Client {
    public static void main(String[] args) throws IOException {
//        create socket to connect to server
        Socket socket = new Socket("localhost", 1234); // insert ip address or "localhost" and port number

//        defining output to server
        try (OutputStream os = socket.getOutputStream()) {
            System.out.println("Please key in your message to server:");
            BufferedOutputStream bos = new BufferedOutputStream(os);
            DataOutputStream dos = new DataOutputStream(bos);

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String msg = "";

            while(!msg.equals("exit")) {
                msg = br.readLine();
                dos.writeUTF(msg);
//                System.out.println("this message is to be sent to the server: " + msg);
                dos.flush(); //flush the output stream to send data to server
            }
        }
        socket.close();
    }
}