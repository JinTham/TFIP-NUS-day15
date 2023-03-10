package tfip.ssf.day15.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import tfip.ssf.day15.model.Cart;
import tfip.ssf.day15.model.Item;

@Controller
@RequestMapping(path="/cart")
public class ShoppingCartController {
    @GetMapping
    public String getCart(Model model, HttpSession session){
        Cart cart = (Cart)session.getAttribute("cart");
        if (null == cart){
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        model.addAttribute("item", new Item());
        model.addAttribute("cart", cart);
        return "cart";
    }

    @PostMapping
    public String postData(@Valid Item item, BindingResult result, Model model, HttpSession session){
        Cart cart = (Cart)session.getAttribute("cart");
        if (result.hasErrors()){
            model.addAttribute("item",item);
            model.addAttribute("cart", cart);
            return "cart";
        }
        cart.addItemToCart(item);
        model.addAttribute("item",item);
        model.addAttribute("cart", cart);
        return "cart";
    }
}
