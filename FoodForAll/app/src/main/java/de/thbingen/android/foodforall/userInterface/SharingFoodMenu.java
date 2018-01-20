package de.thbingen.android.foodforall.userInterface;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
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
import java.util.Observable;
import java.util.Observer;

import de.thbingen.android.foodforall.R;
import de.thbingen.android.foodforall.userInterface.logicalRessources.Food;
import de.thbingen.android.foodforall.userInterface.logicalRessources.FoodAdapter;
import de.thbingen.android.foodforall.userInterface.observer.FoodObserver;

public class SharingFoodMenu extends AppCompatActivity implements Observer
{

    private Intent mainMenu;
    private Intent addFoodTemplate;

    private FoodObserver foodList;
    private Button backBtn;
    private FloatingActionButton actionButton;

    private RecyclerView recyclerView;
    private FoodAdapter foodAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharing_food_add_template);

        initialize();

        setButtonListener();
    }


    private void initialize()
    {
        mainMenu = new Intent(this, FfaMainMenu.class);
        addFoodTemplate = new Intent(this, SharingFoodAddTemplate.class);

        foodList = new FoodObserver();

        actionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);

        foodAdapter = new FoodAdapter(foodList.getList());

        //backBtn = (Button) findViewById(R.id.backBtn);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(foodAdapter);
    }

    public void insertIntoView(Food food)
    {
        Food test = new Food("pizza", "Hauptspeise", 3);
        foodList.addFood(test);

        foodList.addFood(food);

        foodAdapter.notifyDataSetChanged();
    }

    @Override
    public void update(Observable observable, Object data)
    {
        foodAdapter.notifyDataSetChanged();
    }

    public void update()
    {
        foodAdapter.notifyDataSetChanged();
    }

    private void setButtonListener()
    {
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(addFoodTemplate);
            }
        });
    }
}
