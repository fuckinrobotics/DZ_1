package com.example.mailfirsthomework;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

// Класс адаптера для ресайкла
public class NumbersAdapter extends RecyclerView.Adapter<NumbersViewHolder> {
    protected final List<Numbers> mData;
    public NumbersAdapter(List<Numbers> data) {
        mData = data;
    }

    // Метод инициализации ViewHolder
    @NonNull
    @Override
    public NumbersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Получаем инфлейтер и создаем нужный layout в зависимости от ViewType
        View itemView;
        if (viewType == R.layout.item_numbers) {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_numbers, parent, false);
        } else {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.btn_item, parent, false);
        }
        return new NumbersViewHolder(itemView);
    }

    // Метод вставки данных во во ViewHolder
    @Override
    public void onBindViewHolder(@NonNull NumbersViewHolder holder, final int position) {
        if(position == mData.size()) {
            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Numbers item = new Numbers();
                    item.name = Integer.toString(position + 1);
                    item.state = (position) % 2;
                    addItem(item, position + 1);
                }
            });

        }
        else {
            final Numbers item = mData.get(position);
            holder.bind(item);
        }
    }

    // Метод добавления элемента в список с уведомлением ресайклера
    private void addItem(Numbers item, int position) {
        mData.add(item);
        notifyItemChanged(position);
    }

    // Метод преназначения View type
    @Override
    public int getItemViewType(int position) {
        return (position == mData.size()) ? R.layout.btn_item : R.layout.item_numbers;
    }

    // Метод увеличения размера данных, увеличенные на 1 (из-за кнопки)
    @Override
    public int getItemCount() {
        return mData.size() + 1;
    }
}