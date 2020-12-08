package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建线程的方式四：使用线程池
 *
 *  好处：1、提高响应速度（减少了创建新线程的时间）
 *          2、降低资源消耗（重复利用线程池里的线程）
 *          3、便于线程的管理
 *
 * @author pls
 * @create 2020-10-31 16:35
 */
class myThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+i);
            }
        }
    }
}


public class ThreadPool {
    public static void main(String[] args) {
        //1、提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        //2、执行指定的线程操作。需要提供实现Runnable接口或Callable接口的实现类的对象
        service.execute(new myThread());//适合适用于Runnable
//        service.submit(Callable callable);//适合适用于Callable

        //3、关闭连接池
        service.shutdown();


    }
}
