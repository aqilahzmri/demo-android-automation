package com.testing.firetasmiktiga;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class ProfileActivity extends AppCompatActivity {

    TextView show_profile, logout;
    BottomNavigationView bottomNavigationView;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        if(getSupportActionBar()!=null)
            getSupportActionBar().hide();
        setContentView(R.layout.activity_profile);

        auth = FirebaseAuth.getInstance();

        bottomNavigationView = findViewById(R.id.main_bottom_nav);
        //Course Activity page select
        bottomNavigationView.setSelectedItemId(R.id.nav_profile);
        //Switch to other pages
        switchPage();

        show_profile = findViewById(R.id.show_profile);
        logout = findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });

    }

    private void switchPage(){

        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.nav_profile:
                        return true;

                    case R.id.nav_courses:
                        Intent intentProfile = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(intentProfile);
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
    private void logout(){

        auth.signOut();
        Toast.makeText(ProfileActivity.this, "Logout is Successful.", Toast.LENGTH_LONG).show();
        Intent logoutIntent = new Intent(ProfileActivity.this,LoginActivity.class);
        startActivity(logoutIntent);

    }
}
