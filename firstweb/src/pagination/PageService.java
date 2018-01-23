package pagination;

import java.util.List;

public class PageService {
    private PageDao dao = new PageDao();

    public List<Employee> findAll(){
        return dao.findAll();
    }

    public long countNumber(){
        return dao.countNumber();
    }

    public List<Employee> findCurrentPageInfo(int currentpage,int pagesize){
        return  dao.findCurrentPageInfo(currentpage,pagesize);
    }

    public List<Employee> queryEmployee(int currentpage,int pagesize, EmployeeQuery query){
        return dao.queryEmployee(currentpage,pagesize,query);
    }
}
