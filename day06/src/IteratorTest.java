import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合元素的遍历：使用迭代器iterator接口
 *
 *
 * @author pls
 * @create 2020-11-04 17:21
 */
public class IteratorTest {

    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));

        Iterator iterator = coll.iterator();
//        System.out.println(iterator.next());//123
//        System.out.println(iterator.next());//456
//        System.out.println(iterator.next());//Tom
//        System.out.println(iterator.next());//报异常：NoSuchElementException

//        for (int i = 0; i < coll.size(); i++) {
//            System.out.println(iterator.next());
//        }

        //推荐方式
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
