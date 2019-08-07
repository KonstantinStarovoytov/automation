package entity;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "usr")
public class UserModel {

    @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY)
    private Set<String> roles;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id", nullable = false)
    private Long id;

    @Column (name = "activation_code")
    public String activationCode;

    @Column (name = "active", nullable = false)
    public boolean isActivate;

    @Column (name = "email", nullable = true)
    public String email;

    @Column (name = "password", nullable = false)
    public String password;

    @Column (name = "username", nullable = false)
    public String username;
}
