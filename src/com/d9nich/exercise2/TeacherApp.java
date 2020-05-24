package com.d9nich.exercise2;

import java.text.DateFormat;
import java.util.Objects;

import static com.d9nich.exercise2.FileWork.*;

public class TeacherApp {
    public static void main(String[] args) {
        JoyEvent[] events = readFromFile(COMPANY_FILE);

        int[] countOfParentsInEvents = readFromFile(TEACHER_FILE);
        for (int i = 0; i < Objects.requireNonNull(countOfParentsInEvents).length; i++) {
            assert events != null;
            System.out.println((i + 1) + ") '" + events[i].getType() + "' at " +
                    DateFormat.getDateInstance(DateFormat.SHORT).format(events[i].getGregorianCalendar().getTime())
                    + " registered " + countOfParentsInEvents[i] + " parents.");
        }
    }
}
