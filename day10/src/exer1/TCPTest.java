package exer1;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author pls
 * @create 2020-11-09 20:32
 */
public class TCPTest {

    //客户端
    @Test
    public void client() throws IOException {
        Socket socket = new Socket("127.0.0.1",8899);
        OutputStream os = socket.getOutputStream();
        FileInputStream fis = new FileInputStream("小阿七.jpg");

        byte[] buffer = new byte[1024];
        int len;
        while((len = fis.read(buffer)) != -1){
            os.write(buffer,0,len);
        }

        fis.close();
        os.close();
        socket.close();
    }

    //服务端
    @Test
    public void server() throws IOException {
        ServerSocket ss = new ServerSocket(8899);
        Socket socket = ss.accept();
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream("copy.jpg");

        byte[] buffer = new byte[1024];
        int len;
        while((len = is.read(buffer)) != -1){
            fos.write(buffer,0,len);
        }

        fos.close();
        is.close();
        socket.close();
        ss.close();
    }
}
