package myProxy;

public class UserDao implements Dao {
    @Override
    public void save() {
        System.out.println("simulate user save data!");
    }

    @Override
    public void find() {

    }
}
