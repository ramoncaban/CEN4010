package CEN4010.project.profile_management.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "profiles")
public class ProfileEntity {
    @Id
    private int id;
    private String username;
    private String password;
    private String name;
    private String emailAddress;
    private String homeAddress;
}
