package com.elijahsh.view;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.*;

/**
 * Navigation menu item.
 * User: elijahsh
 * Date: 12.08.12
 * Time: 18:30
 */
public class ListViewMenuItem implements MenuItem {
    /**
     * Used for the icon resource ID if this item does not have an icon
     */
    static final int NO_ICON = 0;

    /**
     * The icon's drawable which is only created as needed
     */
    private Drawable mIconDrawable;

    /**
     * The icon's resource ID which is used to get the Drawable when it is
     * needed (if the Drawable isn't already obtained--only one of the two is
     * needed).
     */
    private int mIconResId = NO_ICON;

    /**
     * The menu to which this item belongs
     */
    private ListViewMenu mMenu;

    private final int mId;
    private final int mGroup;
    private final int mCategoryOrder;
    private final int mOrdering;
    private CharSequence mTitle;
    private CharSequence mTitleCondensed;
    private Intent mIntent;
    private char mShortcutNumericChar;
    private char mShortcutAlphabeticChar;
    private int mShowAsAction = SHOW_AS_ACTION_WITH_TEXT; // If SHOW_AS_ACTION_NEVER then this is a group title

    public ListViewMenuItem(ListViewMenu menu, int group, int id, int categoryOrder, int ordering,
                            CharSequence title, int showAsAction) {

        mMenu = menu;
        mId = id;
        mGroup = group;
        mCategoryOrder = categoryOrder;
        mOrdering = ordering;
        mTitle = title;
        mShowAsAction = showAsAction;
    }

    @Override
    public int getItemId() {
        return mId;
    }

    @Override
    public int getGroupId() {
        return mGroup;
    }

    @Override
    public int getOrder() {
        return mCategoryOrder;
    }

    @Override
    public MenuItem setTitle(CharSequence title) {
        mTitle = title;

        //TODO mMenu.onItemsChanged(false);
        return this;
    }

    @Override
    public MenuItem setTitle(int title) {
        return setTitle(mMenu.getContext().getString(title));
    }

    @Override
    public CharSequence getTitle() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public MenuItem setTitleCondensed(CharSequence title) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public CharSequence getTitleCondensed() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public MenuItem setIcon(Drawable icon) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public MenuItem setIcon(int iconRes) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Drawable getIcon() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public MenuItem setIntent(Intent intent) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Intent getIntent() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public android.view.MenuItem setShortcut(char numericChar, char alphaChar) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public MenuItem setNumericShortcut(char numericChar) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public char getNumericShortcut() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public MenuItem setAlphabeticShortcut(char alphaChar) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public char getAlphabeticShortcut() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public MenuItem setCheckable(boolean checkable) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isCheckable() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public MenuItem setChecked(boolean checked) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isChecked() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public MenuItem setVisible(boolean visible) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isVisible() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public MenuItem setEnabled(boolean enabled) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }


    @Override
    public boolean isEnabled() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean hasSubMenu() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public SubMenu getSubMenu() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener menuItemClickListener) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setShowAsAction(int actionEnum) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public MenuItem setShowAsActionFlags(int actionEnum) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public MenuItem setActionView(View view) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public MenuItem setActionView(int resId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public View getActionView() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ActionProvider getActionProvider() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean expandActionView() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean collapseActionView() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isActionViewExpanded() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public MenuItem setOnActionExpandListener(OnActionExpandListener listener) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
