package action;

import service.AnimalService;

public class AnimalAction {
    AnimalService service = new AnimalService();
    public void execute(){
        service.save();
    }
}
