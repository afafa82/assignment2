/*********************************************************************************
 * Project: <Recipe Spring Boot Application>
 * Assignment: < assignment 2 >
 * Author(s): < Youngil Kim >
 * Student Number: <101221938>
 * Date: 2021-12-04
 * Description: < Youngil made favourite Recipes datas>
 *********************************************************************************/
package com.the.bplus.recipeproject.data.transfer.object;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.*;

import javax.persistence.*;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class FavouriteRecipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fr_id;
    private String r_description;
    private String r_prepTime;
    private String r_cookTime;
    private String userid;
    private String r_servings;

    private Integer recipe;

}