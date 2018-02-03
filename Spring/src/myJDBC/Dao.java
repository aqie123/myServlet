package myJDBC;

import java.io.Serializable;
import java.util.List;

public interface Dao {
    public void save(Department dept);
    public void update(Department dept);
    public void delete(Serializable id);
    public Department findById(Serializable id);
    public List<Department> getAll();
}
