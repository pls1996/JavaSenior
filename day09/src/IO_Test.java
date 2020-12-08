import org.junit.Test;

import java.io.*;

/**
 * 一、流的分类
 * 1、操作数据单位：字节流、字符流
 * 2、数据的流向：输入流、输出流
 * 3、流的角色：节点流、处理流
 * 二、流的体系结构
 *  抽象基类              节点流（或文件流）     缓冲流（处理流的一种）     转换流（处理流的一种）
 *  InputStream(字节)     FileInputStream      BufferedInputStream
 *  OutputStream(字节)    FileOutputStream     BufferedOutputStream
 *  Reader(字符)          FileReader           BufferedReader         InputStreamReader
 *  Writer(字符)          FileWriter           BufferedWriter         OutputStreamWriter
 *
 * 三、读入说明
 * 1、read():返回读入的一个字符，如果达到文件末尾，则返回-1.
 *    read(cbuf):返回每次读入cbuf数组的字符的个数，如果达到文件末尾，则返回-1.
 * 2、异常的处理：为了保证流资源一定可以执行关闭操作，需要使用try-catch-finally处理
 * 3、读入的文件一定要存在，否则就会报异常：FileNotFoundException
 *
 * 四、写出说明
 * 1、输出操作，对应的file可以不存在；
 * 2、file对应的文件如果不存在，在输出过程中，会自动创建此文件；
 *                如果存在，需要看使用的构造器：FileWrite（file，false/true），如果使用的是false，则会覆盖当前文件；
 *                如果使用的是true，则在原有文件基础上进行添加。
 *
 *
 * @author pls
 * @create 2020-11-08 16:11
 */
public class IO_Test {

    @Test
    public void test3() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            File srcfile = new File("hello.txt");
            File destfile = new File("hello2.txt");

            fr = new FileReader(srcfile);
            fw = new FileWriter(destfile);

            char[] cbuf = new char[5];
            int len;
            while((len = fr.read(cbuf)) != -1 ){
                fw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test2() {
        FileWriter fw = null;
        try {
            File file = new File("hello1.txt");
            fw = new FileWriter(file,true);
            fw.write("i have a dream!\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    @Test
    public void test1(){
        FileReader fr = null;
        try {
            File file = new File("hello.txt");
            fr = new FileReader(file);
            int d1 = fr.read();//read():返回读入的一个字符，如果达到文件末尾，则返回-1.
            while(d1 != -1){
                System.out.print((char)d1);
                d1 = fr.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fr != null){
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
