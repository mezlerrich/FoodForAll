package de.thbingen.android.foodforall.userInterface;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import de.thbingen.android.foodforall.R;
import de.thbingen.android.foodforall.userInterface.logicalRessources.Food;
import de.thbingen.android.foodforall.userInterface.observer.FoodObserver;

public class SharingFoodAddTemplate extends AppCompatActivity
{
    private FoodObserver observer;

    private Intent sharingFoodMenu;

    private Button backBtn;
    private Button acceptBtn;
    private Spinner dropDown;
    private Spinner counterSpinner;

    private EditText editText;

    private ArrayAdapter<CharSequence> foodTypes;
    private ArrayAdapter<CharSequence> numericArray;

    //TODO inform Observer for changes

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharing_food_menu);

        initialize();
        setButtonListener();
    }

    private void initialize()
    {
        observer = new FoodObserver();

        sharingFoodMenu = new Intent(this, SharingFoodMenu.class);

        editText = (EditText) findViewById(R.id.editTextName);

        backBtn = (Button) findViewById(R.id.backBtn);
        acceptBtn = (Button) findViewById(R.id.acceptBtn);

        dropDown = (Spinner) findViewById(R.id.spinnerArt);
        counterSpinner = (Spinner) findViewById(R.id.spinnerCounter);

        foodTypes = ArrayAdapter.createFromResource(this, R.array.food_type, R.layout.support_simple_spinner_dropdown_item);
        foodTypes.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        dropDown.setAdapter(foodTypes);
        numericArray = ArrayAdapter.createFromResource(this, R.array.count_portions, R.layout.support_simple_spinner_dropdown_item);
        numericArray.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        counterSpinner.setAdapter(numericArray);
    }

    private void sendValue()
    {
        Food food = new Food(
                editText.getText().toString(),
                dropDown.getSelectedItem().toString(),
                Integer.parseInt(numericArray.getItem(0).toString())
        );
        observer.addFood(food);
    }

    private void setButtonListener()
    {
        backBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(sharingFoodMenu);
            }
        });
        acceptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendValue();
                startActivity(sharingFoodMenu);
            }
        });
    }
}
