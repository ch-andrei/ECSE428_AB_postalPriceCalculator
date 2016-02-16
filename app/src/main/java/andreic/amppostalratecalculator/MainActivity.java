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
 * Created by AndreiCh on 2016-02-10.
 */
public class MainActivity extends AppCompatActivity implements ItemEnums {

    // declare UI fields
    protected Spinner destination_menu_spinner;
    protected EditText weight_field, length_field, depth_field, width_field;
    protected TextView postal_rate_field;

    // error flag
    protected boolean error_flag = false;

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
    protected void setUpUIelements() {
        // init text fields
        weight_field = (EditText) findViewById(R.id.enter_weight);
        length_field = (EditText) findViewById(R.id.enter_length);
        depth_field = (EditText) findViewById(R.id.enter_depth);
        width_field = (EditText) findViewById(R.id.enter_width);
        postal_rate_field = (TextView) findViewById(R.id.postal_rate_result);

        // init spinner and adapters
        destination_menu_spinner = (Spinner) findViewById(R.id.destination_spinner);
        ArrayAdapter<String> destination_menu_adapter = new CustomArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, ItemEnums.destinations);

        // link spinner and adapters
        destination_menu_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        destination_menu_spinner.setAdapter(destination_menu_adapter);
        destination_menu_spinner.setSelection(destination_menu_adapter.getCount()); //display hint
    }

    /**
     * calculates and displays postal rate based on inputs entered through UI. Handles errors and provides visual error feedback.
     */
    protected void computePostalRate() {

        // reset global error flag
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

        double postal_rate = 0;
        // all vars were init

        // get all required inputs from UI

        destination = destination_menu_spinner.getSelectedItem().toString();
        if (destination.equals(ItemEnums.destinations[destinations.length - 1])) {
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

        if (complete) {
            // compute postal rate
            postal_rate = computePostalRate(length, width, depth, weight, destination);
            Toast.makeText(MainActivity.this, "Computed rate!", Toast.LENGTH_SHORT).show();
            if (postal_rate != -1.0)
                postal_rate_field.setText("" + postal_rate + "$");
            else
                postal_rate_field.setText(getString(R.string.indvali_input_combination));
        } else {
            error_flag = true;
            if (focus != null) {
                focus.requestFocus();
            }
            Toast.makeText(MainActivity.this, "Could not compute rate!", Toast.LENGTH_SHORT).show();
            postal_rate_field.setText(getString(R.string.invalid_inputs));
        }
    }

    /**
     * computes final postal rate based on the inputs.
     *
     * @param weight
     * @param length
     * @param depth
     * @param width
     * @param destination
     * @return
     */
    protected static double computePostalRate(double length, double width, double depth, double weight, String destination) {
        String type;

        if (destination == null) {
            return -1.0;
        }

        // determine type
        type = "";
        if (140 <= length && length <= 380 &&
                90 <= width && width <= 270 &&
                0.18 <= depth && depth <= 20 &&
                2 <= weight && weight <= 500) {
            if (length <= 245 && width <= 156 && depth <= 5 && weight <= 50) {
                type = "Standard";
            } else {
                type = "Non-standard and Oversize";
            }

        }
        // TODO compute rate
        if (type.equals("Standard")) {
            if (140 <= length && length <= 245) {
                if (90 <= width && width <= 156) {
                    if (0.18 <= depth && depth <= 5) {
                        if (2 <= weight && weight <= 30) {
                            if (destination.equals("Canada")) {
                                return 1.00;
                            } else if (destination.equals("USA")) {
                                return 1.20;
                            } else if (destination.equals("International")) {
                                return 2.50;
                            }
                        } else {
                            if (30 < weight && weight <= 50) {
                                if (destination.equals("Canada")) {
                                    return 1.20;
                                } else if (destination.equals("USA")) {
                                    return 1.80;
                                } else if (destination.equals("International")) {
                                    return 3.60;
                                }
                            }
                        }
                    }
                }
            }
        } else if (type.equals("Non-standard and Oversize")) {
            if (140 <= length && length <= 380) {
                if (90 <= width && width <= 270) {
                    if (0.18 <= depth && depth <= 20) {
                        if (3 <= weight && weight <= 500) {
                            if (destination.equals("Canada")) {
                                if (3 <= weight && weight <= 100) {
                                    return 1.80;
                                } else if (100 < weight && weight <= 200) {
                                    return 2.95;
                                } else if (200 < weight && weight <= 300) {
                                    return 4.10;
                                } else if (300 < weight && weight <= 400) {
                                    return 4.70;
                                } else if (400 < weight && weight <= 500) {
                                    return 5.05;
                                }
                            } else if (destination.equals("USA")) {
                                if (3 <= weight && weight <= 100) {
                                    return 2.95;
                                } else if (100 < weight && weight <= 200) {
                                    return 5.15;
                                } else if (200 < weight && weight <= 500) {
                                    return 10.30;
                                }
                            } else if (destination.equals("International")) {
                                if (3 <= weight && weight <= 100) {
                                    return 5.90;
                                } else if (100 < weight && weight <= 200) {
                                    return 10.30;
                                } else if (200 < weight && weight <= 500) {
                                    return 20.60;
                                }
                            }
                        }
                    }
                }
            }
        }
        // else
        return -1.0;
    }
}
