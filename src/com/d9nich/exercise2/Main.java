package com.d9nich.exercise2;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

import static com.d9nich.exercise2.FileWork.printInFile;
import static com.d9nich.exercise2.FileWork.readFromFile;

public class Main {
    private final static boolean IS_COMPANY_INTERFACE = false;
    private final static File PARENT_FILE = new File("parent.dat");
    private final static File TEACHER_FILE = new File("events.dat");

    public static void main(String[] args) {
        if (IS_COMPANY_INTERFACE) {
            JoyEvent[] events = JoyEvent.generateEventsForCurrentMonth(15);
            printInFile(events, TEACHER_FILE);
            myArrayPrint(events);
        } else {
            HashMap<String, boolean[]> parentList = readFromFile(PARENT_FILE);
            if (parentList == null)
                parentList = new HashMap<>();
            JoyEvent[] events = readFromFile(TEACHER_FILE);
            assert events != null;
            myArrayPrint(events);
            Scanner input = new Scanner(System.in);
            System.out.print("Enter your name: ");
            String patternName = input.nextLine();
            if (parentList.containsKey(patternName)) {
                System.out.println("You have already added your name!");
                System.out.println("Your events choice:");
                boolean[] choices = parentList.get(patternName);
                for (int i = 0; i < choices.length; i++) {
                    if (choices[i])
                        System.out.print((i + 1) + " ");
                }
                System.out.println();
                System.out.print("Do you want to change your choices?(y, n): ");
                if (input.nextLine().charAt(0) == 'y')
                    addParent(parentList, patternName, input, events.length);
            } else
                addParent(parentList, patternName, input, events.length);
            printInFile(parentList, PARENT_FILE);
        }
    }


    private static <E> void myArrayPrint(E[] array) {
        int counter = 1;
        for (E element : array)
            System.out.println(counter++ + ") " + element);
    }


    private static void addParent(HashMap<String, boolean[]> map, String value, Scanner input, int maximumBooleanSize) {
        System.out.print("Enter number of events, which you would like to visit: ");
        boolean[] booleans = new boolean[maximumBooleanSize];
        String[] numbers = input.nextLine().split("[ ]+");
        for (String number : numbers)
            booleans[Integer.parseInt(number) - 1] = true;
        map.put(value, booleans);
    }
}
