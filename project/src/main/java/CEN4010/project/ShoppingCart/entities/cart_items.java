package CEN4010.project.ShoppingCart.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class cart_items {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "id")
private Integer id;

@ManyToOne
@JoinColumn(name = "cart_id", nullable = false)
public shopping_cart cart_id;

@Column(name = "book_id", nullable = false)
public Integer book_id;

@Column(nullable = false)
public Integer quantity;

public cart_items() {

}

public cart_items(shopping_cart cart_id, Integer book_id, Integer quantity) {
this.cart_id = cart_id;
this.book_id = book_id;
this.quantity = quantity;
}
public Integer getId() { 
    return id; 
} 

public shopping_cart getcart_id() {
    return cart_id;
}

public Integer getbook_id() { 
    return book_id; 
} 

public Integer getquantity() { 
    return quantity; 
} 

public void setId(Integer id) { 
    this.id = id; 
} 

public void setcart_id(shopping_cart cart_id) {
    this.cart_id = cart_id;
}

public void setbook_id(Integer book_id) { 
    this.book_id = book_id; 
} 

public void setquantity(Integer quantity) { 
    this.quantity = quantity; 
} 
} 
