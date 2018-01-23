package pagination;

/**
 *  用于封装用户输入的部门查询条件
 */
public class DepartmentQuery {
    private String name;
    private String leader;
    private String function;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getLeader() {
        return leader;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getFunction() {
        return function;
    }
}
