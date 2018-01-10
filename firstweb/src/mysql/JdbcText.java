package mysql;

import java.io.*;
import java.sql.*;

// 使用jdbc操作text
public class JdbcText {
    public static void main(String[] args) throws FileNotFoundException {
        Test4 test4 = new Test4();
        /*String sql = "insert into attachments(name,file,create_time) values(?,?,?)";
        test4.write(sql);*/
        String sql = "select * from attachments where id = ?";
        test4.read(sql);
    }
}

class Test4{
    void write(String sql) throws FileNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = JdbcUtil.getConnection();
            statement = connection.prepareStatement(sql);
            // 预编译
            statement.setString(1,"Bunolagus");

            // 读取本地文件
            /*Reader reader = new FileReader("firstweb/staticFile/a.txt");
            // 设置text
            statement.setClob(2,reader);*/
            // 读取本地图片
            FileInputStream inputStream = new FileInputStream(new File("firstweb/staticFile/a.jpg"));
            statement.setBlob(2,inputStream);
            // setDate() 设置的为java.sql.Date类型,而非java.util.Date类型
            statement.setDate(3,new Date(new java.util.Date().getTime()));
            statement.executeUpdate();
            System.out.println("上传成功");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(statement,connection);
        }
    }

    void read(String sql){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try{
            connection = JdbcUtil.getConnection();
            statement = connection.prepareStatement(sql);
            // 预编译
            statement.setInt(1,3);

            rs = statement.executeQuery();
            while (rs.next()){
                // 1.当字符串读取
                // System.out.println(rs.getString("content"));
                // 2.当输入流读取
                /*Clob clob = rs.getClob("file");
                Reader reader = clob.getCharacterStream();
                // 2.1 输入流写入文件
                FileWriter writer = new FileWriter("D:\\coreJava\\myServlet\\firstweb\\staticFile\\b.jpg");
                char[] buff = new char[512];
                int len = 0;
                while ((len = reader.read(buff)) != -1){
                    writer.write(buff,0,len);
                }
                writer.close();
                reader.close();
                */
                // 图片写出到硬盘
                InputStream inputStream = rs.getBinaryStream("file");
                BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("firstweb/staticFile/c.jpg"));
                byte[] bytes = new byte[1024];
                int len = 0;
                while((len = inputStream.read(bytes)) != -1){
                    outputStream.write(bytes,0,len);
                }
                outputStream.close();
                inputStream.close();
                java.util.Date date = rs.getDate("create_time");
                System.out.println("写入时间为 "+date);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(rs,statement,connection);
        }
    }
}
