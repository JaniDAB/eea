package com.janith.eea.Model;

import com.janith.eea.Util.UserTypeUtil;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="USERROLE")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    @Getter
    @Setter
    private Integer roleId;

    @Column(name = "role_name")
    @Getter
    @Setter
        private UserTypeUtil roleName;

    @Getter
    @Setter
    @OneToMany(mappedBy ="role")
    private List<User> userList;
}

