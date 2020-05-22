package com.d9nich.exercise2;

import java.io.*;

public class FileWork {
    @SuppressWarnings("unchecked")
    public static <E extends Serializable> E readFromFile(File file) {
        try (ObjectInputStream input = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
            return (E) input.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Problem with stream");
        } catch (ClassNotFoundException ex) {
            System.out.println("Problem with class reading");
        }
        return null;
    }

    public static <E extends Serializable> void printInFile(E elements, File file) {
        try (ObjectOutputStream output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
            output.writeObject(elements);
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Problem with stream!");
        }
    }
}