import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * File类的使用
 *
 * 1、File类的一个对象，代表一个文件或一个文件目录（俗称：文件夹）
 * 2、File类声明在java.io包下
 * 3、相对路径：相较于某个路径下，指明的路径
 *    绝对路径：包含盘符在内的文件或文件目录的路径
 * 4、路径分隔符：
 *      Windows：\\
 *      unix：/
 *
 *
 * @author pls
 * @create 2020-11-08 13:36
 */
public class FileTest {

    @Test
    public void test3() throws IOException {
        File file =  new File("hello.txt");
        if(!file.exists()){
            file.createNewFile();//创建文件
            System.out.println("创建成功");
        }else{
            file.delete();
            System.out.println("删除成功");
        }

    }

    @Test
    public void test2(){
        File file1 = new File("hello.txt");
        File file2 = new File("D:\\workspace_ideal\\JavaSenior\\day09\\hi.txt");
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(file1.lastModified());
        System.out.println(new Date(file1.lastModified()));

    }

    @Test
    public void test1(){
        //构造器1
        File file1 = new File("hello.txt");//相对于当前module的相对路径
        File file2 = new File("D:\\workspace_ideal\\JavaSenior\\day09\\he.txt");//绝对路径
        System.out.println(file1);
        System.out.println(file2);
        //构造器2
        File file3 = new File("D:\\workspace_ideal","JavaSenior");
        System.out.println(file3);
        //构造器3
        File file4 = new File(file3,"hi.txt");
        System.out.println(file4);

    }
}
