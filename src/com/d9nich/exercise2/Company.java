package com.d9nich.exercise2;

import static com.d9nich.exercise2.FileWork.TEACHER_FILE;
import static com.d9nich.exercise2.FileWork.printInFile;
import static com.d9nich.exercise2.ParentApp.myArrayPrint;

public class Company {
    public static void main(String[] args) {
        JoyEvent[] events = JoyEvent.generateEventsForCurrentMonth(15);
        printInFile(events, TEACHER_FILE);
        myArrayPrint(events);
    }
}
