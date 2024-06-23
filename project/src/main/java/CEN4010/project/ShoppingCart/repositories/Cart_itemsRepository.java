package CEN4010.project.ShoppingCart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import CEN4010.project.ShoppingCart.entities.cart_items;
import org.springframework.stereotype.Repository;

@Repository
public interface Cart_itemsRepository extends JpaRepository<cart_items, Integer> {

}       