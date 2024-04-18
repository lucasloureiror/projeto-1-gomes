package dupradosantini.sostoolbackend.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppUser implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "AppUser name field is required")
    @Length(min = 3, max = 60, message = "AppUser name must be between 3 and 30 characters")
    private String name;

    @Column(unique = true)
    @NotEmpty(message = "AppUser email field is required")
    @Length(max = 70, message = "AppUser email can have at most 30 characters")
    private String email;

    @Length(max=200, message = "AppUser password can have at most 200 characters")
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "appUser")
    @JsonManagedReference(value = "appUser-workspaceMember")
    private Set<WorkspaceMember> workspaceMember;

    public AppUser(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
