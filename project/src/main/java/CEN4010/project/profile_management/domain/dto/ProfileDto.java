package CEN4010.project.profile_management.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileDto {
    private int id;
    private String username;
    private String password;
    private String name;
    private String emailAddress;
    private String homeAddress;
}
