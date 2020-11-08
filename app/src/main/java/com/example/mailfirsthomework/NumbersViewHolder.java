package com.example.mailfirsthomework;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

// Класс ViewHolder для ресайкла
public class NumbersViewHolder extends RecyclerView.ViewHolder {
    public View button;
    public interface IListener {
        void onNumbersClicked(int position);
    }
    protected final IListener mListener;
    protected final TextView mName;
    public NumbersViewHolder(View itemView, IListener listener) {
        super(itemView);
        mListener = listener;
        button = (Button) itemView.findViewById(R.id.btn);
        // Находим View, которые будут отвечать за имя и картинку
        mName = itemView.findViewById(R.id.name);
        // Отслеживаем клик по элементу
        final View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onNumbersClicked(getAdapterPosition());
            }
        };
        itemView.setOnClickListener(clickListener);
    }

    void bind(Numbers item) {
        // Ставим имя
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
