import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class CookieClientHandler implements Runnable{
    private int threadNumber;
    private Socket socket;
    private String cookieFileName;
    private String msg;
    private ServerSocket server;
    private int portNumber;


    public CookieClientHandler(int threadNumber, ServerSocket server,String cookieFileName,int portNumber) {
        this.threadNumber = threadNumber;
        this.server = server;
        this.cookieFileName = cookieFileName;
        this.portNumber = portNumber;
    }

    @Override
    public void run() {

        System.out.println("Server" + threadNumber + " open");


        Socket socket = null;
        try {
            socket = server.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }

        InputStream is = null;
        try {
            is = socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedInputStream bis = new BufferedInputStream(is);
        DataInputStream dis = new DataInputStream(bis);

        try {
            msg = dis.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Client Message: " + msg);

        if (msg.equals("get-cookie")) {

            OutputStream os = null;
            try {
                os = socket.getOutputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }

            BufferedOutputStream bos = new BufferedOutputStream(os);
            DataOutputStream dos = new DataOutputStream(bos);

            Cookie cookie = new Cookie();

            try {
                msg = cookie.getCookieMsg(cookieFileName);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                dos.writeUTF("Thread "+threadNumber+": "+msg);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                dos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                socket.close();
                System.out.println("Server" + (threadNumber) +" closed");
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
