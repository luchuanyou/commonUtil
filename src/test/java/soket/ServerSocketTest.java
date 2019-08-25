package soket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description:
 * @Author: lucy
 * @date: 2019/04/23
 */
public class ServerSocketTest {
    public static void main(String[] args) {
        boolean stopFlag = false;
        while (!stopFlag) {
            try {
                System.out.println("77777777777");
                ServerSocket cmdServer = new ServerSocket(61235, 5);
                Socket sock = cmdServer.accept();
                InputStream in = sock.getInputStream();
                byte[] msg = new byte[512];
                if (in != null) {
                    in.read(msg);
                    String command = (new String(msg)).trim();
                    if (command.equalsIgnoreCase("stop")) {
                        stopFlag = true;
                        in.close();
                    } else if (command.equalsIgnoreCase("config")) {
                        try {
                            System.out.println("======config=======");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        in.close();
                    } else if (command.equalsIgnoreCase("status")) {
                        System.out.println("show server status.");
                        in.close();
                    } else {
                        System.out.println("unknown command!");
                        in.close();
                    }
                }
                sock.close();
            } catch (IOException e) {
                System.out.println("[E]LocalServer exception :" + e.getMessage());
            }
        }
    }
}
