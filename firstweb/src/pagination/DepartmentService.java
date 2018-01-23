package pagination;

import java.util.List;

public class DepartmentService {
    DepartmentDao dao = new DepartmentDao();
    public List<Department> findAll(){
        return dao.findAll();
    }

    public List<Department> findByCondition(DepartmentQuery query){
        return dao.findByCondition(query);
    }

    public Department findByID(int id){
        return dao.findByID(id);
    }
}
