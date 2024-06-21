package CEN4010.project.ShoppingCart.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import CEN4010.project.ShoppingCart.entities.cart_items;
import CEN4010.project.ShoppingCart.service.Cart_itemService;



@RestController
public class Cart_itemsController {

  @Autowired
  
    private Cart_itemService cart_itemService;

    public Cart_itemsController(Cart_itemService cart_itemService) {
      this.cart_itemService = cart_itemService;
  }

  @GetMapping("/cartitems")
  public List<cart_items> getcart_items() {
    return cart_itemService.getcart_items();
  }

  @PostMapping("/cartitems")
  public cart_items createCartItem(@RequestBody cart_items cart_items) {
      return cart_itemService.save(cart_items);
  }


}