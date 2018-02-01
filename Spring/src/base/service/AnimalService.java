package base.service;

import base.dao.Dao;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

// @Component("animalService")
// @org.springframework.stereotype.Service("animalService")
@org.springframework.stereotype.Service
public class AnimalService  implements Service{
    @Resource
    private Dao animalDao;
    /*@Resource(name = "animalsDao")      // 根据 animalsDao名称到IOC容器找对象，然后注入到当前方法
    public void setAnimalsDao(Dao animalDao){
        this.animalDao = animalDao;
    }*/
    public void save(){
        animalDao.save();
    }
}
