package com.example.mailfirsthomework;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class NumbersFragment extends Fragment {

    // Константы
    public static final int DATA_SIZE = 100;
    public static final float STATE_CRITICAL = 0.8f;
    public static final Random RANOMIZER = new Random();


    // Ссылка на RecyclerView
    protected RecyclerView mRecycler = null;
    protected numbersAdapter mAdapter = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.recycler_first_fragment, container             // родитель, куда потом будет вставлена верстка
                , false     // стоит false, что бы инфлейтер вернул верстку.
                // Если поставить true, то инфлейтер вставит верстку в parent, и вернет тоже parent
                // Мы сами в шоке от того, почему была сделана такая логика работы метод:(
        );
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // адаптер для показа данных в ресакл вью
        // Создаем адаптер

        // Генерим данные
        final List<Numbers> data = initializeData();


        // Класс для отслеживания клика по элементу
        final numbersViewHolder.IListener stateToggler = new numbersViewHolder.IListener() {
            @Override
            public void onDroidClicked(int position) {

                // Изменяем состояние дроида
                final Numbers droid = data.get(position);
                droid.state = (droid.state + 1) % 2;

                // Уведомляем адаптер, что поменялся один из его элементов
                mAdapter.notifyItemChanged(position);
            }
        };
        // адаптер для показа данных в ресакл вью
        // Создаем адаптер

        mAdapter = new numbersAdapter(data, stateToggler);


        // Инициализируем RecyclerView
        mRecycler = view.findViewById(R.id.first_recyclerview);
        mRecycler.setLayoutManager((new GridLayoutManager(mRecycler.getContext(), 3)));
        mRecycler.setAdapter(mAdapter);
    }
    protected List<Numbers> initializeData() {
        final List<Numbers> data = new ArrayList<>();

        // Наполняем лист в цикле
        for (int position = 0; position < DATA_SIZE; position ++) {
            // Генерим имя дроида
            final String name = "Droid " + position;

            // Получаем случайное число, и определяем состояние дроида
            final int state;
            if (RANOMIZER.nextFloat() >= STATE_CRITICAL) {
                state = Numbers.STATE_BLUE;
            } else {
                state = Numbers.STATE_RED;
            }

            // Создаем дроида и добавляем его в список
            final Numbers droid = new Numbers();
            droid.name = name;
            droid.state = state;

            data.add(droid);
        }

        return data;
    }
}


