package com.example.hindpolymers;

import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
//import android.widget.Toolbar;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private String[] mNavigationDrawerItemTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    Toolbar toolbar;
    private CharSequence drawerTitle;
    private CharSequence title;
    android.support.v7.app.ActionBarDrawerToggle mDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title = drawerTitle = getTitle();
        mNavigationDrawerItemTitles= getResources().getStringArray(R.array.navigation_drawer_items_array);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mDrawerList = findViewById(R.id.left_drawer);
        setupToolbar();

        NavigationDrawerDataModel[] drawerItem = new NavigationDrawerDataModel[6];
        drawerItem[0]= new NavigationDrawerDataModel(R.mipmap.ic_home,R.string.home);
        drawerItem[1] = new NavigationDrawerDataModel(R.mipmap.ic_gallery, R.string.company);
        drawerItem[2] = new NavigationDrawerDataModel(R.mipmap.ic_company, R.string.gallery);
        drawerItem[3] = new NavigationDrawerDataModel(R.mipmap.ic_usercorner, R.string.user_corner);
        drawerItem[4] = new NavigationDrawerDataModel(R.mipmap.ic_aboutus, R.string.about_us);
        drawerItem[5] = new NavigationDrawerDataModel(R.mipmap.ic_contactus, R.string.contact_us);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);

        NavigationDrawerAdapter adapter = new NavigationDrawerAdapter(this, R.layout.nav_drawer_list_items,drawerItem);
        mDrawerList.setAdapter((ListAdapter) adapter);
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        setupDrawerToggle();

        Fragment fm = new ProductsFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_placeholder, fm).commit();


    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }

    }

    private void selectItem(int position) {

        Fragment fragment = null;

        switch (position) {

            case 0:
                fragment = new ProductsFragment();
                break;
            case 1:
                fragment = new CompanyFragment();
                break;
            case 2:
               fragment = new GalleryFragment();
                break;
            case 3:
                fragment = new UserCornerFragment();
                break;
            case 4:
               fragment = new AboutUsFragment();
                break;
            case 5:
               fragment = new ContactUsFragment();
                break;

            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment_placeholder, fragment).commit();

            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(mNavigationDrawerItemTitles[position]);
            mDrawerLayout.closeDrawer(mDrawerList);

        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setTitle(CharSequence title) {
        title = title;
        getSupportActionBar().setTitle(title);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    void setupToolbar(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    void setupDrawerToggle(){
        mDrawerToggle = new android.support.v7.app.ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.app_name, R.string.app_name);
        //This is necessary to change the icon of the Drawer Toggle upon state change.
        mDrawerToggle.syncState();
    }


}
