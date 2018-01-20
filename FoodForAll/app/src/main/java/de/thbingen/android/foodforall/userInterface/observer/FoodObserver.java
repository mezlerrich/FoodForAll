package de.thbingen.android.foodforall.userInterface.observer;

import java.util.ArrayList;
import java.util.List;

import de.thbingen.android.foodforall.userInterface.logicalRessources.Food;

/**
 * Created by Richard on 20.01.2018.
 */

public class FoodObserver
{
    private static List<Food> foodList = new ArrayList<>();

    public void addFood(Food food)
    {
        foodList.add(food);
    }

    public Food getFood(int i)
    {
        return  foodList.get(i);
    }

    public List<Food> getList()
    {
        return foodList;
    }
}
