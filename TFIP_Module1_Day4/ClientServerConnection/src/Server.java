import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        System.out.println("listening at port 1234...");
//        create server port and block until a connection arrives
        ServerSocket server = new ServerSocket(1234);
        Socket socket = server.accept();
        String msg = "";

//        get input stream from the server socket endpoint
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
        }

    }
}
