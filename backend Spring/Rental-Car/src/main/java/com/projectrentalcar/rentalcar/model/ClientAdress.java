//package com.projectrentalcar.rentalcar.model;
//
//import lombok.*;
//import org.hibernate.Hibernate;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//import java.util.Objects;
//
//@Getter
//@Setter
//@ToString
//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//public class ClientAdress {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false, length = 50)
//    @NotNull(message = "Endereço obrigatorio.")
//    private String street;
//
//    @Column(nullable = false, length = 8)
//    @NotNull(message = "CEP obrigatorio.")
//    private Long cep;
//
//    @Column(nullable = false, length = 50)
//    @NotNull(message = "Bairro obrigatorio.")
//    private String district;
//
//    @Column(nullable = false, length = 25)
//    @NotNull(message = "Cidade obrigatoria.")
//    private String city;
//
//    @Column(nullable = false, length = 5)
//    @NotNull(message = "Numero de logradouro obrigatorio.")
//    private int houseNumber;
//
//    @Column(length = 200)
//    private String complement;
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
//        ClientAdress that = (ClientAdress) o;
//        return id != null && Objects.equals(id, that.id);
//    }
//
//    @Override
//    public int hashCode() {
//        return getClass().hashCode();
//    }
//}
