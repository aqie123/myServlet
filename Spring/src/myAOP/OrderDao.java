package myAOP;

import org.springframework.stereotype.Repository;

@Repository
public class OrderDao {
    public void save(){
        System.out.println("save Order！");
    }
}
