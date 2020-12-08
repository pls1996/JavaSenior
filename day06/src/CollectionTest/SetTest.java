package CollectionTest;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;

/**
 *  |---Collection接口：单列集合，用来存储一个一个的对象
 *      |---Set接口：存储无序、不可重复的数据。 --->可以用于过滤重复数据
 *          |---HashSet：作为Set接口的主要实现类；线程不安全；可以存储null值
 *              |---LinkedHashSet：作为HashSet的子类；遍历其内部数据时，可以按照添加的顺序遍历;
 *                                 对于频繁的遍历操作，效率高于HashSet
 *          |---TreeSet：可以按照添加对象的指定属性，进行排序
 *
 *  1、Set：存储无序、不可重复的数据     (没有额外新增的方法，使用的都是Collection中声明的方法)
 *      以HashSet为例说明：
 *      1、1、无序性：不等于随机性。存储的数据在底层数组中并非按照数组索引的顺序添加，而是根据数据的哈希值决定的
 *      1、2、不可重复性：保证添加的元素按照equals()判断时，不能返回true，即：相同的元素只能添加一个
 *
 *  2、添加元素过程：
 *      我们向HashSet中添加元素a时，首先调用元素a所在类的hashcode()方法，计算出元素a的哈希值，此哈希值接着通过某种
 *      算法，计算出在HashSet底层数组中的存放位置（即为索引位置 ），判断数组此位置上是否已经有元素：
     *      如果此位置没有其他元素，则元素a添加成功；
     *      如果此位置有其他元素b（或以链表形式存在的多个元素），则比较元素a与元素b的哈希值：
     *          如果哈希值不相同，则元素a添加成功；
     *          如果哈希值相同，进而需要调用元素a所在类的equals()方法：
     *              equals()返回true，则元素a添加失败；
     *              equals()返回false，则元素a添加成功。
 *
 * @author pls
 * @create 2020-11-05 15:00
 */
public class SetTest {

    @Test
    public void test1(){
        HashSet hashSet = new HashSet();
        hashSet.add(555);
        hashSet.add(123);
        hashSet.add(123);
        hashSet.add(456);
        hashSet.add("AA");
        hashSet.add(new Person("Tom",12));
        hashSet.add(new Person("Tom",12));

        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());//输出只有一个123
        }

    }
}

class Person implements Comparable{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    //按照姓名从小到大排列
    @Override
    public int compareTo(Object o) {
        if(o instanceof Person){
            Person p = (Person)o;
            return this.name.compareTo(p.name);
        }else{
            throw new RuntimeException("输入的类型不匹配");
        }
    }
}