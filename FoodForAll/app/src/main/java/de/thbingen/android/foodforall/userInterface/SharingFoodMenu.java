package de.thbingen.android.foodforall.userInterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import de.thbingen.android.foodforall.R;
import de.thbingen.android.foodforall.userInterface.logicalRessources.Food;
import de.thbingen.android.foodforall.userInterface.logicalRessources.FoodAdapter;

public class SharingFoodMenu extends AppCompatActivity
{

    private List<Food> foodList;
    private Button backBtn;

    private RecyclerView recyclerView;
    private FoodAdapter foodAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharing_food_add_template);

        foodList = new ArrayList<>();
        foodAdapter = new FoodAdapter(foodList);

        backBtn = (Button) findViewById(R.id.backBtn);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

    }
}
