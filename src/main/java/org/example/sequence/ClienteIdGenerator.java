package org.example.sequence;

public class ClienteIdGenerator {


    private static Integer idCounter = 0;

    public static Integer getNextId() {
        return ++idCounter;
    }
}
