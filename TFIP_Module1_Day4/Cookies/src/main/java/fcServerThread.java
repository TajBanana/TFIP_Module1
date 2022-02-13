import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class fcServerThread {

    public static void main(String[] args) throws IOException {

        int portNumber = Integer.parseInt(args[0]) ;
        String cookieFileName = args[1];

        System.out.printf("listening at port %s \n", portNumber);
//        create server port and block until a connection arrives
        ServerSocket server = new ServerSocket(portNumber);

        int i = 0;
        while(i < 10) {
            String msg;
            CookieClientHandler cookieClient = new CookieClientHandler(i+1,server,cookieFileName,portNumber);
            Thread myThread = new Thread(cookieClient);
            myThread.start();

//            System.out.println("Server" + i + " open");

            i++;
        }


//  ----------------------------------------------------------------------------------------    LISTEN FOR CLIENT OUTPUT
/*        InputStream is = socket.getInputStream();
        BufferedInputStream bis = new BufferedInputStream(is);
        DataInputStream dis = new DataInputStream(bis);
        msg = dis.readUTF();

        System.out.println("Client Message: " + msg);*/

//  ----------------------------------------------------------------------------------------    IF CLIENT MSG = GET-COOKIE
/*        if (msg.equals("get-cookie")) {
            OutputStream os = socket.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(os);
            DataOutputStream dos = new DataOutputStream(bos);

            Cookie cookie = new Cookie();
            msg = cookie.getCookieMsg(cookieFileName);

            dos.writeUTF(msg);
            dos.flush();
        }*/

//  ----------------------------------------------------------------------------------------    CLOSE SOCKET
//        TimeUnit.SECONDS.sleep(45);
    }
}