package CHANGYONG_CLASS;

import org.junit.Test;

/**
 * 关于Stringbuffer和Stringbuilder的使用(和String的区别)
 * String:不可变的字符序列；底层使用char[]数组
 * StringBuffer:可变的字符序列；线程安全，效率低；底层使用char[]数组
 * StringBuilder:可变的字符序列；线程不安全，效率高；底层使用char[]数组
 *
 *
 * StringBuffer的常用方法：
 StringBuffer append(xxx)：提供了很多的append()方法，用于进行字符串拼接
 StringBuffer delete(int start,int end)：删除指定位置的内容
 StringBuffer replace(int start, int end, String str)：把[start,end)位置替换为str
 StringBuffer insert(int offset, xxx)：在指定位置插入xxx
 StringBuffer reverse() ：把当前字符序列逆转
 public int indexOf(String str)
 public String substring(int start,int end)
 public int length()
 public char charAt(int n )
 public void setCharAt(int n ,char ch)


 *
 * @author pls
 * @create 2020-11-02 13:53
 */
public class StringBuffer_Builder {

    @Test
    public void test1(){
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0,'m');
        System.out.println(sb1);
        System.out.println(sb1.length());
        sb1.append(345);
        System.out.println(sb1);
        sb1.delete(2,3);
        System.out.println(sb1);
    }
}
