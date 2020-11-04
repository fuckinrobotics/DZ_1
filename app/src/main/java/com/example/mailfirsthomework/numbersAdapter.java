package com.example.mailfirsthomework;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class numbersAdapter extends RecyclerView.Adapter<numbersAdapter.numbersViewHolder> {
    private String[] mDataset;


    public static class numbersViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;
        public numbersViewHolder(TextView v) {
            super(v);
            textView = v;
        }
    }


    public numbersAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    @Override
    public numbersAdapter.numbersViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {

        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_first_fragment, parent, false);

        numbersViewHolder vh = new numbersViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(numbersViewHolder holder, int position) {

        holder.textView.setText(mDataset[position]);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}