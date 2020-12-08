package Reflect;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 *  java.lang.Class类
 *  1、Class的实例就对应着加载到内存中的一个运行时类
 *  2、获取Class的实例的方式     --->test1
 *  3、创建运行时类的对象：newinstance()   --->test1
 *  4、调用运行时类的指定结构：属性、   方法、     构造器     --->test3
 *                       set\get()、invoke()、newinstance()
 *
 * @author pls
 * @create 2020-11-10 15:12
 */
public class ReflectionTest {

    @Test
    public void test3() throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<Person> clazz = Person.class;
        Person p = clazz.newInstance();
        //1、获取指定的属性,getDeclaredField()可以获取所有权限的属性，开发中常用此方法
        Field id = clazz.getDeclaredField("id");
        //2、setAccessible()设置访问权限，保证当前属性是可访问的
        id.setAccessible(true);
        //3、设置当前属性的值
        id.set(p,1001);
        //4、获取当前属性的值
        int pid = (int) id.get(p);
        System.out.println(pid);

    }

    @Test
    public void test2() throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<Person> clazz = Person.class;
        Person p = clazz.newInstance();
        //1、获取指定的属性，getField()只能获取public的，故开发中不常用此方法
        Field name = clazz.getField("name");
        //2、设置当前属性的值
        name.set(p,"Tom");
        //3、获取当前属性的值
        String pname = (String) name.get(p);
        System.out.println(pname);
    }


    @Test
    public void test1() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //获取Class的实例的方式
        //方式1：调用运行时类的属性：.class
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);
        //创建运行时类的对象
        //调用newinstance()方法，创建对应的运行时类的对象
        //要求：运行时类必须提供空参构造器；空参构造器的访问权限足够，通常设置为public
        Person person = clazz1.newInstance();


        //方式2：通过运行时类的对象，调用getClass()
        Person p1 = new Person();
        Class<? extends Person> clazz2 = p1.getClass();
        System.out.println(clazz2);

        //方式3：调用Class的静态方法：forName(String classPath)    --->开发中最常用，体现反射的动态性
        Class<?> clazz3 = Class.forName("Reflect.Person");
        System.out.println(clazz3);

        //方式4：使用类的加载器：ClassLoader   --->了解
        ClassLoader clazz4 = ReflectionTest.class.getClassLoader();
        System.out.println(clazz4);
    }
}

class Person{
    public String name;
    public int age;
    private int id;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}