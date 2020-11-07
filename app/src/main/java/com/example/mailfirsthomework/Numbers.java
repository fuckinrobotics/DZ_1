package com.example.mailfirsthomework;

import java.io.Serializable;

// Класс для работы с данными
public class Numbers implements Serializable {
    private static final long serialVersionUID = 8042222337958048164L;
    public static final int STATE_BLUE = 0;
    public static final int STATE_RED = 1;
    public String name;
    public int state;
}
