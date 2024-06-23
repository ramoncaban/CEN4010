package CEN4010.project.profile_management.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditCardDto {
    private int id;
    private String cardType;
    private String cardNumber;
    private String expirationDate;
    private int cvv;
    private String cardOwner;
}
