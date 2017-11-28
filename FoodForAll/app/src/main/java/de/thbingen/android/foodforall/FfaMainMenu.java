package de.thbingen.android.foodforall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class FfaMainMenu extends AppCompatActivity
{
    /**
     * An array of buttons, to get them from the main menu.
     */
    private Button[] _mainMenuBtns;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ffa_main_menu);

        initializeButtons();
    }

    /**
     * Initialize the buttons from the main menu.
     */
    private void initializeButtons()
    {
        _mainMenuBtns = new Button[] {
                (Button)findViewById(R.id.sharedBtn),
                (Button)findViewById(R.id.mapBtn),
                (Button)findViewById(R.id.carteBtn),
                (Button)findViewById(R.id.messageBtn)
        };

    }
}
