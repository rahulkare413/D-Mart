package SmartMart.SmartMart.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "product_id")
    private int productId;

    @Column(name = "Name")
    private String productName;

    @Column(name = "Category")
    private String productCategory;

    @Column(name = "sub_category")
    private String sub_category;

    @Column(name = "Brand")
    private String product_brand;

    @Column(name = "Quantity")
    private String productQty;

    @Column(name = "Price")
    private double productPrice;

    @Column(name = "discounted_price")
    private double discounted_price;
}
