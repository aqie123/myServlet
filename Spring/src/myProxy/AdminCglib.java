package myProxy;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib 代理
 */
public class AdminCglib implements MethodInterceptor{
    // 创建目标对象
    private Object target;
    public AdminCglib(Object target){
        this.target = target;
    }


    // 返回目标代理后的子类对象
    public Object getTarget() {
        // 字节码生成工具类
        Enhancer enhancer = new Enhancer();
        // 设置父类
        enhancer.setSuperclass(target.getClass());
        // 设置回调函数
        enhancer.setCallback(this);
        // 创建子类对象
        return enhancer.create();
    }

    // 事件处理器,执行目标方法时触发
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开启事务");
        Object result = method.invoke(target,objects);
        System.out.println("提交事务");
        return result;
    }
}
