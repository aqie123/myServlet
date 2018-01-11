package BeanUtils;

import entity.Student;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

// 使用beanutils工具操作javabean
public class MyBean {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        Test test = new Test();
        // test.method();
        // test.method2();
        // test.method3();
        test.method4();
    }
}

class Test{
    // 1.拷贝一个javabean对象属性
    void method() throws InvocationTargetException, IllegalAccessException {
        Student student = getStudent();
        // 新对象 Student2
        Student s2 = new Student();
        // 拷贝到对象,拷贝属性,拷贝的值
        BeanUtils.copyProperty(s2,"id", student.getId());
        System.out.println(s2.getId());
    }

    // 2. 使用反射构造对象
    void method2() throws InvocationTargetException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        Object s2 = Class.forName("entity.Student").newInstance();
        // 注册日期转换器(需要注册的转换器,转换到的类型)
        ConvertUtils.register(new MyDateConvert(),Date.class);
        // 拷贝到对象,拷贝属性,拷贝的值
        BeanUtils.copyProperty(s2,"id", "3"); // 不需要依赖对象
        BeanUtils.copyProperty(s2,"score", "99.99");
        BeanUtils.copyProperty(s2,"name", "aqie");
        BeanUtils.copyProperty(s2,"birth", "1993/01/16"); // 默认 1993-01-16
        System.out.println(s2);
    }

    // 3.从一个javabean拷贝到另一个javabean对象
    void method3() throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Student student = getStudent();
        Object s2 = Class.forName("entity.Student").newInstance();
        // student 拷贝到s2对象中去
        // (拷贝到对象,原来对象)
        BeanUtils.copyProperties(s2,student);
        System.out.println(s2);
    }

    // 4.从一个map集合拷贝到javabean中
    void method4() throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Map map = new HashMap();
        // map.put("name","啊切");
        map.put("name",new String[]{"aqie","bqie"});
        map.put("id","007");
        map.put("gender","false");
        map.put("score","66.66");
        Object s2 = Class.forName("entity.Student").newInstance();
        BeanUtils.copyProperties(s2,map);
        System.out.println(s2);
    }

    private Student getStudent() {
        Student student = new Student();
        student.setId(1);
        student.setName("aqie");
        student.setScore(99.99);
        student.setGender(true);
        student.setBirth(new Date());
        return student;
    }
}

// 自定义日期转换器
class MyDateConvert implements Converter{
    /**
     * new DateLocaleConverter()
     * @param aClass 被转换类型
     * @param o 需要转换的值
     * @return （返回转换后值）
     */
    @Override
    public Object convert(Class aClass, Object o) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        if(aClass == Date.class){
            String date = (String)o;
            // String按格式转换
            try {
                Date currDate = sdf.parse(date);
                return currDate;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
