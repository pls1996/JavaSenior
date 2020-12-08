package ThreadTest;

/**
 * 多线程的创建：  方式一
 * 1、创建一个继承于Thread的子类
 * 2、重写子类中的父类run（）
 * 3、创建子类的对象
 * 4、通过此对象调用start（）
 *
 * @author pls
 * @create 2020-10-29 17:23
 */
public class ThreadTest {
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();

        Thread.currentThread().setName("主线程:");
        t1.setName("线程一:");
        t2.setName("线程二:");
        t1.start();
        t2.start();
        System.out.println(Thread.currentThread().getName()+"hello");
    }
}

class Thread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println("100以内的偶数:" + i + "\t" + Thread.currentThread().getName());
            }
        }
    }
}

class Thread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println("100以内的奇数:" + i + "\t" + Thread.currentThread().getName());
            }
        }
    }
}