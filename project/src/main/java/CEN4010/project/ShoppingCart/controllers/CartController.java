package CEN4010.project.ShoppingCart.controllers;

import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import CEN4010.project.ShoppingCart.entities.shopping_cart;
import CEN4010.project.ShoppingCart.service.CartService;



@RestController
public class CartController {

  @Autowired
  
    private CartService cartService;

    public CartController(CartService cartService) {
      this.cartService = cartService;
  }

  @GetMapping("/cart")
  public List<shopping_cart> getshopping_cart() {
    return cartService.getshopping_cart();
  }

  @PostMapping
  public shopping_cart createCart(@RequestBody shopping_cart shopping_cart) {
      return cartService.save(shopping_cart);
  }


}