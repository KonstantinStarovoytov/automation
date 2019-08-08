package entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_role")
public class UserRole {

    @Column(name = "user_id", nullable = false, insertable = false, updatable = false)
    private Long userId;

    @Id
    @Column(name="roles")
    private String roles;

    @ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn (name = "user_id")
    private UserModel model;
}