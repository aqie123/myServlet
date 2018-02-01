package base.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

// 将AnimalDao加入ioc容器
// @Component("animalsDao")
// @Repository("animalsDao")
@Repository         // 默认类名第一个字母小写
public class AnimalsDao implements Dao{
    public void save(){
        System.out.println("save animal success!");
    }
}
