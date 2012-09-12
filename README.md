ListViewMenu
============

Implementation of standard android.view.Menu interface for Sliding navigation UI pattern. Sliding UI pattern realization
[SlidingMenu][1]
Usage
-----
Define standard android menu resource. Disabled (android:enabled="false") items will render as separators/headers.
```xml
<?xml version="1.0" encoding="utf-8"?>

<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:id="@+id/nav_home" android:icon="@drawable/ic_launcher" android:title="Main" android:enabled="false"/>
    <item android:id="@+id/nav_accounts" android:icon="@drawable/ic_launcher" android:title="Accounts"/>
    <item android:id="@+id/nav_categories" android:icon="@drawable/ic_launcher" android:title="Categories"/>
    <item android:id="@+id/nav_planning" android:icon="@drawable/ic_launcher" android:title="Planning"/>

    <item android:id="@+id/nav_home" android:icon="@drawable/ic_launcher" android:title="Test" android:enabled="false"/>
    <item android:id="@+id/nav_home" android:icon="@drawable/ic_launcher" android:title="Test"/>
    <item android:id="@+id/nav_home" android:icon="@drawable/ic_launcher" android:title="Test"/>
    <item android:id="@+id/nav_home" android:icon="@drawable/ic_launcher" android:title="Test"/>
    <item android:id="@+id/nav_home" android:icon="@drawable/ic_launcher" android:title="Test"/>
</menu>
```
To use ListViewMenu define it in your xml layouts like this:
```xml
<com.elijahsh.view.ListViewMenu xmlns:android="http://schemas.android.com/apk/res/android"
                                android:id="@+id/navigation_menu"
                                android:layout_width="fill_parent"
                                android:layout_height="fill_parent"
                                style="@style/ListViewMenu.Dark"/>
```

In activity add:
```java
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ListViewMenu navigationMenu = (ListViewMenu) findViewById(R.id.navigation_menu);
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.navigation, navigationMenu);
    navigationMenu.setMenuClickListener(new ListViewMenu.OnMenuClickListener() {
        @Override
        public void onClick(MenuItem menuItem) {
            // Standard menu click handler
        }
    });
}
```

License
=======

    Copyright 2012 Elijah Shlyaposhnikov

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

 [1]: https://github.com/jfeinstein10/SlidingMenu