package de.thbingen.android.foodforall.userInterface.logicalRessources;

/**
 * Created by Richard on 04.12.2017.
 */

public class Food
{
    private String name;
    private String type;
    private int quantity;

    public Food(){
    }

    public Food(String name, String type, int quantity)
    {
        this.name = name;
        this.type = type;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
