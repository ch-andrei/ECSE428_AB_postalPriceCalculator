package andreic.amppostalratecalculator.Tools;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Custom array adapter to be used with a spinner for UI. Allows for displaying of a hint to the user prior to item selection.
 * Created by Andrei-Ch on 2016-02-10.
 */
public class CustomArrayAdapter extends ArrayAdapter {

    /**
     * basic constructor
     * @param context
     * @param resource
     * @param objects
     */
    public CustomArrayAdapter(Context context, int resource, Object[] objects) {
        super(context, resource, objects);
    }

    @Override
    public int getCount() {
        return super.getCount()-1; // you dont display last item. It is used as hint.
    }
}
