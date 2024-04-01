package learnjava_15;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {
    @Test
    public void test1() {
        //URL网络编程
        //1.创建URL的对象
        URL url = null;
        try {
            url = new URL("http://localhost:8080/examples/beauty.jpg?username=Tom");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        //常用方法
        //public String getProtocol() 获取该URL的协议名
        System.out.println("getProtocol: " + url.getProtocol());
        //public String getHost() 获取该URL的主机名
        System.out.println("getHost: " + url.getHost());
        //public String getPort() 获取该URL的端口号
        System.out.println("getPort: " + url.getPort());
        //public String getPath() 获取该URL的文件路径
        System.out.println("getPath: " + url.getPath());
        //public String getFile() 获取该URL的文件名
        System.out.println("getFile: " + url.getFile());
        //public String getQuery() 获取该URL的查询名
        System.out.println("getQuery: " + url.getQuery());
        //public String getRef() 获取该URL在文件中的相对位置
        System.out.println("getRef: " + url.getRef());
        //public String getAuthority() 获取该URL的权限部分
        System.out.println("getAuthority: " + url.getAuthority());
        //public String getUserInfo() 获取该URL的用户信息
        System.out.println("getUserInfo: " + url.getUserInfo());
        //public String toExternalForm() 返回该URL的字符串形式
        System.out.println("toExternalForm: " + url.toExternalForm());
        //public String toString() 返回该URL的字符串形式
        System.out.println("toString: " + url.toString());
    }

    //下载url代表的资源到本地
    @Test
    public void test2() {
        URL url = null;
        try {
            //可能会报连接错误
            url = new URL("https://whvn.cc/6o7m8q");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        InputStream is = null;
        FileOutputStream fos = null;
        HttpURLConnection urlConnection = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            is = urlConnection.getInputStream();
            File file = new File("Wukong_red.png");
            fos = new FileOutputStream(file);
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            System.out.println("下载完成");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //关闭资源
        try {
            if (fos != null) {
                fos.close();
            }
            if (is != null) {
                is.close();
            }
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
