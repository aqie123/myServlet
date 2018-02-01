package ReflectionOfGeneric;

import base.entity.Lion;

import java.util.List;

public class LionDao extends BaseDao2<Lion> {
    public static void main(String[] args) {
        LionDao dao = new LionDao();
        List<Lion> lions = dao.findAll();
        for (Lion lion : lions){
            System.out.println(lion);
        }
    }
}
