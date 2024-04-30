package org.example.sequence;

public class NumeroCuentaGenerator {


    private static Integer idCounter = 0;

    public static Integer getNextId() {
        return ++idCounter;
    }
}
