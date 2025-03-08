package com.example.hostify1.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.hostify1.Daftar_Login.Daftar;
import com.example.hostify1.Daftar_Login.Login;
import com.example.hostify1.R;
import com.example.hostify1.StarUp;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileAFragment extends Fragment {
    private FirebaseAuth mAuth;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_a, container, false);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();

        TextView txtUsername = view.findViewById(R.id.txt_username);
        TextView txtEmail = view.findViewById(R.id.txt_email);
        MaterialButton btnLogout = view.findViewById(R.id.btn_logout);


        if (user != null) {
            txtUsername.setText(user.getDisplayName() != null ? user.getDisplayName() : "Pengguna");
            txtEmail.setText(user.getEmail());

            btnLogout.setVisibility(View.VISIBLE);

        } else {
            txtUsername.setText("Silakan login terlebih dahulu");
            txtEmail.setText("");

            btnLogout.setVisibility(View.GONE);

        }


        btnLogout.setOnClickListener(v -> {
            mAuth.signOut();
            Toast.makeText(getActivity(), "Berhasil Logout", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getActivity(), StarUp.class));
            getActivity().finish();
        });

        return view;
    }
}
