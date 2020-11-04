package com.example.mailfirsthomework;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class numbersRepository {
    // Константы
    public static final    int DATA_SIZE = 100;
    public static final float STATE_CRITICAL = 0.8f;

    // Для генерации случайных чисел
    public static final Random RANOMIZER = new Random();


    // Объекты для реализации хардкорного синглтона в java
    private static volatile numbersRepository mInstance;

    public static numbersRepository getInstance() {
        if (mInstance == null) {
            synchronized (numbersRepository.class) {
                if (mInstance == null) {
                    mInstance = new numbersRepository();
                }
            }
        }
        return mInstance;
    }


    protected final List<Numbers> mData;


    private numbersRepository() {
        mData = initializeData();
    }


    // получить список Дроидов
    public List<Numbers> list() {
        return mData;
    }

    // получить дроида по индексу
    public Numbers item(int index) {
        return mData.get(index);
    }


    // Функция инициализации списка дроидов
    protected List<Numbers> initializeData() {
        final List<Numbers> data = new ArrayList<>();

        // Наполняем лист в цикле
        for (int position = 0; position < DATA_SIZE; position ++) {
            // Генерим имя дроида
            final String name = "" + (position + 1);

            // Если четно - в красное, нечетно - в синие
            final int state;
            if (position % 2 == 0) {
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
