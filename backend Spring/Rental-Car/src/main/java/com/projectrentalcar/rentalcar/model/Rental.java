//package com.projectrentalcar.rentalcar.model;
//
//
//import com.fasterxml.jackson.annotation.JsonFormat;
//import lombok.*;
//import org.hibernate.Hibernate;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//import java.util.Objects;
//
//@Getter
//@Setter
//@ToString
//@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//public class Rental {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @OneToOne
//    @JoinColumn(name = "client_id")
//    private Client client;
//
//    @OneToOne
//    @JoinColumn(name = "car_rented_id")
//    private Car carRented;
//
//    @Column(nullable = false)
//    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
//    private LocalDateTime startAt;
//
//    @Column(nullable = false)
//    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
//    private LocalDateTime finishAt;
//
//    private float finalPrice;
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
//        Rental rental = (Rental) o;
//        return id != null && Objects.equals(id, rental.id);
//    }
//
//    @Override
//    public int hashCode() {
//        return getClass().hashCode();
//    }
//}
