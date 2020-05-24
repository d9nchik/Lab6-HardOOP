package com.d9nich.exercise2;

import java.util.HashMap;
import java.util.Scanner;

import static com.d9nich.exercise2.FileWork.*;

public class ParentApp {
    public static void main(String[] args) {
        JoyEvent[] events = readFromFile(COMPANY_FILE);
        assert events != null;
        myArrayPrint(events);

        HashMap<String, boolean[]> parentList = readFromFile(PARENT_FILE);
        if (parentList == null)
            parentList = new HashMap<>();
        int[] countOfParentsInEvent = readFromFile(TEACHER_FILE);
        if (countOfParentsInEvent == null)
            countOfParentsInEvent = new int[events.length];

        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String patternName = input.nextLine();
        boolean[] temp;
        if (parentList.containsKey(patternName)) {
            temp = parentList.get(patternName);
            for (int i = 0; i < temp.length; i++)
                if (temp[i])
                    countOfParentsInEvent[i]--;
            showActionForExistentParent(parentList, events, input, patternName);
        } else
            addParent(parentList, patternName, input, events.length);
        temp = parentList.get(patternName);
        for (int i = 0; i < temp.length; i++)
            if (temp[i])
                countOfParentsInEvent[i]++;
        printInFile(parentList, PARENT_FILE);
        printInFile(countOfParentsInEvent, TEACHER_FILE);
    }

    private static void showActionForExistentParent(HashMap<String, boolean[]> parentList, JoyEvent[] events,
                                                    Scanner input, String patternName) {
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
    }


    public static <E> void myArrayPrint(E[] array) {
        int counter = 1;
        for (E element : array)
            System.out.println(counter++ + ") " + element);
    }

    public static void addParent(HashMap<String, boolean[]> map, String value, Scanner input, int maximumBooleanSize) {
        System.out.print("Enter number of events, which you would like to visit: ");
        boolean[] booleans = new boolean[maximumBooleanSize];
        String[] numbers = input.nextLine().split("[ ]+");
        for (String number : numbers)
            booleans[Integer.parseInt(number) - 1] = true;
        map.put(value, booleans);
    }
}
