import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *  网络编程
 *  0、通信要素一：IP、端口号
 *     通信要素二：网络通信协议
 *
 *  1、IP：唯一的标识Internet上的计算机
 *  2、在Java中使用InetAddress类代表IP
 *  3、IP分类：IPv4、IPv6；万维网、局域网
 *  4、本地回路地址：127.0.0.1  对应着：localhost
 *
 *  5、InetAddress实例化的两个方法：getByName(String host)、getLocalHost（）
 *  6、两个常用方法：getHostName（）、getHostAddress（）
 *
 *  7、端口号：正在计算机上运行的进程
 *        要求：不同的进程有不同的端口号
 *        范围：被规定为一个16位的整数：0~65535
 *  8、端口号和IP地址的组合得出一个网络套接字：Scoket
 *
 *
 *
 * @author pls
 * @create 2020-11-09 19:56
 */
public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getByName("www.baidu.com");
        String s = address.getHostName();
        String s1 = address.getHostAddress();
        System.out.println(s);
        System.out.println(s1);

    }
}
