package com.the.bplus.recipeproject.data.transfer.object;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String amount;

    @ManyToOne
    @JoinColumn(name="recipeid", insertable=false, updatable=false)
    private Recipe recipe;

    private Integer recipeid;


    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;


}