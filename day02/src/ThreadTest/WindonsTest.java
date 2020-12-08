package ThreadTest;
/**
 * 例子：创建三个窗口卖票，总票数为100张，使用Runnable接口的方式实现（存在重票／错票的安全问题）
 *
 *  解决：当一个线程在操作ticket的时候，其他线程不能参与进来，直到线程ａ操作完之后，其他线程才可以造作ticket。
 *         这种情况及时线程ａ出现阻塞，也不能被改变。
 *  在Java中，我们通过同步机制，来解决线程的安全问题：
 *  方式一：同步代码块
 *   synchronized(同步监视器){
 *       //需要被同步的代码
 *   }
 *  说明：1、操作共享数据的代码，即为需要被同步的代码
 *       2、同步监视器，俗称：锁。任何一个类的对象，都可以充当锁。
 *              要求：多个线程必须要共用同一把锁！！
 *
 *  方式二：同步方法
 *  如果操作共享数据的代码完整的声明在一个方法中，我们不妨将此方法声明为同步的；
 *  1、同步方法仍然涉及到同步监视器，只是不需要显式的声明
 *  2、非静态的同步方法，同步监视器是：this；
 *     静态的同步方法，同步监视器是：当前类本身；
 *
 *  同步的方式，解决了线程的安全问题    --->好处
 *  但是，操作同步代码时，只有一个线程参与，其他线程等待，相当于是单线程的过程，效率低   --->坏处
 *
 * @author pls
 * @create 2020-10-30 15:12
 */
class Window implements Runnable {

    private int ticket = 100;
//    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
//            synchronized (obj) {
            synchronized (this) {   //当前类的对象，相当于w对象
                if (ticket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName()+":卖票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

public class WindonsTest {
    public static void main(String[] args) {
        Window w = new Window();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        t1.setName("窗口一：");
        t2.setName("窗口二：");
        t3.setName("窗口三：");
        t1.start();
        t2.start();
        t3.start();
    }

}
