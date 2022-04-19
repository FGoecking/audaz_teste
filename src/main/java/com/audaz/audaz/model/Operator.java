package com.audaz.audaz.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Builder
@Getter
@Setter
@Entity
@Table(name = "operator")
@AllArgsConstructor
@NoArgsConstructor
public class Operator implements Serializable {

    @Id
    @SequenceGenerator(name = "operator_sequece", sequenceName = "operator_sequece", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String code;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "operator", fetch = FetchType.LAZY)
    private List<Fare> fareList;
}
