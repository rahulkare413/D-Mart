package SmartMart.SmartMart.Controller;

import SmartMart.SmartMart.Model.Cart;
import SmartMart.SmartMart.Repository.CartRepository;
import SmartMart.SmartMart.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @GetMapping("/addProductToTheCart/{id}")
    public String addProductToTheCart(@PathVariable int id){
        cartService.addProductToTheCart(id);
        return "redirect:/product/display";

    }
    @GetMapping("/displayCart")
    public String displayCartProducts(Model model){
        List<Cart> cartList = cartService.getAllProducts();
        model.addAttribute("cartList",cartList);
        return "cartProduct";

    }
    @GetMapping("/decreaseProductQty/{id}")
    public String decreasesProductQty(@PathVariable int id){
        cartService.decreaseProductQty(id);
        return "redirect:/cart/displayCart";


    }
    @GetMapping("/increaseProductQty/{id}")
    public String increaseProductQty(@PathVariable int id){
        cartService.increaseProductQty(id);
        return "redirect:/cart/displayCart";
    }


}
