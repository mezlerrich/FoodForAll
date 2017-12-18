package de.thbingen.android.foodforall.userInterface;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import de.thbingen.android.foodforall.R;
import de.thbingen.android.foodforall.userInterface.logicalRessources.Food;
import de.thbingen.android.foodforall.userInterface.logicalRessources.FoodAdapter;

public class SharingFoodMenu extends AppCompatActivity
{

    private Intent mainMenu;

    private List<Food> foodList;
    private Button backBtn;

    private RecyclerView recyclerView;
    private FoodAdapter foodAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharing_food_add_template);

        mainMenu = new Intent(this, FfaMainMenu.class);

        foodList = new ArrayList<>();
        foodAdapter = new FoodAdapter(foodList);

        //backBtn = (Button) findViewById(R.id.backBtn);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(foodAdapter);

        insertIntoView();
    }

    private void insertIntoView()
    {
        Food food = new Food("pizza", "Hauptspeise", 3);
        foodList.add(food);

        foodAdapter.notifyDataSetChanged();
    }

   /* private void setButtonListener()
    {
        backBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                startActivity(mainMenu);
            }
        });
    }*/
}
