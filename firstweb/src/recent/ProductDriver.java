package recent;

import java.util.List;

public class ProductDriver {
    public static void main(String[] args) {
        productList();
        //productDetail();
    }

    public static void productList(){
        ProductDao productDao = new ProductDao();
        List<Product> list = productDao.findAll();
        for(Product product: list){
            System.out.println(product);
        }
    }

    public static void productDetail(){
        ProductDao productDao = new ProductDao();
        Product p = productDao.findById("2");
        System.out.println(p);
    }
}
