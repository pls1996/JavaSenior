package CHANGYONG_CLASS;

import org.junit.Test;

/**
 * @author pls
 * @create 2020-11-01 14:52
 */
public class StringTest {

    @Test
    public void test1() {
        String s1 = "abc";//字面量方式声明:声明在方法区的字符串常量池中,s1指向常量池中的abc的首地址值
        String s2 = "abc";
        String s3 = new String("abc");//new+构造器方式:声明在堆空间中，s3指向堆空间中value的地址值，value再指向常量池中abc的地址值
        String s4 = new String("abc");

        System.out.println(s1 == s2);//true
        System.out.println(s1 == s3);//false
        System.out.println(s3 == s4);//false
    }


}
