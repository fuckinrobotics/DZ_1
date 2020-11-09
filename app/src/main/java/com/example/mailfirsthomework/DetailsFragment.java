package com.example.mailfirsthomework;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;

public class DetailsFragment  extends Fragment {
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.second_fragment, container, false);
        }

        @Override
        public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            final TextView u = view.findViewById(R.id.detail_txt);
            Button b = view.findViewById(R.id.btn_back);
            final Bundle bundle = this.getArguments();
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (bundle != null) {
                        getFragmentManager().popBackStack();
                    }
                }
            });
            if (bundle != null){
                String value = bundle.getString("state");
                u.setText(value);
                if (Integer.parseInt(value) % 2 == 0){
                    u.setTextColor(Color.parseColor("#FF0000"));
                }else{
                    u.setTextColor(Color.parseColor("#0000FF"));
                }
            }else {
                u.setText("UNKNOWN");
            }
            u.setHeight(40);
        }
}
