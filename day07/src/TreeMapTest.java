import org.junit.Test;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * TreeMap中添加key-value，要求key必须是同一个类创建的对象
 * 按照key进行排序：自然排序、定制排序
 *
 * @author pls
 * @create 2020-11-06 16:37
 */
public class TreeMapTest {

    @Test
    public void test() {
        Comparator comparator = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Person && o2 instanceof Person) {
                    Person p1 = (Person) o1;
                    Person p2 = (Person) o2;
                    return (p1.name.compareTo(p2.name));
                } else {
                    throw new RuntimeException("类型不一致");
                }
            }
        };
        Person p1 = new Person("Tom", 22);
        Person p2 = new Person("Jack", 24);

        TreeMap map = new TreeMap();
        map.put(p1.name, p1.age);
        map.put(p2.name, p2.age);
        System.out.println(map);

    }
}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
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
}