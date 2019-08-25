package soket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Description:
 * @Author: lucy
 * @date: 2019/04/01
 */
public class ClientSocket {
    public static void main(String[] args) {
        try {
            System.out.println("*******这是客户端*********");
            Socket socket = new Socket("172.16.40.246", 61610);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("stop".getBytes());

            outputStream.flush();

            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String s = reader.readLine();
            System.out.println("这是服务端发过来的消息"+s);

            outputStream.close();
        } catch ( Exception e) {
            e.printStackTrace();
        }
    }
}
