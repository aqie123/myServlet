package myAOP;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理工厂
 */
public class ProxyFactory {
    /**
     * 生成代理对象
     * @param target    目标对象
     * @param aop       给目标对象动态注入的重复代码(关注点代码)
     * @return
     */
    public Object getProxyInstance(Object target,TransactionAop aop){
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    aop.beginTransaction();
                    // 执行目标对象方法
                    Object result = method.invoke(target,args);
                    aop.commit();
                    return result;
                }
        );
    }
}
