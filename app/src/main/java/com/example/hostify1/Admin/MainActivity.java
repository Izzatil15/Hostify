package com.example.hostify1.Admin;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.hostify1.R;
import com.example.hostify1.Admin.HomeAFragment;
import com.example.hostify1.Admin.ProfileAFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation1);

        // 🔹 Set default fragment ke HomeAFragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new HomeAFragment())
                .commit();

        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                if (item.getItemId() == R.id.navigation_home) {
                    selectedFragment = new HomeAFragment(); // 🔹 Gunakan HomeAFragment dari package com.example.admin
                } else if (item.getItemId() == R.id.navigation_search) {
                    selectedFragment = new ProfileAFragment();
                }

                if (selectedFragment != null) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, selectedFragment)
                            .commit();
                }

                return true;
            }
        });
    }
}
