package de.thbingen.android.foodforall.userInterface;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import de.thbingen.android.foodforall.R;

public class FfaMainMenu extends AppCompatActivity implements View.OnClickListener
{
    private Intent[] menuIntents;
    /**
     * An array of buttons, to get them from the main menu.
     */
    private Button[] _mainMenuBtns;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ffa_main_menu);

        initialize();
    }

    /**
     * Initialize the buttons from the main menu.
     */
    private void initialize()
    {
        _mainMenuBtns = new Button[] {
                (Button)findViewById(R.id.sharedBtn),
                (Button)findViewById(R.id.mapBtn),
                (Button)findViewById(R.id.carteBtn),
                (Button)findViewById(R.id.messageBtn)
        };
        menuIntents = new Intent[] {
                new Intent(this, SharingFoodMenu.class)
        };

    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId()) {
            case R.id.sharedBtn:
                Toast.makeText(this, "Hello World!", Toast.LENGTH_SHORT);
                startActivity(menuIntents[0]);
                break;
            case R.id.mapBtn:
                break;
            case R.id.carteBtn:
                break;
            case R.id.messageBtn:
                break;
        }
    }
}
