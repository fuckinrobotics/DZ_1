package com.example.mailfirsthomework;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Класс для работы с данными
public class NumbersRepository {
    // Константы
    public static final int DATA_SIZE = 100;
    // Объекты для реализации хардкорного синглтона в java
    private static volatile NumbersRepository mInstance;

    public static NumbersRepository getInstance() {
        if (mInstance == null) {
            synchronized (NumbersRepository.class) {
                if (mInstance == null) {
                    mInstance = new NumbersRepository();
                }
            }
        }
        return mInstance;
    }

    protected final List<Numbers> mData;

    private NumbersRepository() {
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
            final String name = Integer.toString(position + 1);

            // Если четно - в красное, нечетно - в синие
            final int state;
            if (position % 2 == 0) {
                state = Numbers.STATE_BLUE;
            } else {
                state = Numbers.STATE_RED;
            }
            // Создаем дроида и добавляем его в список
            final Numbers numbers = new Numbers();
            numbers.name = name;
            numbers.state = state;
            data.add(numbers);
        }
        return data;
    }
}
