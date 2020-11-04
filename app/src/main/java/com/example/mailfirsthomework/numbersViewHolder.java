package com.example.mailfirsthomework;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class numbersViewHolder extends RecyclerView.ViewHolder {
public View button;

public interface IListener {
    void onDroidClicked(int position);
}


    protected final IListener mListener;
    protected final TextView mName;



    protected final ImageView mImage;

    public numbersViewHolder(View itemView, IListener listener) {
        super(itemView);
        button = (Button) itemView.findViewById(R.id.btn);

        mListener = listener;

        // Находим View, которые будут отвечать за имя и картинку
        mName = itemView.findViewById(R.id.name);
        mImage = itemView.findViewById(R.id.image);


        // Отслеживаем клик по элементу
        final View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onDroidClicked(getAdapterPosition());
            }
        };

        itemView.setOnClickListener(clickListener);
    }


    void bind(Numbers item) {
        // Ставим имя дроида
        mName.setText(item.name);

        // Ставим цвет, в зависимости от состояния дроида
        switch (item.state) {
            case Numbers.STATE_RED:
                mImage.setImageResource(R.color.color_red);
                break;

            case Numbers.STATE_BLUE:
                mImage.setImageResource(R.color.color_blue);
                break;

            default:
                mImage.setImageResource(R.color.color_black);
                break;
        }
    }

}
