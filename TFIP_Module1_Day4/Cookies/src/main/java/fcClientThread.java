import java.io.*;
import java.net.Socket;

public class fcClientThread {

    public static void main(String[] args) throws IOException {
        String hostPort = args[0];
        String[] arrHostPort = hostPort.split(":", 2);
        String localHost = arrHostPort[0];
        int portNumber = Integer.parseInt(arrHostPort[1]);

//        create socket to connect to server

        for(int i = 0; i < 10; i++) {
            //  ----------------------------------------------------------------------------------------    LISTEN FOR CLIENT INPUT
            Socket socket = new Socket(localHost, portNumber); // insert ip address or "localhost" and port number
            OutputStream os = socket.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(os);
            DataOutputStream dos = new DataOutputStream(bos);

            String msg = "get-cookie";
            dos.writeUTF(msg);
            dos.flush(); //flush the output stream to send data to server

//  ----------------------------------------------------------------------------------------    LISTEN FOR SERVER OUTPUT

            InputStream is = socket.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            DataInputStream dis = new DataInputStream(bis);

            String cookieMsg = dis.readUTF();
            System.out.println(msg + " " + (i + 1));
            System.out.println(cookieMsg);

            socket.close();
        }

        System.out.println("client port closed");

//  ----------------------------------------------------------------------------------------    LISTEN FOR CLIENT INPUT
/*        OutputStream os = socket.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(os);
        DataOutputStream dos = new DataOutputStream(bos);

        String msg = "get-cookie";

        dos.writeUTF(msg);
        dos.flush(); //flush the output stream to send data to server*/

//  ----------------------------------------------------------------------------------------    LISTEN FOR SERVER OUTPUT

/*        InputStream is = socket.getInputStream();
        BufferedInputStream bis = new BufferedInputStream(is);
        DataInputStream dis = new DataInputStream(bis);

        String cookieMsg = dis.readUTF();
        System.out.println(cookieMsg);


        socket.close();
        System.out.println("client port closed");*/
    }
}
