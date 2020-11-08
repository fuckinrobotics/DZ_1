package com.example.mailfirsthomework;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Класс фрагмента
public class NumbersFragment extends Fragment {

    // Интерфейс клика по Numbers
    public interface IListener {
        public void onNumbersClicked(Numbers item);
    }

    // Переменная лисенера
    protected IListener mListener;

    // Ассоциация с активити
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (requireActivity() instanceof IListener) {
            mListener = (IListener) requireActivity();
        }
    }

    // Инициализация view
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.recycler_first_fragment, container             // родитель, куда потом будет вставлена верстка
                , false     // стоит false, что бы инфлейтер вернул верстку.
                // Если поставить true, то инфлейтер вставит верстку в parent, и вернет тоже parent
                // Мы сами в шоке от того, почему была сделана такая логика работы метод:(
        );
    }

    // когда View создано
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // инициализируем View для отображения списка
        int orientation = this.getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            // code for portrait mode
            final RecyclerView recycler = view.findViewById(R.id.first_recyclerview);
            recycler.setAdapter(new NumbersAdapter(NumbersRepository.getInstance().list(), new NumbersClickHandler()));
            recycler.setLayoutManager(new GridLayoutManager(requireContext(), 3));
        } else {
            // code for landscape mode
            final RecyclerView recycler = view.findViewById(R.id.first_recyclerview);
            recycler.setAdapter(new NumbersAdapter(NumbersRepository.getInstance().list(), new NumbersClickHandler()));
            recycler.setLayoutManager(new GridLayoutManager(requireContext(), 4));
        }

    }

    // Отсоединение от активити
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    // Одна из возможных реализаций отслеживания клика по элементу
    // обработчик клика по элементу
    class NumbersClickHandler implements NumbersViewHolder.IListener {
        @Override
        public void onNumbersClicked(int position) {
            final Numbers item = NumbersRepository.getInstance().item(position);
            // Вариант кода, для общения с activity без Intent
            if (mListener != null) {
                mListener.onNumbersClicked(item);
            }
            System.out.println("hfgdf");

            Bundle bundle=new Bundle();
            bundle.putString("state",item.name);
            DetailsFragment newFragment = new DetailsFragment();
            newFragment.setArguments(bundle);
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.first_fragment, newFragment);
            transaction.commit();
        }
    }
}


