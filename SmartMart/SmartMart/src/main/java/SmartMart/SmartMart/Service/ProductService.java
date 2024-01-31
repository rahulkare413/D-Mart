package SmartMart.SmartMart.Service;

import SmartMart.SmartMart.Model.Product;
import SmartMart.SmartMart.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository smartMartRepository;

    public List<Product> displayAllProducts(){
//        System.out.println("service"+smartMartRepository.getAllProduct());
//        return smartMartRepository.findAll();
        List<Product> p = null;
        try {
            p = smartMartRepository.getAllProduct();
        }catch (Exception e){
            e.printStackTrace();

        }
        return p;
    }

    public void deleteProductById(int id) {
        try {
            smartMartRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public Product fetchProductObject(int id) {
        Product p = null;
        try{
            p = smartMartRepository.getSingleProduct(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return p;
    }

    public void updateProducts(Product p){
        smartMartRepository.save(p);

    }

    public void addProducts(Product p){
        smartMartRepository.save(p);
    }
}
