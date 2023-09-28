package org.learning.java.springblogricette.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ricetta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String ingredientsList;
    private String timeOfPreparation;
    private int portions;
    private String ricepDescription;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIngredientsList() {
        return ingredientsList;
    }

    public void setIngredientsList(String ingredientsList) {
        this.ingredientsList = ingredientsList;
    }


    public String getTimeOfPreparation() {
        return timeOfPreparation;
    }

    public void setTimeOfPreparation(String timeOfPreparation) {
        this.timeOfPreparation = timeOfPreparation;
    }

    public int getPortions() {
        return portions;
    }

    public void setPortions(int portions) {
        this.portions = portions;
    }

    public String getRicepDescription() {
        return ricepDescription;
    }

    public void setRicepDescription(String ricepDescription) {
        this.ricepDescription = ricepDescription;
    }
}
