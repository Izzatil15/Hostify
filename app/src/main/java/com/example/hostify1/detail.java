package com.example.hostify1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class detail extends AppCompatActivity {

    private boolean isFavorite = false; // Status favorit

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        ImageView backButton = findViewById(R.id.backButton);
        LinearLayout btnWa = findViewById(R.id.btnwa);
        ImageView favoriteButton = findViewById(R.id.favoriteButton); // Ambil referensi tombol favorit

        // Ambil data dari Intent untuk mengetahui asal halaman
        String source = getIntent().getStringExtra("source");

        // Listener untuk tombol back
        backButton.setOnClickListener(v -> {
            if ("wishlist".equals(source)) {
                finish(); // Kembali ke WishlistFragment
            } else if ("home".equals(source)) {
                Intent intent = new Intent(detail.this, MainActivity.class);
                startActivity(intent);
                finish();
            } else if ("search".equals(source)) {
                finish(); // Kembali ke SearchFragment
            } else {
                finish(); // Default: kembali ke halaman sebelumnya
            }
        });

        // Listener untuk tombol WhatsApp
        btnWa.setOnClickListener(v -> openWhatsAppChat());

        // Listener untuk tombol favorite (ubah ikon saat ditekan)
        favoriteButton.setOnClickListener(v -> {
            if (isFavorite) {
                favoriteButton.setImageResource(R.drawable.like); // Ikon love kosong
            } else {
                favoriteButton.setImageResource(R.drawable.likefull); // Ikon love penuh
            }
            isFavorite = !isFavorite; // Toggle status
        });
    }

    // Fungsi membuka WhatsApp dengan pesan otomatis
    private void openWhatsAppChat() {
        String phoneNumber = "6287862001339"; // Format internasional tanpa "+"
        String message = "Halo, saya tertarik dengan properti ini. Bisa minta info lebih lanjut?";

        try {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://wa.me/" + phoneNumber + "?text=" + Uri.encode(message)));
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
