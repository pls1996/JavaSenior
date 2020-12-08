package Single;

/**
 * 单例模式：懒汉式线程安全优化
 *
 * @author pls
 * @create 2020-10-30 17:02
 */
public class Single {
    public static void main(String[] args) {
        Bank b1 = Bank.getInstance1();
        Bank b2 = Bank.getInstance1();
        System.out.println(b1 == b2);
        System.out.println(b1.getClass());
    }
}

class Bank {
    private static Bank instance1 = null;

    private Bank() {
    }

    public static Bank getInstance1() {
        if (instance1 == null) {
            synchronized (Bank.class) {
                if (instance1 == null) {
                    instance1 = new Bank();
                }
            }
        }
        return instance1;
    }
}