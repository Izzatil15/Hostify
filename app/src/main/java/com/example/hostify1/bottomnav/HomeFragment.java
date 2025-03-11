package com.example.hostify1.bottomnav;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;
import com.example.hostify1.R;
import com.example.hostify1.detail;

public class HomeFragment extends Fragment {

    private ViewFlipper viewFlipper;
    private ImageView dot1, dot2, dot3;
    private Handler handler = new Handler();
    private Runnable flipperRunnable;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // 🔹 Inisialisasi ViewFlipper dan Dot Indicators
        viewFlipper = view.findViewById(R.id.viewFlipper);
        dot1 = view.findViewById(R.id.dot1);
        dot2 = view.findViewById(R.id.dot2);
        dot3 = view.findViewById(R.id.dot3);

        // 🔹 Auto-slide ViewFlipper setiap 3 detik
        flipperRunnable = new Runnable() {
            @Override
            public void run() {
                viewFlipper.showNext();
                updateIndicator(viewFlipper.getDisplayedChild());
                handler.postDelayed(this, 3000); // 3 detik
            }
        };
        handler.postDelayed(flipperRunnable, 3000);

        // 🔹 Event klik untuk mengganti gambar secara manual
        viewFlipper.setOnClickListener(v -> {
            viewFlipper.showNext();
            updateIndicator(viewFlipper.getDisplayedChild());
        });

        return view;
    }


    // card ke detail
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // card ke detail
        int[] textViewIds = {
                // rekomendasi
                R.id.lebihlanjut1, R.id.lebihlanjut2, R.id.lebihlanjut3,
                //populer
                R.id.lebihdetail1, R.id.lebihdetail2, R.id.lebihdetail3
        };

        for (int id : textViewIds) {
            TextView textView = view.findViewById(id);
            if (textView != null) {
                textView.setOnClickListener(v -> openDetailActivity());
            }
        }
    }

    // 🔹 Fungsi untuk memperbarui indikator (dot)
    private void updateIndicator(int displayedChild) {
        dot1.setAlpha(displayedChild == 0 ? 1.0f : 0.5f);
        dot2.setAlpha(displayedChild == 1 ? 1.0f : 0.5f);
        dot3.setAlpha(displayedChild == 2 ? 1.0f : 0.5f);
    }

    private void openDetailActivity() {
        Intent intent = new Intent(getActivity(), detail.class);
        intent.putExtra("source", "home"); // Menandai asal halaman Home
        startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        handler.removeCallbacks(flipperRunnable); // Hentikan auto-slide saat fragment dihancurkan
    }
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