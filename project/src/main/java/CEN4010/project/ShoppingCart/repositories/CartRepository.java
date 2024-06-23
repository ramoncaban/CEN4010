package CEN4010.project.ShoppingCart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import CEN4010.project.ShoppingCart.entities.shopping_cart;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<shopping_cart, Integer> {

}