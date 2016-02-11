package andreic.amppostalratecalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import andreic.amppostalratecalculator.Tools.CustomArrayAdapter;
import andreic.amppostalratecalculator.Tools.ItemEnums;

/**
 * Created by AndreiCH on 2016-02-10.
 */
public class MainActivity extends AppCompatActivity implements ItemEnums{

    // declare UI fields
    Spinner lettermail_menu_spinner, destination_menu_spinner;
    EditText weight_field, length_field, depth_field , width_field;
    TextView postal_rate_field;

    // error flag
    public boolean error_flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // init and link drop menus
        setUpUIelements();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computePostalRate();
            }
        });
    }

    /**
     * initialize and link all UI elements and fields
     */
    private void setUpUIelements() {
        // init text fields
        weight_field = (EditText) findViewById(R.id.enter_weight);
        length_field = (EditText) findViewById(R.id.enter_length);
        depth_field = (EditText) findViewById(R.id.enter_depth);
        width_field = (EditText) findViewById(R.id.enter_width);
        postal_rate_field = (TextView) findViewById(R.id.postal_rate_result);

        // init spinners and adapters
        lettermail_menu_spinner = (Spinner) findViewById(R.id.lettermail_type_spinner);
        ArrayAdapter<String> lettermail_menu_adapter = new CustomArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, ItemEnums.letter_types);

        destination_menu_spinner = (Spinner) findViewById(R.id.destination_spinner);
        ArrayAdapter<String> destination_menu_adapter = new CustomArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, ItemEnums.destinations);

        // link spinners and adapters
        lettermail_menu_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lettermail_menu_spinner.setAdapter(lettermail_menu_adapter);
        lettermail_menu_spinner.setSelection(lettermail_menu_adapter.getCount()); //display hint

        destination_menu_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        destination_menu_spinner.setAdapter(destination_menu_adapter);
        destination_menu_spinner.setSelection(destination_menu_adapter.getCount()); //display hint
    }

    private void computePostalRate() {

        // reset gloval error flag
        error_flag = false;

        // init vars and set to defaults
        String destination, type;
        destination = type = "";

        double weight, length, depth, width;
        weight = depth = length = width = 0;

        boolean complete, any_in, weight_in, length_in, depth_in, width_in;
        any_in = false;
        complete = weight_in = length_in = depth_in = width_in = true;

        View focus = null;
        // all vars were init

        // get all required inputs from UI

        type = lettermail_menu_spinner.getSelectedItem().toString();
        if (type.equals(ItemEnums.letter_types[letter_types.length-1])){
            // if user did not select anything
            focus = lettermail_menu_spinner;
            complete = false;
        }
        destination = destination_menu_spinner.getSelectedItem().toString();
        if (destination.equals(ItemEnums.destinations[destinations.length-1])){
            // if user did not select anything
            focus = destination_menu_spinner;
            complete = false;
        }
        try {
            weight = Double.valueOf(weight_field.getText().toString());
            any_in = true;
        } catch (Exception e) {
            focus = weight_field;
            weight_in = false;
        }
        try {
            length = Double.valueOf(length_field.getText().toString());
            any_in = true;
        } catch (Exception e) {
            focus = length_field;
            length_in = false;
        }
        try {
            depth = Double.valueOf(depth_field.getText().toString());
            any_in = true;
        } catch (Exception e) {
            focus = depth_field;
            depth_in = false;
        }
        try {
            width = Double.valueOf(width_field.getText().toString());
            any_in = true;
        } catch (Exception e) {
            focus = width_field;
            width_in = false;
        }

        // set text field errors if missing inputs
        if (any_in) {
            if (!weight_in) {
                weight_field.setError(getString(R.string.missing_field));
                complete = false;
            }
            if (!length_in) {
                length_field.setError(getString(R.string.missing_field));
                complete = false;
            }
            if (!depth_in) {
                depth_field.setError(getString(R.string.missing_field));
                complete = false;
            }
            if (!width_in) {
                width_field.setError(getString(R.string.missing_field));
                complete = false;
            }
        }

        double postal_rate = 0;

        if (complete){
            // compute postal rate
            postal_rate = computePostalRate(weight,length,depth,width,type,destination);
            Toast.makeText(MainActivity.this, "Computed rate!", Toast.LENGTH_SHORT).show();
            postal_rate_field.setText("" + postal_rate);
        }
        else {
            error_flag = true;
            if (focus != null) {
                focus.requestFocus();
            }
            postal_rate_field.setText(getString(R.string.invalid_inputs));
        }
    }

    private double computePostalRate(double weight, double length, double depth, double width, String type, String destination){
        return 1.0;
    }
}
