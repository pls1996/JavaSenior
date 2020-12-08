package exer1;


import java.io.*;

/**
 * 自定义类序列化要求：
 * 1、实现serializable接口
 * 2、提供当前类的一个全局常量：serialVersionUID
 * 3、当前类的所有属性都必须是可序列化的（默认情况下，基本数据类型可序列化）
 *
 * @author pls
 * @create 2020-11-09 16:21
 */
public class exer3 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //序列化：使用Object OutputStream
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("day09\\Object.dat"));
        oos.writeObject(new String("我爱北京"));
        oos.flush();

        oos.writeObject(new Person("Tom",22));
        oos.flush();

        oos.close();

        //反序列化：使用ObjectInputStream
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("day09\\Object.dat"));
        Object obj = ois.readObject();
        String s = (String) obj;

        Object o = ois.readObject();
        Person p = (Person)o;
        System.out.println(s);
        System.out.println(p);

        ois.close();

    }
}

class Person implements Serializable{

    public static final long serialVersionUID = 7823748273984L;

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
}
