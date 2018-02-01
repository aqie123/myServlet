package myAOP;

import org.springframework.stereotype.Repository;

@Repository
public class AdminDao implements Dao{
    public void save(){
        System.out.println("保存");
    }
}
