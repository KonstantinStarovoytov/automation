package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "message")
public class MessageModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false)
    private Long messageId;

    @Column(name = "filename")
    private String uploadFilePath;

    @Column(name = "text", length = 2048, nullable = false)
    private String messageBody;

    @Column(name = "user_id", insertable = false, updatable = false)
    private Long userId;

    @ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn (name = "user_id")
    private UserModel owner;
}
