package generics;

import com.sun.org.apache.xpath.internal.operations.String;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 复习反射
 */
public class Demo {
    // 1.将程序运行时错误提前到编译时报错
    public void test(){
        List<Cat> list = new ArrayList();
        list.add(new Cat());
        // list.add(new Dog());

        // 取出
        Cat cat = (Cat)list.get(0);
        // 运行时报错
        Cat cat2 = (Cat)list.get(1);
    }

    // 2.设计通用的方法,可以接收任意类型
    public <T,K> void save(T t,K k){

    }
    public <T> void update(T t){

    }

    @Test
    public void testSave(){
        save(new Cat(),new String());
        save(new Dog(),new String());
    }
}

/**
 * 泛型类
 */
class Demo2<T,K>{
    public T save(T t,K k){
        return t;
    }
    public void update(T t,K k){

    }
}

/**
 * 泛型接口
 */
interface InterfaceBaseDao<T>{
    public void save(T t);
    public void update(T t);
}

/**
 * 通用的 Dao 实现类
 */
abstract class BaseDao<T> implements InterfaceBaseDao<T>{

    @Override
    public abstract void save(T o);

    @Override
    public abstract void update(T o);
}

/**
 * 具体的业务Dao
 */
class EmployeeDao extends BaseDao<Employee>{

    @Override
    public void save(Employee o) {

    }

    @Override
    public void update(Employee o) {

    }
}

class Cat{}

class Dog{}

class Employee{

}

