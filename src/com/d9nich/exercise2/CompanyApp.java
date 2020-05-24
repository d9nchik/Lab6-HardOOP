package com.d9nich.exercise2;

import static com.d9nich.exercise2.FileWork.COMPANY_FILE;
import static com.d9nich.exercise2.FileWork.printInFile;
import static com.d9nich.exercise2.ParentApp.myArrayPrint;

public class CompanyApp {
    public static void main(String[] args) {
        JoyEvent[] events = JoyEvent.generateEventsForCurrentMonth(15);
        printInFile(events, COMPANY_FILE);
        myArrayPrint(events);
    }
}
