package com.example.hindpolymers;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
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


    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private FloatingActionButton fabMail;
    android.support.v7.app.ActionBarDrawerToggle drawerToggle;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        Fragment fragment = new ProductsFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_placeholder, fragment,null).commit();


        fabMail = findViewById(R.id.fab_mail);
        fabMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new SendMessageFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_placeholder, fragment,null).addToBackStack(null).commit();


            }
        });


        drawerLayout.addDrawerListener(drawerToggle);
        setupDrawerToggle();
        /*getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);*/
        navigationView = findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment;
                switch (menuItem.getItemId()) {
                    case R.id.nav_home_fragment:
                        menuItem.setChecked(true);
                        fragment = new ProductsFragment();
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.fragment_placeholder, fragment).addToBackStack(null).commit();
                        break;
                    case R.id.nav_company_fragment:
                        menuItem.setChecked(true);
                        fragment = new CompanyFragment();
                        FragmentManager fragmentManager1 = getSupportFragmentManager();
                        fragmentManager1.beginTransaction().replace(R.id.fragment_placeholder, fragment).addToBackStack(null).commit();
                        break;
                    case R.id.nav_gallery_fragment:
                        menuItem.setChecked(true);
                        fragment = new GalleryFragment();
                        FragmentManager fragmentManager2 = getSupportFragmentManager();
                        fragmentManager2.beginTransaction().replace(R.id.fragment_placeholder, fragment).addToBackStack(null).commit();
                        break;
                    case R.id.nav_products_fragment:
                        menuItem.setChecked(true);
                        fragment = new ProductsFragment();
                        FragmentManager fragmentManager3 = getSupportFragmentManager();
                        fragmentManager3.beginTransaction().replace(R.id.fragment_placeholder, fragment).commit();
                        break;
                    case R.id.nav_usercorner_fragment:
                        menuItem.setChecked(true);
                        fragment = new UserCornerFragment();
                        FragmentManager fragmentManager4 = getSupportFragmentManager();
                        fragmentManager4.beginTransaction().replace(R.id.fragment_placeholder, fragment).addToBackStack(null).commit();
                        break;
                    case R.id.nav_aboutus_fragment:
                        menuItem.setChecked(true);
                        fragment = new AboutUsFragment();
                        FragmentManager fragmentManager5 = getSupportFragmentManager();
                        fragmentManager5.beginTransaction().replace(R.id.fragment_placeholder, fragment).addToBackStack(null).commit();
                        break;
                    case R.id.nav_contactus_fragment:
                        menuItem.setChecked(true);
                        fragment = new ContactUsFragment();
                        FragmentManager fragmentManager6 = getSupportFragmentManager();
                        fragmentManager6.beginTransaction().replace(R.id.fragment_placeholder, fragment).addToBackStack(null).commit();
                        break;
                    default:
                        fragment = new ProductsFragment();

                }

                // Insert the fragment by replacing any existing fragment


                // Highlight the selected item has been done by NavigationView

                // Set action bar title
                setTitle(menuItem.getTitle());
                // Close the navigation drawer
                drawerLayout.closeDrawers();

                return false;
            }
        });


    }






    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
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
        //drawerToggle.syncState();
    }





    void setupDrawerToggle(){
        drawerToggle = new android.support.v7.app.ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.app_name, R.string.app_name);
        //This is necessary to change the icon of the Drawer Toggle upon state change.
        drawerToggle.syncState();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }


    }


}
