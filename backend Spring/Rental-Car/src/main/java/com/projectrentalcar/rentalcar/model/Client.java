package com.projectrentalcar.rentalcar.model;


import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    @NotEmpty(message = "Nome obrigatorio.")
    private String name;

    @Column(nullable = false, length = 11, unique = true)
    @NotNull(message = "CPF obrigatorio.")
    @CPF(message = "CPF inválido")
    private String cpf;

    @Column(nullable = false, length = 25)
    @NotNull(message = "Numero obrigatorio.")
    private String phoneNumber;

    @Column(length = 70, unique = true)
    @Email(message = "Email inválido")
    private String email;

    //@OneToOne
    //@JoinColumn(name = "adress_id")
    //private ClientAdress adress;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Client client = (Client) o;
        return id != null && Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
