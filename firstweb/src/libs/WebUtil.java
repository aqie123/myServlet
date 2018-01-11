package libs;

import entity.Contact;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class WebUtil {
    public static <T>T copyRequestToBean(HttpServletRequest req,Class<T> clazz){
        // 1.得到request的所有参数
        Map map = req.getParameterMap();
        // 2.参数名称要和javabean的属性一致
        try {
            // 构造对象
            T t = clazz.newInstance();
            BeanUtils.copyProperties(t,map);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
