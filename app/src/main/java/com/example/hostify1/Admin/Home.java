package com.example.hostify1.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hostify1.Daftar_Login.Daftar;
import com.example.hostify1.Daftar_Login.Login;
import com.example.hostify1.MainActivity;
import com.example.hostify1.R;
import com.example.hostify1.StarUp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Home extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();

        TextView txtUsername = findViewById(R.id.txt_username);
        TextView txt_email = findViewById(R.id.txt_email);
        Button btnLogout = findViewById(R.id.btn_logout);
        Button btnMasuk = findViewById(R.id.btn_masuk);
        Button btnDaftar = findViewById(R.id.btn_daftar);



        // 🔹 Menampilkan atau menyembunyikan tombol sesuai status login
        if (user != null) {
            // Jika user sudah login
            txtUsername.setText("Nama: " + user.getDisplayName());
            txt_email.setText("Email: " + user.getEmail());
            btnLogout.setVisibility(View.VISIBLE);
            btnMasuk.setVisibility(View.GONE);
            btnDaftar.setVisibility(View.GONE);
        } else {
            // Jika user belum login
            txtUsername.setText("Silakan login terlebih dahulu");
            btnLogout.setVisibility(View.GONE);
            btnMasuk.setVisibility(View.VISIBLE);
            btnDaftar.setVisibility(View.VISIBLE);
        }

        // 🔹 Navigasi ke LoginActivity
        btnMasuk.setOnClickListener(v -> {
            startActivity(new Intent(Home.this, Login.class));
        });

        // 🔹 Navigasi ke RegisterActivity
        btnDaftar.setOnClickListener(v -> {
            startActivity(new Intent(Home.this, Daftar.class));
        });

        // 🔹 Logout dari Firebase
        btnLogout.setOnClickListener(v -> {
            mAuth.signOut(); // Logout user dari Firebase
            Toast.makeText(Home.this, "Berhasil Logout", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Home.this, StarUp.class));
            finish(); // Tutup ProfileActivity agar tidak bisa kembali dengan tombol Back
        });
    }
}
