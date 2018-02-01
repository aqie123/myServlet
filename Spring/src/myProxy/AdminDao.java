package myProxy;

public class AdminDao implements Dao{
    @Override
    public void save() {
        System.out.println("模拟： 保存管理员！");
    }

    @Override
    public void find() {
        System.out.println("查询 管理员");
    }
}
