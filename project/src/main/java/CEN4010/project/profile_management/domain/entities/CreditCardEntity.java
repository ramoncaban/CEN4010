package CEN4010.project.profile_management.domain.entities;

import jakarta.persistence.Entity;
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
    private int id;
    private String cardtype;
    private String cardnumber;
    private String expirationdate;
    private int cvv;
    private String cardowner;
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private ProfileEntity user;

    public void setUser(ProfileEntity user) {
        this.user = user;
    }

    public void setCardowner(String cardowner) {
        this.cardowner = cardowner;
    }
}