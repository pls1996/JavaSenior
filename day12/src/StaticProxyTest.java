/**
 * 静态代理举例
 *
 * @author pls
 * @create 2020-11-11 15:18
 */
interface ClothFactory {

    void produceCloth();
}

//代理类
class ProxyClothFactory implements ClothFactory{
    private ClothFactory factory ;

    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂准备");
        factory.produceCloth();
        System.out.println("代理工厂收尾");
    }
}

//被代理类
class NikeClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("Nike工厂开始生产");
    }
}

public class StaticProxyTest {
    public static void main(String[] args) {
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(new NikeClothFactory());
        proxyClothFactory.produceCloth();

    }
}
