package listener;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

public class JdbcUtil {
    private static ComboPooledDataSource ds = new ComboPooledDataSource();
    public static DataSource getDataSource(){
        return ds;
    }
}
