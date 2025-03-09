package com.example.hostify1.Daftar_Login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.hostify1.Admin.MainActivity;
import com.example.hostify1.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    private EditText editTextEmail, editTextPassword;
    private Button buttonLogin;
    private FirebaseAuth mAuth;
    private TextView textViewLupaPassword; // Tambahan

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        // Handle padding untuk insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.login), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inisialisasi Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // Inisialisasi UI
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        TextView textViewDaftar = findViewById(R.id.textViewDaftar);
        textViewLupaPassword = findViewById(R.id.textViewForgotPassword); // Tambahan

        // Listener untuk tombol login
        buttonLogin.setOnClickListener(v -> loginUser());

        // Listener untuk pindah ke halaman daftar
        textViewDaftar.setOnClickListener(v -> {
            Intent intent = new Intent(Login.this, com.example.hostify1.Daftar_Login.Daftar.class);
            startActivity(intent);
        });

        // Listener untuk lupa password
        textViewLupaPassword.setOnClickListener(v -> resetPassword());
    }

    private void loginUser() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            editTextEmail.setError("Email wajib diisi");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            editTextPassword.setError("Password wajib diisi");
            return;
        }

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser user = mAuth.getCurrentUser();
                        if (user != null && user.isEmailVerified()) {
                            Toast.makeText(Login.this, "Login berhasil!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Login.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(Login.this, "Verifikasi email terlebih dahulu.", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(Login.this, "Login gagal: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }

    private void resetPassword() {
        String email = editTextEmail.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(Login.this, "Masukkan email terlebih dahulu!", Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(Login.this, "Cek email untuk reset password.", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(Login.this, "Gagal mengirim email reset: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }
}
