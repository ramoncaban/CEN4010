package CEN4010.project.ShoppingCart.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CEN4010.project.ShoppingCart.entities.shopping_cart;
import CEN4010.project.ShoppingCart.repositories.CartRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public List<shopping_cart> getshopping_cart() { 
        return cartRepository.findAll(); 
    }  

    public shopping_cart save(shopping_cart shopping_cart) {
        return cartRepository.save(shopping_cart);
    }
 

}