package pagination;

import mysql.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class DepartmentDao {
    QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
    public List<Department> findAll(){
        String sql = "select * from department";
        List<Department> list = null;
        try {
            list = (List<Department>)qr.query(sql, new BeanListHandler<>(Department.class));
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Department findByID(int id){
        try {
            return (Department)qr.query("select * from department where id=?",
                    new BeanHandler<>(Department.class),new Object[]{id});
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    // 根据条件查询
    public List<Department> findByCondition(DepartmentQuery query){
        StringBuffer sql = new StringBuffer("select * from department where 1=1");
        if(query != null){
            if(query.getName() != null && !query.getName().trim().equals("")){
                sql.append(" and name like '%"+query.getName()+"%'");
            }
            if(query.getLeader() != null && !query.getLeader().trim().equals("")){
                sql.append(" and leader like '%"+query.getLeader()+"%'");
            }
            if(query.getFunction() != null && !query.getFunction().trim().equals("")){
                sql.append(" and function like '%"+query.getFunction()+"%'");
            }
        }
        System.out.println(sql.toString());
        try {
            return (List<Department>)qr.query(sql.toString(), new BeanListHandler(Department.class));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        DepartmentDao dao = new DepartmentDao();
        /*
        测试查询全部
        List<Department> list = dao.findAll();
        for(Department department : list){
            System.out.println(department);
        }*/
        /*
        测试条件查询
        DepartmentQuery query = new DepartmentQuery();
        query.setName("技术");
        query.setFunction("app");
        List<Department> list = dao.findByCondition(query);
        for(Department department : list){
            System.out.println(department);
        }*/
        Department department = dao.findByID(1);
        System.out.println(department);
    }

}
