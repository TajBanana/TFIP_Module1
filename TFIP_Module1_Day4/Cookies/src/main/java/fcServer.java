import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class fcServer {
    public static void main(String[] args) throws IOException, InterruptedException {
/*        System.out.println(args[0]);
        System.out.println(args[1]);*/


        int portNumber = Integer.parseInt(args[0]) ;
        String cookieFileName = args[1];

        System.out.printf("listening at port %s", portNumber);
//        create server port and block until a connection arrives
        ServerSocket server = new ServerSocket(portNumber);
        Socket socket = server.accept();
        String msg;

//  ----------------------------------------------------------------------------------------    LISTEN FOR CLIENT OUTPUT
        InputStream is = socket.getInputStream();
        BufferedInputStream bis = new BufferedInputStream(is);
        DataInputStream dis = new DataInputStream(bis);
        msg = dis.readUTF();

        System.out.println("Client Message: " + msg);

//  ----------------------------------------------------------------------------------------    IF CLIENT MSG = GET-COOKIE
        if (msg.equals("get-cookie")) {
            OutputStream os = socket.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(os);
            DataOutputStream dos = new DataOutputStream(bos);

            Cookie cookie = new Cookie();
            msg = cookie.getCookieMsg(cookieFileName);

            dos.writeUTF(msg);
            dos.flush();
        }

//  ----------------------------------------------------------------------------------------    CLOSE SOCKET
        socket.close();
        System.out.println("Server port closed");



/*//        get input stream from the server socket endpoint
            try (InputStream is =  socket.getInputStream()) {
//            determine how the date should be reads
                BufferedInputStream bis = new BufferedInputStream(is);
                DataInputStream dis = new DataInputStream(bis);

//            repeat reading the message if the message from the client side is not "exit"
                while (!msg.equals("exit")) {
                    msg = dis.readUTF(); //Read the date from client side, block until data arrives
                    System.out.println("message from client: " + msg);
                }

//            throws an EOFException when socket is closed from the client side
            } catch (EOFException e) {
                System.out.println("client port closed");
                socket.close();
                System.out.println("Server port closed");
            }*/

    }
}
