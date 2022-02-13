import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class fcClient {
    public static void main(String[] args) throws IOException {
        String hostPort = args[0];
        String[] arrHostPort = hostPort.split(":",2);
        String localHost = arrHostPort[0];
        int portNumber = Integer.parseInt(arrHostPort[1]);

//        create socket to connect to server
        Socket socket = new Socket(localHost, portNumber); // insert ip address or "localhost" and port number

//  ----------------------------------------------------------------------------------------    LISTEN FOR CLIENT INPUT
        OutputStream os = socket.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(os);
        DataOutputStream dos = new DataOutputStream(bos);

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String msg = "get-cookie";

        dos.writeUTF(msg);
        dos.flush(); //flush the output stream to send data to server

//  ----------------------------------------------------------------------------------------    LISTEN FOR SERVER OUTPUT

        InputStream is = socket.getInputStream();
        BufferedInputStream bis = new BufferedInputStream(is);
        DataInputStream dis = new DataInputStream(bis);

        String cookieMsg = dis.readUTF();
        System.out.println(cookieMsg);


        socket.close();
        System.out.println("client port closed");

/*//        defining output to server
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
        socket.close();*/
    }
}