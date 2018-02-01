package myProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理：代理工厂,给多个目标对象生成代理对象
 */
public class AdminDaoProxy {
    // 接收一个目标对象
    private Object target;
    public AdminDaoProxy(Object target){
        this.target = target;
    }

    public Object getTarget() {
        Object proxy = Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 目标对象使用的类加载器
                target.getClass().getInterfaces(),  // 目标对象实现的所有接口
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 获取当前执行方法的方法名
                        String methodName = method.getName();
                        //方法返回值
                        Object result = null;
                        // 判断
                        if ("find".equals(methodName)) {
                            // 直接调用目标对象方法
                            result = method.invoke(target, args);
                        } else {
                            System.out.println("开启事务...");
                            // 执行目标对象方法
                            result = method.invoke(target, args);
                            System.out.println("提交事务...");

                        }
                        return result;
                    }
                }
        );
        return proxy;
    }
}
