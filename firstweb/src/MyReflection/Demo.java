package MyReflection;

import base.entity.Child;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchFieldException {
        Test test = new Test();
        // test.method();
        // test.method1();
        // test.method2();
        test.method3();
    }
}
class Test{
    /**
     * Class 类
     */
    void method() throws ClassNotFoundException {
        // 1. 方式一得到class 的对象
        // Class clazz = Child.class;
        // 2.方式二 得到class 的对象 (只依赖字符串)
        // Class clazz = Class.forName("entity.Child");
        // 3.方式三
        Class clazz = new Child(1,"aqie").getClass();

        // 得到类名
        System.out.println(clazz.getName());        // entity.Child
        System.out.println(clazz.getSimpleName());  // Child

        // 得到类的继承结构
        Class parent = clazz.getSuperclass();
        System.out.println(parent.getSimpleName()); // Object

        // 得到类的接口
        Class[] interList = clazz.getInterfaces();
        for(Class inter : interList){
            System.out.println(inter.getSimpleName());
        }
    }

    /**
     * Constructor 类
     */
    void method1() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 1. 通过Class类得到Constructor类
        Class clazz = Class.forName("base.entity.Child");
        // 2. 根据不同的参数列表,获取不同构造方法Constructor对象
        // 2.1 调用无参的构造方法
        Constructor constructor = clazz.getConstructor(null);
        // 3.通过Constructor类的方法构造对象
        Object object = constructor.newInstance(null);
        System.out.println(object.getClass().getSimpleName());

        // 2.2 调用有参的构造方法
        Constructor constructor1 = clazz.getConstructor(int.class,String.class);
        Object object1 = constructor1.newInstance(1,"aqie");
        System.out.println(object1);

    }

    /**
     * Method 类
     */
    void method2() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        // 1.通过Class类对象得到Method类对象
        Class clazz = Class.forName("base.entity.Child");
        Object object = clazz.getConstructor(null).newInstance(null);
        /**
         * 1.getMethod() 获取类上的公共方法 public
         * 2.getDeclaredMethod() 获取所有方法 public private
         */
        // 2.1 获取类上的公共方法
        /**
         * 参数一：方法名
         * 参数二：形式参数列表
         */
        Method setName = clazz.getMethod("setName", String.class);
        // 通过method对象调用方法
        /**
         * 参数一：调用方法所需对象
         * 参数二：实际参数
         */
        setName.invoke(object,"啊切");
        System.out.println(object);

        Method getName = clazz.getMethod("getName",null);
        // 调用
        String name = (String)getName.invoke(object,null);
        System.out.println(name);
    }

    /**
     * Field 类
     */
    void method3() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        // 1.通过Class得到Field类对象
        Class clazz = Class.forName("base.entity.Child");
        // 1.1简化版本，只能用无参构造函数
        Object object = clazz.newInstance();
        /**
         * getDeclaredField()  得到所有属性 (public private)
         * getField()          得到public 属性
         */
        Field name = clazz.getDeclaredField("name");
        // 2. 得到属性名
        System.out.println(name.getName());
        // 3.得到属性类型
        System.out.println(name.getType());
        /**
         * 赋值 ：name = "aqie"
         * 利用反射,
         * 参数一：赋值给哪个对象
         * 参数二：
         */
        // 打破私有修饰符限制
        name.setAccessible(true);
        name.set(object,"toby");
        // 获取属性值
        Object result = name.get(object);
        System.out.println(result);
    }
}
