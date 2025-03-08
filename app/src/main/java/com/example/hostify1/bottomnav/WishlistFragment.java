package com.example.hostify1.bottomnav;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.hostify1.R;

public class WishlistFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_wishlist, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Referensi ikon favorit dan CardView
        ImageView favoriteIcon1 = view.findViewById(R.id.favorite_icon1);
        androidx.cardview.widget.CardView card1 = view.findViewById(R.id.card1);

        ImageView favoriteIcon2 = view.findViewById(R.id.favorite_icon2);
        androidx.cardview.widget.CardView card2 = view.findViewById(R.id.card2);

        ImageView favoriteIcon3 = view.findViewById(R.id.favorite_icon3);
        androidx.cardview.widget.CardView card3 = view.findViewById(R.id.card3);

        ImageView favoriteIcon4 = view.findViewById(R.id.favorite_icon4);
        androidx.cardview.widget.CardView card4 = view.findViewById(R.id.card4);

        ImageView favoriteIcon5 = view.findViewById(R.id.favorite_icon5);
        androidx.cardview.widget.CardView card5 = view.findViewById(R.id.card5);

        ImageView favoriteIcon6 = view.findViewById(R.id.favorite_icon6);
        androidx.cardview.widget.CardView card6 = view.findViewById(R.id.card6);

        ImageView favoriteIcon7 = view.findViewById(R.id.favorite_icon7);
        androidx.cardview.widget.CardView card7 = view.findViewById(R.id.card7);

        ImageView favoriteIcon8 = view.findViewById(R.id.favorite_icon8);
        androidx.cardview.widget.CardView card8 = view.findViewById(R.id.card8);

        ImageView favoriteIcon9 = view.findViewById(R.id.favorite_icon9);
        androidx.cardview.widget.CardView card9 = view.findViewById(R.id.card9);

        ImageView favoriteIcon10 = view.findViewById(R.id.favorite_icon10);
        androidx.cardview.widget.CardView card10 = view.findViewById(R.id.card10);

        // Set keadaan awal: Love penuh & CardView terlihat
        favoriteIcon1.setImageResource(R.drawable.love);
        favoriteIcon2.setImageResource(R.drawable.love);
        favoriteIcon3.setImageResource(R.drawable.love);
        favoriteIcon4.setImageResource(R.drawable.love);
        favoriteIcon5.setImageResource(R.drawable.love);
        favoriteIcon6.setImageResource(R.drawable.love);
        favoriteIcon7.setImageResource(R.drawable.love);
        favoriteIcon8.setImageResource(R.drawable.love);
        favoriteIcon9.setImageResource(R.drawable.love);
        favoriteIcon10.setImageResource(R.drawable.love);
        card1.setVisibility(View.VISIBLE);
        card2.setVisibility(View.VISIBLE);
        card3.setVisibility(View.VISIBLE);
        card4.setVisibility(View.VISIBLE);
        card5.setVisibility(View.VISIBLE);
        card6.setVisibility(View.VISIBLE);
        card7.setVisibility(View.VISIBLE);
        card8.setVisibility(View.VISIBLE);
        card9.setVisibility(View.VISIBLE);
        card10.setVisibility(View.VISIBLE);

        // Tambahkan event listener untuk setiap ikon favorit
        favoriteIcon1.setOnClickListener(v -> toggleFavorite(favoriteIcon1, card1));
        favoriteIcon2.setOnClickListener(v -> toggleFavorite(favoriteIcon2, card2));
        favoriteIcon3.setOnClickListener(v -> toggleFavorite(favoriteIcon3, card3));
        favoriteIcon4.setOnClickListener(v -> toggleFavorite(favoriteIcon4, card4));
        favoriteIcon5.setOnClickListener(v -> toggleFavorite(favoriteIcon5, card5));
        favoriteIcon6.setOnClickListener(v -> toggleFavorite(favoriteIcon6, card6));
        favoriteIcon7.setOnClickListener(v -> toggleFavorite(favoriteIcon7, card7));
        favoriteIcon8.setOnClickListener(v -> toggleFavorite(favoriteIcon8, card8));
        favoriteIcon9.setOnClickListener(v -> toggleFavorite(favoriteIcon9, card9));
        favoriteIcon10.setOnClickListener(v -> toggleFavorite(favoriteIcon10, card10));
    }

    private void toggleFavorite(ImageView imageView, androidx.cardview.widget.CardView cardView) {
        if (cardView.getVisibility() == View.VISIBLE) {
            imageView.setImageResource(R.drawable.love); // Ubah jadi hati kosong
            cardView.setVisibility(View.GONE); // Sembunyikan CardView
        }
    }
}
