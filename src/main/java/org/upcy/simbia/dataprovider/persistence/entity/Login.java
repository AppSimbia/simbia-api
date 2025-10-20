package org.upcy.simbia.dataprovider.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "loginindustry")
public class Login {

    @Id
    @Column(name = "idloginindustry")
    private Long id;

    @Column(name = "cusername")
    private String userName;

    @Column(name = "cpwduuid")
    private String pwdUUID ;

    @Column(name = "cpwdhash")
    private String pwdHash;

    @Column(name = "cisfirstlogin")
    private String isFirstLogin;

    @Column(name = "dlastchange")
    private LocalDateTime lastChange;

    @Column(name = "cactive", nullable = false, length = 1)
    private String active;
}
