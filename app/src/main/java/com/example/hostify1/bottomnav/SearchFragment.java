package com.example.hostify1.bottomnav;

import android.annotation.SuppressLint;
import android.content.Intent;
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
import androidx.fragment.app.FragmentTransaction;

import com.example.hostify1.R;
import com.example.hostify1.detail;

public class SearchFragment extends Fragment {

    private CardView card1, card2, card3, card4, card5, card6, card7, card8, card9, card10;
    private TextView propertyName1, propertyName2, propertyName3, propertyName4, propertyName5,
    propertyName6, propertyName7, propertyName8, propertyName9, propertyName10;
    private EditText searchEditText;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        // Inisialisasi View
        searchEditText = view.findViewById(R.id.search_edit_text);
        card1 = view.findViewById(R.id.card1);
        card2 = view.findViewById(R.id.card2);
        card3 = view.findViewById(R.id.card3);
        card4 = view.findViewById(R.id.card4);
        card5 = view.findViewById(R.id.card5);
        card6 = view.findViewById(R.id.card6);
        card7 = view.findViewById(R.id.card7);
        card8 = view.findViewById(R.id.card8);
        card9 = view.findViewById(R.id.card9);
        card10 = view.findViewById(R.id.card10);

        propertyName1 = view.findViewById(R.id.property_name1);
        propertyName2 = view.findViewById(R.id.property_name2);
        propertyName3 = view.findViewById(R.id.property_name3);
        propertyName4 = view.findViewById(R.id.property_name4);
        propertyName5 = view.findViewById(R.id.property_name5);
        propertyName6 = view.findViewById(R.id.property_name6);
        propertyName7 = view.findViewById(R.id.property_name7);
        propertyName8 = view.findViewById(R.id.property_name8);
        propertyName9 = view.findViewById(R.id.property_name9);
        propertyName10 = view.findViewById(R.id.property_name10);

        // Implementasi Pencarian
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

        // Daftar TextView yang akan membuka halaman detail
        int[] textViewIds = {
                R.id.lebihDetail1,
                R.id.lebihDetail2,
                R.id.lebihDetail3,
                R.id.lebihDetail4,
                R.id.lebihDetail5,
                R.id.lebihDetail6,
                R.id.lebihDetail7,
                R.id.lebihDetail8,
                R.id.lebihDetail9,
                R.id.lebihDetail10,
        };

        for (int id : textViewIds) {
            TextView textView = view.findViewById(id);
            if (textView != null) {
                textView.setOnClickListener(v -> openDetailActivity());
            }
        }

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
        toggleCard(card8, propertyName8, query);
        toggleCard(card9, propertyName9, query);
        toggleCard(card10, propertyName10, query);
    }

    // Fungsi untuk menampilkan atau menyembunyikan kartu sesuai pencarian
    private void toggleCard(CardView card, TextView propertyName, String query) {
        if (card != null && propertyName != null) {
            if (propertyName.getText().toString().toLowerCase().contains(query)) {
                card.setVisibility(View.VISIBLE);
            } else {
                card.setVisibility(View.GONE);
            }
        }
    }

    // Fungsi membuka halaman detail dengan menandai asalnya dari SearchFragment
    private void openDetailActivity() {
        Intent intent = new Intent(getActivity(), detail.class);
        intent.putExtra("source", "search"); // Menandai asal halaman Search
        startActivity(intent);
    }

    // Fungsi membuka HomeFragment
    private void openHomeFragment() {
        if (getActivity() != null) {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, new HomeFragment());
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }
}
