package FileUpload;

import mysql.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class FileBeanDao {
    // 保存文件信息的方法
    public void saveFile(FileBean bean){
        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
        try {
            qr.update("insert into file_list(name,size,type,addtime,file_path,info) values(?,?,?,?,?,?)",
                    new Object[]{
                            bean.getName(),
                            bean.getSize(),
                            bean.getType(),
                            bean.getAddTime(),
                            bean.getFile_path(),
                            bean.getInfo()
                    });
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 根据id查找文件
     */
    public FileBean findByID(int id){
        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
        try {
            return (FileBean)qr.query("select * from file_list where id=?",
                    new BeanHandler<>(FileBean.class),
                    new Object[]{id});
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public List<FileBean> findAll(){
        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
        try {
            return (List<FileBean>)qr.query("select * from file_list",
                    new BeanListHandler<>(FileBean.class),
                    new Object[]{});
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        FileBeanDao dao = new FileBeanDao();
        /*
        编写测试数据 存入数据库
        FileBean bean = new FileBean();
        bean.setInfo("描述");
        bean.setName("aqie.jpg");
        bean.setSize("23KB");
        bean.setType("image/jpg");
        bean.setAddTime("2018-1-20 18:43:00");
        // bean.setFile_path("D:/coreJava/myServlet/firstweb/web/staticFile/Uploads/1.jpg");
        bean.setFile_path("staticFile/Uploads/1.jpg");
        dao.saveFile(bean);*/
        FileBean bean = dao.findByID(1);
        // dao.findAll();
        System.out.println(bean);
    }
}
