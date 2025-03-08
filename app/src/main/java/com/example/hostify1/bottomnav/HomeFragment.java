package com.example.hostify1.bottomnav;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hostify1.R;
import com.example.hostify1.detail;

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
////
////        // 🔹 Ambil referensi elemen UI
////        TextView lebihlanjut1 = view.findViewById(R.id.lebihlanjut1);
////        TextView lebihlanjut2 = view.findViewById(R.id.lebihlanjut2);
////        TextView lebihlanjut3 = view.findViewById(R.id.lebihlanjut3);
////        TextView lebihlanjut4 = view.findViewById(R.id.lebihlanjut4);
////        TextView lebihlanjut5 = view.findViewById(R.id.lebihlanjut5);
////
////        // 🔹 Tambahkan event listener untuk rekomendasi card
////        lebihlanjut1.setOnClickListener(v -> openDetailActivity());
////        lebihlanjut2.setOnClickListener(v -> openDetailActivity());
////        lebihlanjut3.setOnClickListener(v -> openDetailActivity());
////        lebihlanjut4.setOnClickListener(v -> openDetailActivity());
////        lebihlanjut5.setOnClickListener(v -> openDetailActivity());
//////
//////        // 🔹 Ambil referensi elemen UI untuk popular card
//////        TextView lebihlanjutP1 = view.findViewById(R.id.lebihlanjutP1);
//////        TextView lebihlanjutP2 = view.findViewById(R.id.lebihlanjutP2);
//////        TextView lebihlanjutP3 = view.findViewById(R.id.lebihlanjutP3);
//////        TextView lebihlanjutP4 = view.findViewById(R.id.lebihlanjutP4);
//        TextView lebihlanjutP5 = view.findViewById(R.id.lebihlanjutP5);
//////
//////        // 🔹 Tambahkan event listener untuk popular card
//////        lebihlanjutP1.setOnClickListener(v -> openDetailActivity());
//////        lebihlanjutP2.setOnClickListener(v -> openDetailActivity());
//////        lebihlanjutP3.setOnClickListener(v -> openDetailActivity());
//////        lebihlanjutP4.setOnClickListener(v -> openDetailActivity());
//        lebihlanjutP5.setOnClickListener(v -> openDetailActivity());
//    }
//////
//    private void openDetailActivity() {
//        Intent intent = new Intent(getActivity(), detail.class);
//        startActivity(intent);
//    }
}
