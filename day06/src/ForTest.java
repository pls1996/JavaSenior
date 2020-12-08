import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 增强for循环遍历（JDK5.0新特性）
 *
 * @author pls
 * @create 2020-11-04 17:58
 */
public class ForTest {

    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));

        //for(集合元素的类型 局部变量 ：集合对象){}
        for(Object obj : coll){
            System.out.println(obj);
        }
    }
}
