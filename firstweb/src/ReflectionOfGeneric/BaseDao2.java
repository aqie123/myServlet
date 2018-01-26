package ReflectionOfGeneric;

import mysql.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import sun.plugin2.main.server.ResultHandler;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BaseDao2<T> {
    private Class targetClass;
    private String targetTable;

    public BaseDao2(){
        // this 代表当前运行的dao对象
        Class clazz = this.getClass();
        // 得到当前dao对象父类
        Type type = clazz.getGenericSuperclass();
        // 父类强制转换成子类
        ParameterizedType parameterizedType = (ParameterizedType)type;
        // 得到参数化类型,上面泛型类型列表
        Type[] types = parameterizedType.getActualTypeArguments();
        // 取出泛型类型列表中的第一个泛型类型
        Type target = types[0];
        // 强制转为Class类型
        targetClass = (Class)target;
        /**
         * 获取表名来自类上面注解
         */
        Table table = (Table)targetClass.getAnnotation(Table.class);
        targetTable = table.tableName();
    }

    public QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());

    public List<T> findAll(){
        try {
            return (List<T>)qr.query("select * from "+targetTable+"",new MyBeanListHandler());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public T findByID(int id){
        try {
            return (T)qr.query("select * from "+targetTable+" where sid = ?",new BeanHandler<>(targetClass),new Object[]{id});
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    // 自行设计一个封装多个对象的List集合的ResultSetHandler
    class MyBeanListHandler implements ResultSetHandler{
        @Override
        public Object handle(ResultSet resultSet) throws SQLException {
            try {
                List<T> list = new ArrayList<>();
                // 得到结果集元数据(sid,sname)
                ResultSetMetaData rsmd = resultSet.getMetaData();
                // 得到表的列数量
                int columnCount = rsmd.getColumnCount();
                // 遍历行
                while(resultSet.next()){
                    // 创建对象
                    T obj = (T)targetClass.newInstance();
                    // 遍历列
                    for(int i = 1;i<=columnCount;i++){
                        // 得到列的值
                        Object value =  resultSet.getObject(i);

                        // 得到属性名 sid
                        String columnName = rsmd.getColumnName(i).toLowerCase();
                        // 遍历所有的属性(Student 类的属性 id,name)
                        Field[] fields = targetClass.getDeclaredFields();
                        for(Field field : fields){
                            // 得到属性上面注解
                            Column column = field.getAnnotation(Column.class);
                            // 得到注解内容(通过遍历属性,得到属性对应的表中名字)
                            String cname = column.name().toLowerCase();
                            // 表中字段名等于注解属性名,给对应属性赋值
                            if(columnName.equals(cname)){
                                // 需要赋值的属性
                                field.setAccessible(true);
                                field.set(obj,value);
                                break;
                            }
                        }
                    }
                    // 封装好对象放入list集合中
                    list.add(obj);
                }
                return list;
            }catch (Exception e){
                e.printStackTrace();
                throw new RuntimeException(e);
            }

        }
    }

    class MyBeanHandler extends ResultHandler {

        @Override
        public void waitForSignal() {

        }

        @Override
        public void waitForSignal(long l) {

        }
    }

}
