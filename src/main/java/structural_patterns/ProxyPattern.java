package structural_patterns;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyPattern {
    public static void main(String[] args) {
        User userByProxy = new ProxyFactory().getProxyByProxy(User.class);
        User userByCglib = new ProxyFactory().getProxyByCglib(User.class);
        userByProxy.myName();
        userByCglib.myName();
    }
}

interface User{
    void myName();
}

class UserImpl implements User{

    @Override
    public void myName() {
        System.out.println("我的名字叫小花");
    }
}

class ProxyFactory{
    public <T> T getProxyByProxy(Class clazz){
        Object o = Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{clazz}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("proxy动态代理");
                return null;
            }
        });


        return (T)o;
    }
    public <T> T getProxyByCglib(Class clazz){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new MyMethodInterceptor());

        return (T)enhancer.create();
    }
}


class MyMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib动态代理");
        return null;
    }
}