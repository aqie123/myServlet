package ReflectionOfGeneric;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型关键字  反射泛型
 */
public class Demo {
    /**
     * 该方法只能接受存放着Number类型的子类对象的list集合
     */
    public void add(List<? extends Number> list){

    }

    public void add2(List<? super Number> list){

    }

    public ArrayList getList(){
        return new ArrayList();
    }


    @Test
    public void test() throws Exception {
        Class<?> clazz = Class.forName("base.entity.Child");
        /**
         * 没有加上泛型,会报警告,希望加上泛型特征
         */
        List<?> list = getList();


        /**
         *  限定该 List 保存 Double  Float Integer
         */
        List<? extends Number> list1 = new ArrayList();

        List<Integer> list2 = new ArrayList<>();
        List<Float> list3 = new ArrayList<>();
        List<Double> list4 = new ArrayList<>();
        List<String> list5 = new ArrayList<>();
        List<Number> list6 = new ArrayList<>();
        add(list1);
        add(list2);
        add(list3);
        add(list4);

        add2(list6);

    }

}
