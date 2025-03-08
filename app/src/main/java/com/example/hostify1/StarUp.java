package com.example.hostify1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.hostify1.Daftar_Login.Daftar;
import com.example.hostify1.Daftar_Login.Login;


public class StarUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_star_up);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Mengambil tombol dengan ID yang benar
        Button btnCariProperty = findViewById(R.id.btnCariProperty);
        Button btnMasukPemilik = findViewById(R.id.btnMasukPemilik);
        Button btnDaftarPemilik = findViewById(R.id.btnDaftarPemilik);

        // Listener untuk btnCariProperty
        btnCariProperty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StarUp.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Listener untuk btnMasukPemilik
        btnMasukPemilik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StarUp.this, Login.class);
                startActivity(intent);
            }
        });

        // Listener untuk btnDaftarPemilik
        btnDaftarPemilik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StarUp.this, Daftar.class);
                startActivity(intent);
            }
        });
    }
}
