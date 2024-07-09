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
    private String cardtype;
    private String cardnumber;
    private String expirationdate;
    private int cvv;
    private String cardowner;
    private int user_id;
}
