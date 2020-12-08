package CollectionTest;

import org.junit.Test;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * |---Collection接口：单列集合，用来存储一个一个的对象
 *      |---Set接口：存储无序、不可重复的数据。 --->可以用于过滤重复数据
 *          |---HashSet：作为Set接口的主要实现类；线程不安全；可以存储null值
 *              |---LinkedHashSet：作为HashSet的子类；遍历其内部数据时，可以按照添加的顺序遍历;
 *                                 对于频繁的遍历操作，效率高于HashSet
 *          |---TreeSet：可以按照添加对象的指定属性，进行排序
 *
 * 1、TreeSet：要求添加的数据是相同类的对象且是有序的（能进行大小排序）。
 * 2、两种排序方式：自然排序（实现Comparable接口）、定制排序（new Comparator(){})
 */
public class TreeSetTest {

    @Test
    public void test2(){
        TreeSet set = new TreeSet();
        set.add(new Person("Tom",22));
        set.add(new Person("jack",20));
        set.add(new Person("Jack",26));
        set.add(new Person("Alice",22));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }


    @Test
    public void test1(){
        TreeSet set = new TreeSet();
        set.add(123);
        set.add(456);
        set.add(42);
        set.add(-3);
//        set.add(new Person("Tom",22));//不能添加不同类的对象

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

}
