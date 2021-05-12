package com.janith.eea.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "USER", uniqueConstraints = @UniqueConstraint(columnNames = "user_name"))
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Integer userId;

    @Column(name = "user_name")
    @Getter
    @Setter
    private String username;

    @Column(name = "first_name")
    @Getter
    @Setter
    private String firstname;

    @Column(name = "last_name")
    @Getter
    @Setter
    private String lastname;

    @Column(name = "email")
    @Getter
    @Setter
    private String email;

    @Column(name = "password")
    @Getter
    @Setter
    private String password;


    @Column(name = "mobile")
    @Getter
    @Setter
    private String mobile;

    @Column(name = "date_of_birth")
    @Getter
    @Setter
    private String dateOfBirth;

    @Column(name = "gender")
    @Getter
    @Setter
    private String gender;


//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable
//            (
//                    name = "user_role", joinColumns = @JoinColumn(
//                    name = "user_id", referencedColumnName = "id")
//                    , inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
//            )

@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE , CascadeType.REFRESH ,CascadeType.PERSIST})
@JoinColumn(name = "role_id",  nullable = false)
@Setter
@Getter
    private UserRole role;

@ManyToOne
@JoinColumn(name = "batch_id")
@Setter
@Getter
private Batch batch;


    public User() {
    }
}
