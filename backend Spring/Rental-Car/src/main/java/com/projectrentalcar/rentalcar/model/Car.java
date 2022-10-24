package com.projectrentalcar.rentalcar.model;


import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    @NotNull(message = "Marca obrigatoria.")
    private String brand;

    @Column(nullable = false, length = 20)
    @NotNull(message = "Modelo obrigatorio.")
    private String model;

    private String numOfDoors;

//    @Column(columnDefinition = "TINYINT")
//    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean isAvailable;

    @Column(nullable = false)
    @NotNull(message = "Valor obrigatorio.")
    private float priceOfHour;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Car car = (Car) o;
        return id != null && Objects.equals(id, car.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
