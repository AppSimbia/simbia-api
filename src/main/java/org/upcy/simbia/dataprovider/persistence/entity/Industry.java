    package org.upcy.simbia.dataprovider.persistence.entity;


    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Builder;
    import lombok.Data;
    import lombok.NoArgsConstructor;
    import org.hibernate.validator.constraints.br.CNPJ;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Entity
    @Table(name = "industry")
    public class Industry {

        @Id
        @Column(name = "idindustry")
        private Long id;

        @ManyToOne
        @JoinColumn(name = "idindustrytype")
        private IndustryType industryType;

        @ManyToOne
        @JoinColumn(name = "idplan")
        private Plan plan;

        @ManyToOne
        @JoinColumn(name = "idloginindustry")
        private Login login;

        @Column(name = "ccnpj")
        private String cnpj;

        @Column(name = "cindustryname")
        private String industryName;

        @Column(name = "cdescription")
        private String description;

        @Column(name = "ccontactmail")
        private String contactMail;

        @Column(name = "ccep")
        private String cep;

        @Column(name = "ccity")
        private String city;

        @Column(name = "cstate")
        private String state;

        @Column(name = "cimage")
        private String image;

        @Column(name = "cactive", nullable = false, length = 1)
        private String active;
    }
