import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *    |---Hashtable：作为古老的实现类；线程安全，效率低；不可以存储null的key和value
 *              |---Properties：常用来处理配置文件。key和value都是String类型。
 *
 *
 * @author pls
 * @create 2020-11-06 16:53
 */
public class PropertiesTest {
    public static void main(String[] args) throws IOException {

        Properties pros = new Properties();
        FileInputStream fis = new FileInputStream("day07\\jdbc.properties");
        pros.load(fis);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        System.out.println(user+"--"+password);


    }
}
