package ThreadTest;

/**
 * 多线程的创建： 方式二:实现Runnable接口
 * 1、创建一个实现了Runnable接口的类
 * 2、实现类去实现Runable中的抽象方法：run()
 * 3、创建实现类的对象
 * 4、将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
 * 5、通过Thread类的对象，调用start()
 *
 * 比较创建线程的两种方式：
 * 开发中，优先选择：实现Runnable接口的方式
 * 原因：1、实现的方式没有类的单继承性的局限性
 *      2、实现的方式更适合来处理多个线程有共享数据的情况
 *
 * @author pls
 * @create 2020-10-29 19:17
 */
class MYThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}

public class ThreadTest1 {
    public static void main(String[] args) {
        MYThread m = new MYThread();
        Thread t = new Thread(m);
        t.start();
    }

}
