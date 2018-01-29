package service;

import dao.AnimalsDao;

public class AnimalService {
    private AnimalsDao dao = new AnimalsDao();
    public void save(){
        dao.save();
    }
}
