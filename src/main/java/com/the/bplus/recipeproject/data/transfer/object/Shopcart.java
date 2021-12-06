
package com.the.bplus.recipeproject.data.transfer.object;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.*;

import javax.persistence.*;

import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Shopcart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sc_id;
    private Integer it_price;
    private String it_name;
    private Integer it_qty;
    private String userid;
    private Integer ingredient;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shopcart")
    private List<Shopcart> shopcarts;

    @ManyToOne
    @JoinColumn(name = "shopcart_sc_id")
    private Shopcart shopcart;

}