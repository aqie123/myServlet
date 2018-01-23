package pagination;

import java.util.List;

public class PageBean {

    private List<Employee> data;    // 当前页数据
    private int totalPage;  // 总页数
    private int currentPage; // 当前页数
    private int totalCount;  // 总数量
    private int pageSize;   // 每页总数

    public PageBean(){}
    public PageBean(int currentPage,int pageSize){
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    public List<Employee> getData() {
        return data;
    }

    public void setData(List<Employee> data) {
        this.data = data;
    }

    public int getFirstPage() {
        return 1;
    }

    // 前一页
    public int getPrePage() {
        return (this.getCurrentPage() == this.getFirstPage()) ? 1 : (this.getCurrentPage()-1);
    }

    // 后一页
    public int getNextPage() {
        return (this.getCurrentPage()==this.getFirstPage()) ? 2 : ((this.getCurrentPage()+1)>=this.getTotalPage() ? this.getTotalPage() : (this.getCurrentPage()+1));
    }

    // 总页数
    public int getTotalPage() {
        return this.getTotalCount()%this.getPageSize() == 0
                ? (this.getTotalCount()/this.getPageSize())
                : (this.getTotalCount()/this.getPageSize())+1;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
