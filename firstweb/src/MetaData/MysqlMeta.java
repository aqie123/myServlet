package MetaData;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

// 数据库元数据
public class MysqlMeta {
    public static void main(String[] args) throws SQLException {
        Test test = new Test();
        test.method();

    }
}

class Test{
    void method() throws SQLException {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        Connection connection = cpds.getConnection();
        // 使用数据库元数据
        DatabaseMetaData dmd = connection.getMetaData();
        // 指定那个数据库
        System.out.println(dmd.getDatabaseProductName());
        // 数据库版本
        System.out.println(dmd.getDatabaseMajorVersion());
        // 使用驱动程序的版本
        System.out.println(dmd.getDriverMajorVersion());
        System.out.println(dmd.getDriverMinorVersion());
    }
}
