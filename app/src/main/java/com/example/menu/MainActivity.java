package com.example.menu;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.navigation.NavigationView;
import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView botton;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botton = findViewById(R.id.botton_nav);
        setFragment(new First());
        botton.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.first_item) {
                    setFragment(new First());
                    return true;
                } else if (item.getItemId() == R.id.second_item) {
                    setFragment(new SecondFragment());
                    return true;
                } else if (item.getItemId() == R.id.third_item) {
                    setFragment(new ThirdFragment());
                    return true;
                }
                return false;
            }
        });
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        View headerView = navigationView.getHeaderView(0);
        ImageView headerImage = headerView.findViewById(R.id.header_image);
        TextView headerTitle = headerView.findViewById(R.id.header_title);
        TextView headerSubtitle = headerView.findViewById(R.id.header_subtitle);

        headerImage.setImageResource(R.drawable.govnp);
        headerTitle.setText("Ваш заголовок");
        headerSubtitle.setText("Ваш подзаголовок");

        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_setings) {
            Toast.makeText(this, "Настройки выбраны", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.flag_first) {
            setFragment(new First());
            return true;
        } else if (id == R.id.flag_two) {
            setFragment(new SecondFragment());
            return true;
        }else if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.selectedMenu, fragment, null).commit();
    }
}