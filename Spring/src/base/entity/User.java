package base.entity;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class User {
    private int id;
    private String name;

    // list 集合
    private List<String> list;

    // map集合

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public Properties getProp() {
        return prop;
    }

    public void setProps(Properties props) {
        this.prop = props;
    }

    private Map<String,Object> map;

    // properties 对象
    private Properties prop;

    public void setList(List<String> list) {
        this.list = list;
    }

    public List<String> getList() {
        return list;
    }

    public User(){
        System.out.println("无参构造函数 创建User对象");
    }
    public User(int id,String name){
        this.id = id;
        this.name = name;
        System.out.println("有参构造函数 创建User对象");
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    // 初始化方法
    public void init(){
        System.out.println("初始化方法");
    }
    // 销毁方法
    public void destory(){
        System.out.println("销毁方法");
    }

    @Override
    public String toString() {
        return "id: "+id+" name: "+name+" list :"+list+" map :"+map+" prop :"+prop;
    }
}
