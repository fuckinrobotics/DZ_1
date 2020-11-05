package com.example.mailfirsthomework;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class numbersViewHolder extends RecyclerView.ViewHolder {
    public View button;
    protected final TextView mName;

    public numbersViewHolder(View itemView) {
        super(itemView);
        button = (Button) itemView.findViewById(R.id.btn);
        // Находим View, которые будут отвечать за имя и картинку
        mName = itemView.findViewById(R.id.name);


    }

    void bind(Numbers item) {
        // Ставим имя дроида

        mName.setText(item.name);
       // System.out.println(item.name);
        // Ставим цвет, в зависимости от состояния дроида
        switch (item.state) {
            case Numbers.STATE_RED:
                mName.setTextColor(Color.parseColor("#FF0000"));
                break;
            case Numbers.STATE_BLUE:
                mName.setTextColor(Color.parseColor("#0000FF"));
                break;
        }
    }

}
