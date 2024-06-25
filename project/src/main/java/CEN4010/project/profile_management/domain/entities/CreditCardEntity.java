package CEN4010.project.profile_management.domain.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "creditcards")
public class CreditCardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "creditcards_id_seq")
    private int id;
    private String cardType;
    private String cardNumber;
    private String expirationDate;
    private int cvv;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id")
    private ProfileEntity cardOwner;
}
