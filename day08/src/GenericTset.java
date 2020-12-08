import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型的使用
 * 1、JDK5.0新增
 * 2、在集合中使用泛型：
 * ①集合接口或集合类在jdk5.0时都修改为带泛型的结构；
 * ②在实例化集合时，可以指明具体的泛型类型；
 * ③指明完以后，在集合类或接口中，凡是定义类或接口时，内部结构使用到类的泛型位置，都指定为实例化的泛型类型；
 *      比如：add（E e）--->实例化以后：add（Integer e）
 * ④注意点：泛型的类型必须是类，不能是基本数据类型；
 * ⑤如果实例化时，没有指明泛型的类型，默认类型为Object类型
 * 3、自定义泛型结构：泛型类、泛型接口、泛型方法
 *                  <E>、<T>
 * 4、泛型在继承方面的体现：
 * 虽然类A是类B的父类，但是G<A>和G<B>二者不具备子父类关系，二者是并列关系。
 * 补充：类A是类B的父类或接口，A<G>是B<G>的父类。
 *
 * 5、通配符的使用
 *  通配符：?
 *  类A是类B的父类，G<A>和G<B>两者没有关系，二者的共同父类是G<?>.
 *  G<?>不能向其内部添加数据。允许读取数据，读取数据的类型为Object.
 *
 * @author pls
 * @create 2020-11-07 15:02
 */
public class GenericTset {

    @Test
    public void test2() {
        List<?> list1 = null;
        List<String> list2 = null;

        List<?> list = null;
        list = list1;
        list = list2;

    }

    @Test
    public void test1() {
        ArrayList list = new ArrayList();
        list.add(78);
        list.add(88);
        list.add(80);
//        list.add("Tom");//问题一：类型不安全

        for (Object obj : list) {
            int stuScore = (int) obj;//问题二：类型转换异常：ClassCastException
            System.out.println(stuScore);
        }
    }
}
