package com.example.hostify1.Admin;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hostify1.Admin.MainActivity;
import com.example.hostify1.R;
import com.google.android.material.button.MaterialButton;

public class crud extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud); // Pastikan nama file XML sesuai dengan yang ada di res/layout

        // Tombol untuk menambah data
        MaterialButton btnTambah = findViewById(R.id.btnCariProperty);
        btnTambah.setOnClickListener(v -> showSuccessDialog());
    }

    private void showSuccessDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Berhasil");
        builder.setMessage("Data berhasil ditambahkan!");
        builder.setCancelable(false); // Agar dialog tidak bisa ditutup dengan klik di luar

        builder.setPositiveButton("OK", (dialog, which) -> {
            Log.d("Dialog", "Tombol OK diklik");
            dialog.dismiss();

            // Kembali ke halaman utama
            Intent intent = new Intent(crud.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();

        });

        AlertDialog dialog = builder.create();
        dialog.show();
        dialog.getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(getResources().getColor(android.R.color.black));

    }
}
