package MetaData;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 连接池版本的 JdbcUtil
 */
public class JdbcUtil {
    // 一个数据库只需要一个连接池对象
    public static DataSource cpds = new ComboPooledDataSource();
    // 获取连接池对象
    public static DataSource getDataSource(){
        return cpds;
    }
    // 获取连接对象方法
    public static Connection getConnection(){
        try {
            return cpds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
