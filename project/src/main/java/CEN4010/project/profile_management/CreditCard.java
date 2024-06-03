package CEN4010.project.profile_management;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditCard {
    private String cardType;
    private long cardNumber;
    private String expirationDate;
    private int cvv;


}
