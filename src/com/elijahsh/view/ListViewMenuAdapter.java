package com.elijahsh.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.elijahsh.view.listviewmenu.R;

import java.util.List;

/**
 * ListView menu ArrayAdapter.
 * User: elijahsh
 * Date: 21.08.12
 * Time: 19:27
 */
public class ListViewMenuAdapter extends ArrayAdapter<ListViewMenuItem> {
    private Context mContext;
    private int mLayoutResourceId;

    private void initialize(Context context, int viewResourceId) {
        mContext = context;
        mLayoutResourceId = R.layout.view_navigation_row;
    }

    public ListViewMenuAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
        initialize(context, textViewResourceId);
    }

    public ListViewMenuAdapter(Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
        initialize(context, textViewResourceId);
    }

    public ListViewMenuAdapter(Context context, int textViewResourceId, ListViewMenuItem[] objects) {
        super(context, textViewResourceId, objects);
        initialize(context, textViewResourceId);
    }

    public ListViewMenuAdapter(Context context, int resource, int textViewResourceId, ListViewMenuItem[] objects) {
        super(context, resource, textViewResourceId, objects);
        initialize(context, textViewResourceId);
    }

    public ListViewMenuAdapter(Context context, int textViewResourceId, List<ListViewMenuItem> objects) {
        super(context, textViewResourceId, objects);
        initialize(context, textViewResourceId);
    }

    public ListViewMenuAdapter(Context context, int resource, int textViewResourceId, List<ListViewMenuItem> objects) {
        super(context, resource, textViewResourceId, objects);
        initialize(context, textViewResourceId);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        if (rowView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(mLayoutResourceId, parent, false);
        } else {

        }

        ImageView icon = (ImageView) rowView.findViewById(R.id.navigation_icon);
        TextView title = (TextView) rowView.findViewById(R.id.navigation_title);

        icon.setImageDrawable(getItem(position).getIcon());
        title.setText(getItem(position).getTitle());
        return rowView;
    }
}
