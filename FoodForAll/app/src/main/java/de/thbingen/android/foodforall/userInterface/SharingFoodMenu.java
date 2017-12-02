package de.thbingen.android.foodforall.userInterface;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import de.thbingen.android.foodforall.R;

public class SharingFoodMenu extends AppCompatActivity
{
    private Intent mainMenu;

    private Button backBtn;
    private Spinner dropDown, counterSpinner;

    private ArrayAdapter<CharSequence> foodTypes, numericArray;



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
        mainMenu = new Intent(this, FfaMainMenu.class);

        backBtn = (Button) findViewById(R.id.backBtn);

        dropDown = (Spinner) findViewById(R.id.spinnerArt);

        foodTypes = ArrayAdapter.createFromResource(this, R.array.food_type, R.layout.support_simple_spinner_dropdown_item);
        foodTypes.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        dropDown.setAdapter(foodTypes);
        numericArray = ArrayAdapter.createFromResource(this, R.array.count_portions, R.layout.support_simple_spinner_dropdown_item);
        numericArray.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        counterSpinner.setAdapter(numericArray);
    }

    private void setButtonListener()
    {
        backBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(mainMenu);
            }
        });
    }
}
