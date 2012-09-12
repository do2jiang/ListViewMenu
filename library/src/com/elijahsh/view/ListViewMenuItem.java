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
    private static final int SHOW_AS_ACTION_MASK = SHOW_AS_ACTION_NEVER |
            SHOW_AS_ACTION_IF_ROOM |
            SHOW_AS_ACTION_ALWAYS;

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
    private boolean mVisible;
    private boolean mEnabled;
    private OnMenuItemClickListener mClickListener;
    private ContextMenu.ContextMenuInfo mMenuInfo;

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
        return mTitle;
    }

    @Override
    public MenuItem setTitleCondensed(CharSequence title) {
        mTitleCondensed = title;
        //TODO mMenu.onItemsChanged(false);
        return this;
    }

    @Override
    public CharSequence getTitleCondensed() {
        return mTitleCondensed;
    }

    @Override
    public MenuItem setIcon(Drawable icon) {
        mIconResId = NO_ICON;
        mIconDrawable = icon;

        //TODO mMenu.onItemsChanged(false);

        return this;
    }

    @Override
    public MenuItem setIcon(int iconRes) {
        mIconDrawable = null;
        mIconResId = iconRes;

        // If we have a view, we need to push the Drawable to them
        //TODO mMenu.onItemsChanged(false);

        return this;
    }

    @Override
    public Drawable getIcon() {
        if (mIconDrawable != null) {
            return mIconDrawable;
        }

        if (mIconResId != NO_ICON) {
            return mMenu.getResources().getDrawable(mIconResId);
        }

        return null;
    }

    @Override
    public MenuItem setIntent(Intent intent) {
        mIntent = intent;
        return this;
    }

    @Override
    public Intent getIntent() {
        return mIntent;
    }

    @Override
    public MenuItem setShortcut(char numericChar, char alphaChar) {
        mShortcutNumericChar = numericChar;
        mShortcutAlphabeticChar = Character.toLowerCase(alphaChar);

        //TODO mMenu.onItemsChanged(false);

        return this;
    }

    @Override
    public MenuItem setNumericShortcut(char numericChar) {
        if (mShortcutNumericChar == numericChar) return this;

        mShortcutNumericChar = numericChar;

        //TODO mMenu.onItemsChanged(false);

        return this;
    }

    @Override
    public char getNumericShortcut() {
        return mShortcutNumericChar;
    }

    @Override
    public MenuItem setAlphabeticShortcut(char alphaChar) {
        if (mShortcutAlphabeticChar == alphaChar) return this;

        mShortcutAlphabeticChar = Character.toLowerCase(alphaChar);

        //TODO mMenu.onItemsChanged(false);

        return this;
    }

    @Override
    public char getAlphabeticShortcut() {
        return mShortcutAlphabeticChar;
    }

    @Override
    public MenuItem setCheckable(boolean checkable) {
        return this;
    }

    @Override
    public boolean isCheckable() {
        return false;
    }

    @Override
    public MenuItem setChecked(boolean checked) {
        return this;
    }

    @Override
    public boolean isChecked() {
        return false;
    }

    @Override
    public MenuItem setVisible(boolean visible) {
        mVisible = visible;
        return this;
    }

    @Override
    public boolean isVisible() {
        return mVisible;
    }

    @Override
    public MenuItem setEnabled(boolean enabled) {
        mEnabled = enabled;
        return this;
    }

    @Override
    public boolean isEnabled() {
        return mEnabled;
    }

    @Override
    public boolean hasSubMenu() {
        return false;
    }

    @Override
    public SubMenu getSubMenu() {
        return null;
    }

    @Override
    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener menuItemClickListener) {
        mClickListener = menuItemClickListener;
        return this;
    }

    @Override
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return mMenuInfo;
    }

    @Override
    public void setShowAsAction(int actionEnum) {
        switch (actionEnum & SHOW_AS_ACTION_MASK) {
            case SHOW_AS_ACTION_ALWAYS:
            case SHOW_AS_ACTION_IF_ROOM:
            case SHOW_AS_ACTION_NEVER:
                // Looks good!
                break;

            default:
                // Mutually exclusive options selected!
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM,"
                        + " and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        mShowAsAction = actionEnum;
        //TODO mMenu.onItemActionRequestChanged(this);
    }

    @Override
    public MenuItem setShowAsActionFlags(int actionEnum) {
        setShowAsAction(actionEnum);
        return this;
    }

    @Override
    public MenuItem setActionView(View view) {
        return this;
    }

    @Override
    public MenuItem setActionView(int resId) {
        return this;
    }

    @Override
    public View getActionView() {
        return null;
    }

    @Override
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        return this;
    }

    @Override
    public ActionProvider getActionProvider() {
        return null;
    }

    @Override
    public boolean expandActionView() {
        return false;
    }

    @Override
    public boolean collapseActionView() {
        return false;
    }

    @Override
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override
    public MenuItem setOnActionExpandListener(OnActionExpandListener listener) {
        return this;
    }
}
