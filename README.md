ListViewMenu
============

Implementation of standard android.view.Menu interface for Sliding navigation UI pattern.

Usage
-----
Define standard android menu resource. Disabled (android:enabled="false") items will render as separators/headers.

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

