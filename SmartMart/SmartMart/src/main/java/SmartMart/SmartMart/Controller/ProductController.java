package SmartMart.SmartMart.Controller;

import SmartMart.SmartMart.Model.Product;
import SmartMart.SmartMart.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService smartMartService;

    @GetMapping("/display")
    public String displayProducts(Model model){
        List<Product> temp=smartMartService.displayAllProducts();
//        System.out.println(temp);
        model.addAttribute("productList",temp);
        return "displayProducts";

    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id){
        smartMartService.deleteProductById(id);
        return "redirect:/product/display";
    }
    @GetMapping("/updateProduct/{id}")
    public String updateProduct(@PathVariable int id , Model model ){
        Product p = smartMartService.fetchProductObject(id);
        model.addAttribute("currentProductObject",p);
        smartMartService.fetchProductObject(id);
        return "updateProduct";
    }

    @PostMapping("/updateProduct")
    public String updateProductData(Product p){
        smartMartService.updateProducts(p);
        return "redirect:/product/display";

    }


        @GetMapping("/addProduct")
        public String addNewProducts(Model model){
        model.addAttribute("newProduct", new Product());
        return "addProducts";
        }

        @GetMapping("/addProducts")
        public String saveNewProducts(@ModelAttribute("newProduct") Product p ){
        smartMartService.addProducts(p);
            return "redirect:/product/display";


        }



}
