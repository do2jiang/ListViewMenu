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
    private final int TYPE_SEPARATOR = 0;
    private final int TYPE_ITEM = 1;
    private final int TYPE_COUNT = TYPE_ITEM + 1;

    private Context mContext;
    private LayoutInflater mInflater;

    public ListViewMenuAdapter(Context context, List<ListViewMenuItem> objects) {
        super(context, 0, objects);
        mContext = context;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public boolean isEnabled(int position) {
        return getItem(position).isEnabled();
    }

    static private class ViewHolder {
        public ImageView icon;
        public TextView title;
    }

    @Override
    public int getViewTypeCount() {
        return TYPE_COUNT;
    }

    @Override
    public int getItemViewType(int position) {
        return getItem(position).isEnabled() ? TYPE_ITEM : TYPE_SEPARATOR;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        ViewHolder viewHolder;
        int viewType = getItemViewType(position);
        if (rowView == null) {
            viewHolder = new ViewHolder();
            switch (viewType) {
                case TYPE_SEPARATOR:
                    rowView = mInflater.inflate(R.layout.view_separator_row, parent, false);
                    //viewHolder.icon = (ImageView) rowView.findViewById(R.id.navigation_icon);
                    viewHolder.title = (TextView) rowView.findViewById(R.id.separator_title);
                    rowView.setTag(viewHolder);
                    break;

                case TYPE_ITEM:
                    rowView = mInflater.inflate(R.layout.view_item_row, parent, false);
                    viewHolder.icon = (ImageView) rowView.findViewById(R.id.item_icon);
                    viewHolder.title = (TextView) rowView.findViewById(R.id.item_title);
                    rowView.setTag(viewHolder);
                    break;
            }

        } else {
            viewHolder = (ViewHolder) rowView.getTag();
        }

        if (viewHolder.icon != null)
            viewHolder.icon.setImageDrawable(getItem(position).getIcon());
        viewHolder.title.setText(getItem(position).getTitle());
        return rowView;
    }
}
