package com.elijahsh.view;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: elijahsh
 * Date: 21.08.12
 * Time: 19:27
 */
public class ListViewMenuAdapter extends ArrayAdapter<ListViewMenuItem> {

    public ListViewMenuAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public ListViewMenuAdapter(Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public ListViewMenuAdapter(Context context, int textViewResourceId, ListViewMenuItem[] objects) {
        super(context, textViewResourceId, objects);
    }

    public ListViewMenuAdapter(Context context, int resource, int textViewResourceId, ListViewMenuItem[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public ListViewMenuAdapter(Context context, int textViewResourceId, List<ListViewMenuItem> objects) {
        super(context, textViewResourceId, objects);
    }

    public ListViewMenuAdapter(Context context, int resource, int textViewResourceId, List<ListViewMenuItem> objects) {
        super(context, resource, textViewResourceId, objects);
    }
}
