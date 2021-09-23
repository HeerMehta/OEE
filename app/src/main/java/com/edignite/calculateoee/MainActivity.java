package com.edignite.calculateoee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.edignite.calculateoee.R;
import com.edignite.calculateoee.ui.calculateoee.GalleryFragment;
import com.edignite.calculateoee.ui.calculateoee.ResultActivity;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.edignite.calculateoee.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;




    public static final String  EXTRA_HRS = "com.edignite.calculateoee.extra.TOTALHRS";
    public static final String  EXTRA_WORKEDHRS = "com.edignite.calculateoee.WORKEDHRS";
    public static final String  EXTRA_MAJORTL = "com.edignite.calculateoee.extra.MAJORTL";
    public static final String  EXTRA_MINORTL = "com.edignite.calculateoee.MINORTL";
    public static final String  EXTRA_RWTIME = "com.edignite.calculateoee.RWTIME";

    protected void ClickButton1() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }

        });


        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_calcoee, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();

    }





    public void clickButton(View view) {
        int totalhrs = Integer.parseInt(findViewById(R.id.totalhrs).toString());
        int workedhrs = Integer.parseInt(findViewById(R.id.workedhrs).toString());
        int majortl = Integer.parseInt(findViewById(R.id.majortl).toString());
        int minortl = Integer.parseInt(findViewById(R.id.minortl).toString());
        int rwtime = Integer.parseInt(findViewById(R.id.rwtime).toString());

        Intent intent = new Intent(this, ResultActivity.class);

        intent.putExtra(EXTRA_HRS, totalhrs);
        intent.putExtra(EXTRA_WORKEDHRS, workedhrs);
        intent.putExtra(EXTRA_MAJORTL, majortl);
        intent.putExtra(EXTRA_MINORTL, minortl);
        intent.putExtra(EXTRA_RWTIME, rwtime);

        startActivity(intent);

    }


}