package CEN4010.project.ShoppingCart.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CEN4010.project.ShoppingCart.entities.cart_items;
import CEN4010.project.ShoppingCart.repositories.Cart_itemsRepository;

@Service
public class Cart_itemService {

    @Autowired
    private Cart_itemsRepository cart_itemsRepository;

    public Cart_itemService(Cart_itemsRepository cart_itemsRepository) {
        this.cart_itemsRepository = cart_itemsRepository;
    }

    public List<cart_items> getcart_items() { 
        return cart_itemsRepository.findAll(); 
    }  

    public cart_items save(cart_items cart_items) {
        return cart_itemsRepository.save(cart_items);
    }
 

}