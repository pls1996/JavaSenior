import org.junit.Test;

import java.util.*;

/**
 * 一、集合
 * 1、集合、数组都是对多个数据进行存储操作的结构，简称Java容器。
 * 说明：此时的存储，主要指的是内存层面的存储，不涉及到持久化的存储
 * 2、数组在存储多个数据方面的特点：
 * > 一旦初始化后，其长度就确定了，不可进行修改
 * > 数字一旦定义好，其元素的类型也就确定了，我们只能操作指定类型的数据了
 * <p>
 * 二、集合框架
 * |---Collection接口：单列集合，用来存储一个一个的对象
 *      |---List接口：存储有序、可重复的数据。 ---> “动态”数组
 *          |---ArrayList、LinkedList、Vector
 *      |---Set接口：存储无序、不可重复的数据。 --->可以用于过滤重复数据
 *          |---HashSet、LinkedHashSet、TreeSet
 * |---Map接口：双列集合，用来存储一对（key-value）一对的数据   ---> y=f(x)
 *          |---HashMap、LinkedHashMap、TreeMap、Hashtable、Properties
 * <p>
 * 三、Collection接口中的方法
 *  增、删、改、查、插、长度、遍历
 *
 * @author pls
 * @create 2020-11-04 15:03
 */
public class CollectionTest {

    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add("AA");
        coll.add("bb");
        coll.add(123);
        coll.add(new Date());
        System.out.println(coll.size());
        Collection coll1 = new ArrayList();
        coll1.add("cc");
        coll1.add(456);
        coll.addAll(coll1);
        System.out.println(coll.size());
        System.out.println(coll);
//        coll.clear();
        System.out.println(coll.isEmpty());
        System.out.println("*********************");
        System.out.println(coll.contains(456));
        System.out.println(coll.containsAll(coll1));
        System.out.println(coll.remove(1234));//boolean
        System.out.println("*********************");
        System.out.println(coll.hashCode());//返回当前对象的hash值

        //集合-->Array
        Object[] array = coll.toArray();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        //Array-->集合
        List<Object> list = Arrays.asList(array);
        System.out.println(list);
    }
}
