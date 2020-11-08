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
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            TextView u = (TextView) view.findViewById(R.id.detail_txt);
            if (savedInstanceState != null){
                String value = savedInstanceState.getString("state");
                u.setText(value);
                if (Integer.parseInt(value) % 2 == 0){
                    u.setTextColor(Color.parseColor("#FF0000"));
                }else{
                    u.setTextColor(Color.parseColor("#0000FF"));
                }
            }else
            u.setText("UNKNOWN");
            u.setHeight(40);
        }
        // Метод для доставания объекта Droid из аргументов фрагмента
}
