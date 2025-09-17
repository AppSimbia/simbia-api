package org.upcy.simbia.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "login")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLogin;

    @Column(name = "cUserName")
    private String userName;

    @Column(name = "cPwdUUID ")
    private String pwdUUID ;

//    @Column(name = "cPwdHash")
//    private String pwdHash;

    @Column(name = "cIsFirstLogin")
    private String isFirstLogin;

    @Column(name = "dLastChange")
    private Date lastChange;

    @Column(name = "dLastLogin")
    private Date lastLogin;

    @Column(name = "cActive", nullable = false, length = 1)
    private String active;
}
