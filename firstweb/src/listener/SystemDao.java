package listener;

import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

/**
 * 初始化表(创建表)
 */
public class SystemDao {
    public void initTable(){
        try{
            QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
            qr.update("create table chair(\n" +
                    "\tid int auto_increment primary key,\n" +
                    "    name varchar(20)\n" +
                    ");");
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    public void clearTable(){
        try{
            QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
            qr.update("drop table chair");
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
