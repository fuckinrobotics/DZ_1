package com.example.mailfirsthomework;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class numbersAdapter extends RecyclerView.Adapter<numbersViewHolder> {
    protected final numbersViewHolder.IListener mListener;
    protected final List<Numbers> mData;

    public numbersAdapter(List<Numbers> data, numbersViewHolder.IListener listener) {
        mListener = listener;
        mData = data;
    }


    // Инициализируем ViewHolder
    @NonNull
    @Override
    public numbersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Получаем инфлейтер и создаем нужный layout в зависимости от ViewType
        View itemView;
        if (viewType == R.layout.item_numbers) {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_numbers, parent, false);
        } else {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.btn_item, parent, false);
        }
        return new numbersViewHolder(itemView, mListener);
    }

    // Вставляем данные во ViewHolder
    @Override
    public void onBindViewHolder(@NonNull numbersViewHolder holder, int position) {
        if(position == mData.size()) {
            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Toast.makeText( "Button Clicked", Toast.LENGTH_LONG).show();
                }
            });
        }
        else {
            final Numbers item = mData.get(position);
            holder.bind(item);
        }
    }

    // Переприсвыиваем элемент, если он последний
    @Override
    public int getItemViewType(int position) {
        return (position == mData.size()) ? R.layout.btn_item : R.layout.item_numbers;
    }
    // Размер данных, уваличенный на елиницу, чтобы дообавить кнопку
    @Override
    public int getItemCount() {
        return mData.size() + 1;
    }
}