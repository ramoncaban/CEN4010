package CEN4010.project.profile_management;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Profile {
    private int id;
    private String username;
    private String password;
    private String name;
    private String emailAddress;
    private String homeAddress;


}
