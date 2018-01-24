package ReflectionOfGeneric;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型关键字  反射泛型
 */
public class Demo {
    public void add(List list){

    }

    @Test
    public void test(){
        /**
         * 没有加上泛型,会报警告,希望加上泛型特征
         */
        List<?> list = new ArrayList();
        list.add();
        add(list);
    }
}
