package com.d9nich.exercise2;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        JoyEvent[] events = JoyEvent.generateEventsForCurrentMonth(15);
        printInFileGeneratedEvents(events, new File("events.dat"));
        myArrayPrint(events);
    }

    private static void printInFileGeneratedEvents(JoyEvent[] events, File file) {
        try (ObjectOutputStream output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
            output.writeObject(events);
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Problem with stream!");
        }
    }

    private static <E> void myArrayPrint(E[] array) {
        int counter = 1;
        for (E element : array)
            System.out.println(counter++ + ") " + element);
    }

    private static JoyEvent[] readFromFileEvents(File file) {
        try (ObjectInputStream input = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
            return (JoyEvent[]) input.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Problem with stream");
        } catch (ClassNotFoundException ex) {
            System.out.println("Problem with class reading");
        }
        return null;
    }
}
