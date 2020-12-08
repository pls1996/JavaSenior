package ThreadTest;

/**
 * 例子：创建三个窗口卖票，总票数为100张，使用Runnable接口的方式实现（存在重票／错票的安全问题）
 * <p>
 * <p>
 * 方式二：同步方法
 * 如果操作共享数据的代码完整的声明在一个方法中，我们不妨将此方法声明为同步的；
 * 1、同步方法仍然涉及到同步监视器，只是不需要显式的声明
 * 2、非静态的同步方法，同步监视器是：this；
 *    静态的同步方法，同步监视器是：当前类本身；
 *
 * 同步的方式，解决了线程的安全问题    --->好处
 * 但是，操作同步代码时，只有一个线程参与，其他线程等待，相当于是单线程的过程，效率低   --->坏处
 *
 * @author pls
 * @create 2020-10-30 15:12
 */
class Window1 implements Runnable {

    private int ticket = 100;
    private boolean isFlag = true;

    @Override
    public void run() {
        while (isFlag) {
            show();
        }
    }

    private synchronized void show() {
        if (ticket > 0) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
            ticket--;
        }else{
            isFlag = false;
        }
    }
}

public class WindonsTest1 {
    public static void main(String[] args) {
        Window1 w = new Window1();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        t1.setName("窗口1：");
        t2.setName("窗口2：");
        t3.setName("窗口3：");
        t1.start();
        t2.start();
        t3.start();
    }

}
