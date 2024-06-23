package CEN4010.project.ShoppingCart.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class shopping_cart {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer id;

@Column(name = "user_id", nullable = false)
public Integer user_id;

public shopping_cart() {

}

public shopping_cart(Integer user_id) {
this.user_id = user_id;

}
public Integer getId() { 
    return id; 
} 

public Integer getuser_id() { 
    return user_id; 
} 

public void setId(Integer id) { 
    this.id = id; 
} 

public void setuser_id(Integer user_id) { 
    this.user_id = user_id; 
} 
}
