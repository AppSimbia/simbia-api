package org.upcy.simbia.dataprovider.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
