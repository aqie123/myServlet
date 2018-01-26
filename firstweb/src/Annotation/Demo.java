package Annotation;

import java.util.ArrayList;
import java.util.List;

/**
 * 常见的注解
 */
public class Demo {
    @Override
    public String toString() {
        return super.toString();
    }

    @SuppressWarnings(value = "unchecked")
    public void save(){
        List list = new ArrayList();
    }
    @Deprecated
    public void update(){}
    public void update(String name){}
}
