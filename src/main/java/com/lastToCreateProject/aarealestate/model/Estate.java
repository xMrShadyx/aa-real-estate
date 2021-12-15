package com.lastToCreateProject.aarealestate.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "estates")
public class Estate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "floor_id", foreignKey = @ForeignKey(name = "fk_floor_id"))
    private Floor floor;

    @ManyToOne
    @JoinColumn(name = "city_id", foreignKey = @ForeignKey(name = "fk_city_id"))
    private City city;

    @Column
    private String description;

    @Embedded
    private Quadrature quadrature;

    @ManyToMany
    @JoinTable(
            name = "estate_estate_features",
            joinColumns = @JoinColumn(name = "estate_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "estate_feature_id", referencedColumnName = "id")
    )
    private Set<EstateFeature> estateFeatures;



}
