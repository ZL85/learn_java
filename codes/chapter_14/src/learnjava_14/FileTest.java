package learnjava_14;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FilenameFilter;

public class FileTest {
    //构造器的使用
    @Test
    public void test1() {
        //File(String pathname)
        File file1 = new File("hello.txt");
        File file2 = new File("D:\\Desktop\\zongliang\\learn_java\\code\\chapter_14\\src\\learnjava_14\\hello.txt");

        System.out.println(file1.getAbsoluteFile());
        System.out.println(file2.getAbsoluteFile());

        //File(String parent, String child)
        //第一个参数是父目录
        //第二个参数是子目录或文件
        File file3 = new File("D:\\Desktop\\zongliang\\learn_java\\code\\chapter_14\\src\\learnjava_14", "hello");
        File file4 = new File("D:\\Desktop\\zongliang\\learn_java\\code\\chapter_14\\src\\learnjava_14", "hello.txt");

        //File(File parent, String child)
        //第一个参数是父目录
        //第二个参数是子目录或文件
        File file5 = new File(file3, "hello.txt");
    }

    //常用方法
    @Test
    public void test2() {
        File file1 = new File("hello.txt");
        System.out.println(file1.getName());
        System.out.println(file1.getPath());
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getAbsoluteFile());
        System.out.println(file1.getAbsoluteFile().getParent());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(file1.lastModified());

        System.out.println("-".repeat(100));

        File file2 = new File("D:\\Desktop\\zongliang\\learn_java\\code\\chapter_14\\hello.txt");
        System.out.println(file2.getName());
        System.out.println(file2.getPath());
        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getAbsoluteFile());
        System.out.println(file2.getAbsoluteFile().getParent());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(file2.lastModified());

        System.out.println("-".repeat(100));

        File file3 = new File("D:\\Desktop\\zongliang\\learn_java\\code\\chapter_14");
        String[] f_arr = file3.list();
        for (String s : f_arr) {
            System.out.println(s);
        }
        File[] f_arr2 = file3.listFiles();
        assert f_arr2 != null;
        for (File f : f_arr2) {
            System.out.println(f);
//            System.out.println(f.getName());
        }

        System.out.println("-".repeat(100));

        //要求file1存在，file2不存在，且file2所在的目录存在
        File file4 = new File("D:\\Desktop\\zongliang\\learn_java\\code\\chapter_14\\hello1.txt");
        File file5 = new File("D:\\Desktop\\zongliang\\learn_java\\code\\chapter_14\\hello2.txt");

        boolean renameTo = file4.renameTo(file5);
        System.out.println(renameTo ? "success" : "fail");

        System.out.println("-".repeat(100));

        File file6 = new File("D:\\Desktop\\zongliang\\learn_java\\code\\chapter_14\\hello2.txt");
        System.out.println(file6.exists());
        System.out.println(file6.isDirectory());
        System.out.println(file6.isFile());
        System.out.println(file6.canRead());
        System.out.println(file6.canWrite());
        System.out.println(file6.isHidden());

        System.out.println("-".repeat(100));

        File file7 = new File("D:\\Desktop\\zongliang\\learn_java\\code\\chapter_14\\hello");
        System.out.println(file7.exists());
        System.out.println(file7.isDirectory());
        System.out.println(file7.isFile());
        System.out.println(file7.canRead());
        System.out.println(file7.canWrite());
        System.out.println(file7.isHidden());

        System.out.println("-".repeat(100));

        File file8 = new File("D:\\Desktop\\zongliang\\learn_java\\code\\chapter_14\\hello1.txt");
        if (!file8.exists()) {
            try {
                boolean newFile = file8.createNewFile();
                System.out.println(newFile ? "success" : "fail");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            file8.delete();
            System.out.println("delete success");
        }

        System.out.println("-".repeat(100));

        File file9 = new File("D:\\Desktop\\zongliang\\learn_java\\code\\chapter_14\\hello1");
        System.out.println(file9.mkdir());

        File file10 = new File("D:\\Desktop\\zongliang\\learn_java\\code\\chapter_14\\hello2");
        System.out.println(file10.mkdirs());

        File file11 = new File("D:\\Desktop\\zongliang\\learn_java\\code\\chapter_14\\hello3\\hello3_1");
        System.out.println(file11.mkdirs());
    }

    @Test
    public void test3() {
        //判断指定目录下是否有后缀名为.png的文件，如果有，输出改文件名
        File file = new File("D:\\Desktop\\zongliang\\learn_java\\code\\chapter_14");
        String[] list1 = file.list();
        assert list1 != null;
        for (String s : list1) {
            if (s.endsWith(".png")) {
                System.out.println(s);
            }
        }

        String[] list2 = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".png");
            }
        });

        for (String s : list2) {
            System.out.println(s);
        }
    }
}
