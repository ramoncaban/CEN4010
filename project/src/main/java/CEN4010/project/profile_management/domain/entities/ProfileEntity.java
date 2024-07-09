package CEN4010.project.profile_management.domain.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class ProfileEntity {
    @Id
    private int id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String address;

    @OneToMany(mappedBy= "user")
    private List<CreditCardEntity> creditCards;
}