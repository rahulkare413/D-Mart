package SmartMart.SmartMart.Repository;

import SmartMart.SmartMart.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query(value = "select * from product",nativeQuery = true)
    public List<Product> getAllProduct();


    @Query(value = "select * from product where product_id=:id",nativeQuery = true)
    public Product getSingleProduct(@Param("id")int id);


}
