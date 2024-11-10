package com.getyourguide.demo.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Double price;

    private String currency;

    private Double rating;

    private Boolean specialOffer;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
}
