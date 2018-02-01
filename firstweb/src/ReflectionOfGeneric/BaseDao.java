package ReflectionOfGeneric;

import mysql.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;

public class BaseDao<T> {
    private Class targetClass;
    private String targetTable;

    public BaseDao(){
        // this 代表当前运行的dao对象
        Class clazz = this.getClass();
        // 得到当前dao对象父类
        Type type = clazz.getGenericSuperclass();
        // 父类强制转换成子类
        ParameterizedType parameterizedType = (ParameterizedType)type;
        Type[] types = parameterizedType.getActualTypeArguments();
        Type target = types[0];
        targetClass = (Class)target;
        targetTable = targetClass.getSimpleName().toLowerCase();
    }

    private QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
    public List<T> findAll(){
        try {
            return (List<T>)qr.query("select * from "+targetTable,new BeanListHandler<>(targetClass));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public T findByID(int id){
        try {
            return (T)qr.query("select * from "+targetTable+" where id = ?",new BeanHandler<>(targetClass),new Object[]{id});
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
