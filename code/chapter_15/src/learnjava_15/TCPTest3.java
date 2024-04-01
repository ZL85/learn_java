package learnjava_15;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPTest3 {
    //客户端发送内容给服务端，服务端将内容保存到本地
    //客户端
    @Test
    public void test1() {
        //1.创建Socket对象，指明服务器端的IP和端口号
        InetAddress address = null;
        try {
            address = InetAddress.getByName("172.19.12.214");
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        int port = 8989;
        Socket socket = null;
        File file = new File("Wukong.png");
        FileInputStream fis = null;
        OutputStream os = null;
        try {
            socket = new Socket(address, port);
            fis = new FileInputStream(file);
            byte[] buffer1 = new byte[1024];
            int len1;
            while ((len1 = fis.read(buffer1)) != -1) {
                //2.获取一个输出流，用于输出数据
                os = socket.getOutputStream();
                //3.写出数据的操作
                os.write(buffer1, 0, len1);
            }
            System.out.println("文件传输完成");

            //客户端表明不再发送数据
            socket.shutdownOutput();

            //4.接收服务端的反馈
            InputStream is = socket.getInputStream();
            byte[] buffer2 = new byte[1024];
            int len2;
            //避免出现乱码
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while ((len2 = is.read(buffer2)) != -1) {
                baos.write(buffer2, 0, len2);
            }
            System.out.println(baos.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //5.资源关闭
        try {
            os.close();
            fis.close();
            socket.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //服务端
    @Test
    public void test2() {
        //1.创建ServerSocket对象，绑定监听的端口
        int port = 8989;
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        OutputStream os = null;
        try {
            ss = new ServerSocket(port);
            //2.调用accept()方法接收客户端的Socket对象
            socket = ss.accept();
            System.out.println("服务端已开启，等待客户端连接...");
            is = socket.getInputStream();

            //3.获取一个输入流，用于输入数据
            File file = new File("Wukong_copy_1.png");
            os = new java.io.FileOutputStream(file);

            //4.读取数据的操作
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }

            System.out.println("文件传输完成");

            //5.发送数据给客户端
            os = socket.getOutputStream();
            os.write("已收到你的图片".getBytes());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //6.资源关闭
        try {
            os.close();
            is.close();
            socket.close();
            ss.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
