package base.action;

import base.service.Service;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

// @Component("animalAction")  // 加入IOC容器
// @Controller("animalAction")
@Controller
@Scope("prototype")         // 多例
public class AnimalAction {
    @Resource   // 默认根据下面名称去找,没找到就根据类型找
    private Service animalService;
    /*@Resource(name="animalService")
    public void setAnimalService(Service animalService){
        this.animalService = animalService;
    }*/
    public void execute(){
        animalService.save();
    }
}
