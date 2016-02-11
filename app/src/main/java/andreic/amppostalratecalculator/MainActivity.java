package andreic.amppostalratecalculator;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import andreic.amppostalratecalculator.Tools.CustomArrayAdapter;


import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computePostalRate();
            }
        });

        // init and link drop menus
        setUpDropMenus();


    }

    protected void setUpDropMenus(){
        // init spinners and adapters
        Spinner lettermail_type_spinner = (Spinner) findViewById(R.id.lettermail_type_spinner);
        String[] lettermail_menu_items = new String[]{"Standard", "Non-standard and Oversize","Select a lettermail type"};
        ArrayAdapter<String> lettermail_menu_adapter = new CustomArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, lettermail_menu_items);

        Spinner destination_menu_spinner = (Spinner) findViewById(R.id.destination_spinner);
        String[] destination_menu_items = new String[]{"Canada", "USA", "International", "Select a destination"};
        ArrayAdapter<String> destination_menu_adapter = new CustomArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, destination_menu_items);

        // link spinners and adapters
        lettermail_menu_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); ;
        lettermail_type_spinner.setAdapter(lettermail_menu_adapter);
        lettermail_type_spinner.setSelection(lettermail_menu_adapter.getCount()); //display hint

        destination_menu_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        destination_menu_spinner.setAdapter(destination_menu_adapter);
        destination_menu_spinner.setSelection(destination_menu_adapter.getCount()); //display hint
    }

    protected void computePostalRate(){

    }
}
