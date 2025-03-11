package com.example.hostify1.Daftar_Login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.hostify1.R;
import com.example.hostify1.detail;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class Daftar extends AppCompatActivity {

    private EditText editTextNama, editTextEmail, editTextPassword;
    private Button buttonDaftar;
    private FirebaseAuth mAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_daftar);

        // Handle padding untuk insets (status bar, navigation bar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.daftar), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inisialisasi Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // Inisialisasi UI
        editTextNama = findViewById(R.id.editTextNama);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonDaftar = findViewById(R.id.buttonDaftar);
        TextView textViewLogin = findViewById(R.id.textViewLogin);

        // Listener untuk tombol daftar
        buttonDaftar.setOnClickListener(v -> registerUser());

        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Daftar.this, Login.class);
                startActivity(intent);
            }
        });
    }

    private void registerUser() {
        String nama = editTextNama.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (TextUtils.isEmpty(nama)) {
            editTextNama.setError("Nama wajib diisi");
            return;
        }

        if (TextUtils.isEmpty(email)) {
            editTextEmail.setError("Email wajib diisi");
            return;
        }

        if (TextUtils.isEmpty(password) || password.length() < 6) {
            editTextPassword.setError("Password minimal 6 karakter");
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser user = mAuth.getCurrentUser();
                        if (user != null) {
                            // Simpan nama pengguna di Firebase
                            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                    .setDisplayName(nama)
                                    .build();

                            user.updateProfile(profileUpdates)
                                    .addOnCompleteListener(profileTask -> {
                                        if (profileTask.isSuccessful()) {
                                            // Kirim email verifikasi
                                            user.sendEmailVerification()
                                                    .addOnCompleteListener(verifyTask -> {
                                                        if (verifyTask.isSuccessful()) {
                                                            showCustomToast("Pendaftaran berhasil! Verifikasi email Anda.", true);
                                                            Intent intent = new Intent(Daftar.this, Login.class);
                                                            startActivity(intent);
                                                            finish();
                                                        } else {
                                                            showCustomToast("Gagal mengirim email verifikasi", false);
                                                        }
                                                    });
                                        } else {
                                            showCustomToast("Gagal menyimpan nama pengguna", false);
                                        }
                                    });
                        }
                    } else {
                        showCustomToast("Pendaftaran gagal: " + task.getException().getMessage(), false);
                    }
                });
    }

    private void showCustomToast(String message, boolean isSuccess) {
        Toast toast = new Toast(getApplicationContext());
        LayoutInflater inflater = getLayoutInflater();

        View layout;
        if (isSuccess) {
            layout = inflater.inflate(R.layout.custom_toast_success, null);
        } else {
            layout = inflater.inflate(R.layout.custom_toast_error, null);
        }

        TextView text = layout.findViewById(R.id.toastMessage);
        text.setText(message);

        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
}
