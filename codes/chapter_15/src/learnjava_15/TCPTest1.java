package learnjava_15;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPTest1 {
    //客户端发送内容给服务端，服务端将内容打印到控制台上
    @Test
    public void test1() {
        //客户端
        //1.创建Socket对象，指明服务器端的IP和端口号
        InetAddress address = null;
        try {
            address = InetAddress.getByName("172.19.12.214");//声明服务端IP
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        int port = 8989;//声明服务端端口号
        Socket socket = null;
        OutputStream os = null;
        try {
            socket = new Socket(address, port);

            //2.获取一个输出流，用于输出数据
            //3.写出数据的操作
            os = socket.getOutputStream();
            os.write("你好，我是客户端".getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //4.资源关闭
        try {
            os.close();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Test
    public void test2() {
        //服务端
        //1.创建ServerSocket对象，绑定监听的端口
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        try {
            int port = 8989;//声明端口号
            ss = new ServerSocket(port);

            //2.调用accept()方法接收客户端的Socket对象
            socket = ss.accept();//阻塞式方法
            System.out.println("服务端已开启，等待客户端连接...");

            //3.获取一个输入流，用于输入数据
            //4.读取数据的操作
            is = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int len;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            System.out.println(baos.toString());
            System.out.println("收到了来自于" + socket.getInetAddress().getHostAddress() + "的数据");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //5.资源关闭
        try {
            is.close();
            socket.close();
            ss.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
