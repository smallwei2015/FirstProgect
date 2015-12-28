package com.smallwei.firstprogect;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.smallwei.firstprogect.adapters.MyAdapter;
import com.smallwei.firstprogect.fragments.Circle_fragment;
import com.smallwei.firstprogect.fragments.News;
import com.smallwei.firstprogect.fragments.Personal_fragment;
import com.smallwei.firstprogect.fragments.Search_fragment;
import com.smallwei.firstprogect.fragments.Thing_fragment;
import com.smallwei.firstprogect.fragments.Tips_fragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle drawerToggle;
    FrameLayout container;
    FragmentManager supportFragmentManager;
    List<Fragment> fragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container= (FrameLayout) findViewById(R.id.container);

        fragments=new ArrayList<>();
        Thing_fragment thing=new Thing_fragment();
        fragments.add(thing);
        Circle_fragment circle=new Circle_fragment();
        fragments.add(circle);
        Search_fragment search=new Search_fragment();
        fragments.add(search);
        Tips_fragment tips=new Tips_fragment();
        fragments.add(tips);
        Personal_fragment personal=new Personal_fragment();
        fragments.add(personal);

        supportFragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container,fragments.get(0));
        fragmentTransaction.commit();

        drawerLayout= (DrawerLayout) findViewById(R.id.drawer);
        navigationView= (NavigationView) findViewById(R.id.navigator);
        navigationView.setOnClickListener(this);
        navigationView.setNavigationItemSelectedListener(this);

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, 0, 0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerToggle.syncState();

        //让drawer影响这个按钮
        drawerLayout.setDrawerListener(drawerToggle);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        drawerLayout.closeDrawer(GravityCompat.START);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        switch (itemId){
            case R.id.item_thing:
                fragmentTransaction.replace(R.id.container, fragments.get(0));
                break;
            case R.id.item_circle:
                fragmentTransaction.replace(R.id.container, fragments.get(1));
                break;
            case R.id.item_find:
                fragmentTransaction.replace(R.id.container, fragments.get(2));
                break;
            case R.id.item_tips:
                fragmentTransaction.replace(R.id.container, fragments.get(3));
                break;
            case R.id.item_me:
                fragmentTransaction.replace(R.id.container, fragments.get(4));
                break;
            case R.id.menu_setting:
                fragmentTransaction.replace(R.id.container,fragments.get(4));
                break;
            case R.id.menu_exit:
                final AlertDialog.Builder builder=new AlertDialog.Builder(this);
                builder.setIcon(R.mipmap.warning);
                builder.setTitle("Warning");
                builder.setMessage("确定离开？");
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ActivityCompat.finishAffinity(MainActivity.this);
                    }
                });
                builder.show();

                break;
        }
        fragmentTransaction.commit();
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
