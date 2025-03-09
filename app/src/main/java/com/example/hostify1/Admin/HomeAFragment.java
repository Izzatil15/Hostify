package com.example.hostify1.Admin;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.hostify1.R;

public class HomeAFragment extends Fragment {

    private CardView card1, card2, card3, card4, card5, card6, card7;
    private TextView propertyName1, propertyName2, propertyName3, propertyName4, propertyName5, propertyName6, propertyName7;
    private EditText searchEditText;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_a, container, false);

        // Inisialisasi View
        searchEditText = view.findViewById(R.id.search_edit_text);
        card1 = view.findViewById(R.id.card1);
        card2 = view.findViewById(R.id.card2);
        card3 = view.findViewById(R.id.card3);
        card4 = view.findViewById(R.id.card4);
        card5 = view.findViewById(R.id.card5);
        card6 = view.findViewById(R.id.card6);
        card7 = view.findViewById(R.id.card7);

        propertyName1 = view.findViewById(R.id.property_name1);
        propertyName2 = view.findViewById(R.id.property_name2);
        propertyName3 = view.findViewById(R.id.property_name3);
        propertyName4 = view.findViewById(R.id.property_name4);
        propertyName5 = view.findViewById(R.id.property_name5);
        propertyName6 = view.findViewById(R.id.property_name6);
        propertyName7 = view.findViewById(R.id.property_name7);

        // Tambahkan TextWatcher ke EditText untuk pencarian
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterCards(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });

        return view;
    }

    // Fungsi untuk menyaring kartu berdasarkan pencarian
    private void filterCards(String query) {
        query = query.toLowerCase();

        toggleCard(card1, propertyName1, query);
        toggleCard(card2, propertyName2, query);
        toggleCard(card3, propertyName3, query);
        toggleCard(card4, propertyName4, query);
        toggleCard(card5, propertyName5, query);
        toggleCard(card6, propertyName6, query);
        toggleCard(card7, propertyName7, query);
    }

    // Fungsi untuk menyembunyikan atau menampilkan kartu sesuai dengan pencarian
    private void toggleCard(CardView card, TextView propertyName, String query) {
        if (propertyName.getText().toString().toLowerCase().contains(query)) {
            card.setVisibility(View.VISIBLE);
        } else {
            card.setVisibility(View.GONE);
        }
    }
}
