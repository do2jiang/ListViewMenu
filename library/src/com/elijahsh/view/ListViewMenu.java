package com.elijahsh.view;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.view.*;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Navigation menu
 * User: elijahsh
 * Date: 11.08.12
 * Time: 21:43
 */

public class ListViewMenu extends ListView implements Menu {

    public static interface OnMenuClickListener  {
        void onClick(MenuItem menuItem);
    }

    private Context mContext;
    private Resources mResources;
    private OnMenuClickListener mMenuClickListener;
    private OnItemClickListener mListViewClickListener = new OnItemClickListener() {
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            Log.d("Nav", "Click!");
            if (mMenuClickListener != null) {
                mMenuClickListener.onClick(getItem(position));
            }
        }
    };

    /**
     * Default value for how added items should show in the action list.
     */
    private int mDefaultShowAsAction = MenuItem.SHOW_AS_ACTION_NEVER;

    /**
     * Contains all of the items for this menu
     */
    private ArrayList<ListViewMenuItem> mItems;

    private void initialize(Context context) {
        mContext = context;
        mResources = context.getResources();

        mItems = new ArrayList<ListViewMenuItem>();
        setAdapter(new ListViewMenuAdapter(context, mItems));

        setOnItemClickListener(mListViewClickListener);
    }

    public ListViewMenu(Context context) {
        super(context);
        initialize(context);
    }

    public ListViewMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }

    public ListViewMenu(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initialize(context);
    }

    /**
     * Adds an item to the menu.  The other add methods funnel to this.
     */
    private MenuItem addInternal(int group, int id, int categoryOrder, CharSequence title) {
        final ListViewMenuItem item = new ListViewMenuItem(this, group, id, categoryOrder, 0, title, MenuItem.SHOW_AS_ACTION_ALWAYS);

        mItems.add(item);

        //TODO onItemsChanged(true);

        return item;
    }

    @Override
    public MenuItem add(CharSequence title) {
        return addInternal(0, 0, 0, title);
    }

    @Override
    public MenuItem add(int titleRes) {
        return addInternal(0, 0, 0, mResources.getString(titleRes));
    }

    @Override
    public MenuItem add(int groupId, int itemId, int order, CharSequence title) {
        return addInternal(groupId, itemId, order, title);
    }

    @Override
    public MenuItem add(int groupId, int itemId, int order, int titleRes) {
        return addInternal(groupId, itemId, order, mResources.getString(titleRes));
    }

    @Override
    public SubMenu addSubMenu(CharSequence title) {
        //TODO Add sub menus support
        throw new UnsupportedOperationException();
    }

    @Override
    public SubMenu addSubMenu(int titleRes) {
        throw new UnsupportedOperationException();
    }

    @Override
    public SubMenu addSubMenu(int groupId, int itemId, int order, CharSequence title) {
        throw new UnsupportedOperationException();
    }

    @Override
    public SubMenu addSubMenu(int groupId, int itemId, int order, int titleRes) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int addIntentOptions(int groupId, int itemId, int order, ComponentName caller, Intent[] specifics, Intent intent, int flags, MenuItem[] outSpecificItems) {
        //TODO implement intent options
        return 0;
    }

    @Override
    public void removeItem(int id) {
        mItems.remove(id);
    }

    @Override
    public void removeGroup(int groupId) {
        //TODO Add groups support
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        mItems.clear();
    }

    @Override
    public void setGroupCheckable(int group, boolean checkable, boolean exclusive) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setGroupVisible(int group, boolean visible) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setGroupEnabled(int group, boolean enabled) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasVisibleItems() {
        return true;
    }

    @Override
    public MenuItem findItem(int id) {
        final int size = size();
        for (int i = 0; i < size; i++) {
            ListViewMenuItem item = mItems.get(i);
            if (item.getItemId() == id) {
                return item;
            } else if (item.hasSubMenu()) {
                MenuItem possibleItem = item.getSubMenu().findItem(id);

                if (possibleItem != null) {
                    return possibleItem;
                }
            }
        }

        return null;
    }

    @Override
    public int size() {
        return mItems.size();
    }

    @Override
    public MenuItem getItem(int index) {
        return mItems.get(index);
    }

    @Override
    public void close() {
        // Do nothing.
    }

    @Override
    public boolean performShortcut(int keyCode, KeyEvent event, int flags) {
        //TODO Add shortcuts support
        return false;
    }

    @Override
    public boolean isShortcutKey(int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    public boolean performIdentifierAction(int id, int flags) {
        return false;
    }

    @Override
    public void setQwertyMode(boolean isQwerty) {
        // Do nothing.
    }

    public OnMenuClickListener getMenuClickListener() {
        return mMenuClickListener;
    }

    public void setMenuClickListener(OnMenuClickListener clickListener) {
        this.mMenuClickListener = clickListener;
    }
}
