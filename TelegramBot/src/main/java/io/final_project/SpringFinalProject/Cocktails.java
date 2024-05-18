package io.final_project.SpringFinalProject;

public class Cocktails extends Drinks {

    float alcohol;

    Cocktails(String name, String color, int price, float alcohol) {
        super(name, color, price);
        this.alcohol = alcohol;
    }

}
