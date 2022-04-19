package com.audaz.audaz.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Fare implements Serializable {

    @Id
    @SequenceGenerator(name = "fare_sequence", sequenceName = "fare_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(nullable = false)
    private Boolean status;

    private Double value;

    private LocalDate createdAt;

    @ManyToOne
    @JoinColumn(name = "operator_id")
    private Operator operator;
}
