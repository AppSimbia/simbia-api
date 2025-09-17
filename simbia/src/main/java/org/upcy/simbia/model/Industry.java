package org.upcy.simbia.model;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.validator.constraints.br.CNPJ;

@Data
@Entity
@Table(name = "Industry")
public class Industry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private IndustryType industryType;

    @ManyToOne
    private Plan plan;

    @ManyToOne
    private Login login;

    @CNPJ
    @Column(name = "cCNPJ")
    private String cnpj;

    @Column(name = "cIndustryName")
    private String industryName;

    @Column(name = "cDescription")
    private String description;

    @Column(name = "cContactMail")
    private String contactMail;

    @Column(name = "cCEP")
    private String cep;

    @Column(name = "cCity")
    private String city;

    @Column(name = "cState")
    private String state;

    @Column(name = "cImage")
    private String image;

//    @Column(name = "nLatitude")
//    private BigDecimal latitude;
//
//    @Column(name = "nLongitude")
//    private BigDecimal longitude;

    @Column(name = "cActive", nullable = false, length = 1)
    private String active;
}
