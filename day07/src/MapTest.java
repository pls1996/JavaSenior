import org.junit.Test;

import java.util.*;

/**
 * |---Map接口：双列集合，用来存储一对（key-value）一对的数据   ---> y=f(x)
 *          |---HashMap：作为Map的主要实现类；线程不安全，效率高；可以存储null的key和value
 *              |---LinkedHashMap:保证在遍历map元素时，可以按照添加的顺序实现遍历。
 *                                原因：在原有的HashMap底层结构基础上，添加了一对指针，指向前一个和后一个元素
 *                                对于频繁的遍历操作，此类执行效率高于HashMap。
 *          |---TreeMap：保证按照添加的key-value对进行排序，实现排序遍历。此时使用key的自然排序或定制排序。
 *                       底层使用红黑树
 *          |---Hashtable：作为古老的实现类；线程安全，效率低；不可以存储null的key和value
 *              |---Properties：常用来处理配置文件。key和value都是String类型。
 *
 *  1、HashMap的底层：数组+链表（JDK7之前）
 *                数组+链表+红黑树（JDK8）
 *  2、Map结构的理解；
 *      Map中的key：无序的、不可重复的，使用Set存储所有的key    --->key所在的类要重写equals()和hashcode()方法。（以HashMap为例）
 *      Map中的value：无序的、可重复的，使用Collection存储所有的value  --->value所在的类要重写equals()方法
 *      一个键值对：key-value构成了一个Entry对象（无序的、不可重复的，使用Set存储）
 *
 *  面试题：HashMap的底层实现原理？（以JDK8为例）
 *  1、HashMap map = new HashMap();此时底层没有创建一个长度为16的数组；
 *  2、数组结构是Node[],而非Entry[]；
 *  3、首次调用put()方法时，底层才创建长度为16的数组；
 *  4、JDK8中底层结构为数组+链表+红黑树；
 *      当数组的某一个索引位置山的元素以链表形式存在的数据个数＞8且当前数组的长度＞64时，
 *      此时此索引位置上的所有数据改为使用红黑树存储；（可以加快查找的效率）
 *  5、如果此位置上的数据为空时，此时的key1-value1添加成功；
 *     如果此位置上的数据不为空，则比较key1和当前数据key的哈希值：
 *          如果key1的哈希值和已经存在的数据的哈希值不相同，此时key1-value1添加成功；
 *          如果key1的哈希值和已经存在的某一个数据的哈希值相同，则调用key1所在类的equals()方法继续比较：
 *                 如果equals()返回false，此时key1-value1添加成功；
 *                 如果equals()返回true，使用value1替换当前数据的value值。
 *
 *
 * @author pls
 * @create 2020-11-06 13:16
 */
public class MapTest {

    @Test
    public void test2(){
        Map map = new HashMap();
        map.put("AA",123);
        map.put("CC",456);
        map.put("GG",789);

        //遍历key
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //遍历value
        Collection values = map.values();
        for(Object obj:values){
            System.out.println(obj);
        }
        //遍历key-value
        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()){
//            System.out.println(iterator1.next());//方式一
            Object o = iterator1.next();//方式二
            Map.Entry entry = (Map.Entry)o;
            System.out.println(entry.getKey()+"="+entry.getValue());

        }
    }

    @Test
    public void test1(){
        Map map = new HashMap();
        map.put("AA",123);
        map.put("CC",456);
        map.put("GG",789);
        map.put("AA",333);//修改
        System.out.println(map);
        map.remove("CC");
        System.out.println(map);
        System.out.println(map.size());

        Object cc = map.get("CC");
        System.out.println(cc);
        boolean aa = map.containsKey("AA");
        System.out.println(aa);
        boolean b = map.containsValue(123);
        System.out.println(b);

        map.clear();
        System.out.println(map.isEmpty());

    }
}
