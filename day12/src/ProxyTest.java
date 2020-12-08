import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理举例
 *
 * @author pls
 * @create 2020-11-11 15:29
 */
interface Human {

    String getBelief();

    void eat(String food);

}

//被代理类
class SuperMan implements Human {

    @Override
    public String getBelief() {
        return "I believe I can fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃：" + food);
    }
}

class ProxyFactory {

    //根据传入的被代理类的对象obj，返回一个代理类的对象
    public static Object getProxyInstance(Object obj) {
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
}

class MyInvocationHandler implements InvocationHandler {
    private Object obj;

    public void bind(Object obj) {
        this.obj = obj;
    }

    //当我们通过代理类的对象，调用method时，就会自动调用invoke()
    //被代理类要执行的method的功能，就声明在invoke()中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object returnValue = method.invoke(obj, args);
        return returnValue;
    }
}

public class ProxyTest {
    public static void main(String[] args) {
        Object proxyInstance = ProxyFactory.getProxyInstance(new SuperMan());
        Human h = (Human) proxyInstance;
        String belief = h.getBelief();
        System.out.println(belief);
        h.eat("麻辣烫");

    }
}
