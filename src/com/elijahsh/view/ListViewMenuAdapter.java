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
    private LayoutInflater mInflater;

    public ListViewMenuAdapter(Context context, List<ListViewMenuItem> objects) {
        super(context, 0, objects);
        mContext = context;
        mLayoutResourceId = R.layout.view_navigation_row;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    static private class ViewHolder {
        public ImageView icon;
        public TextView title;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        ViewHolder viewHolder;
        if (rowView == null) {
            rowView = mInflater.inflate(mLayoutResourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.icon = (ImageView) rowView.findViewById(R.id.navigation_icon);
            viewHolder.title = (TextView) rowView.findViewById(R.id.navigation_title);
        } else {
            viewHolder = (ViewHolder)rowView.getTag();
        }

        viewHolder.icon.setImageDrawable(getItem(position).getIcon());
        viewHolder.title.setText(getItem(position).getTitle());
        return rowView;
    }
}
