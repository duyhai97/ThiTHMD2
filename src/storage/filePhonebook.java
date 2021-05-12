package storage;

import model.Phonebook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class filePhonebook implements DataPhonebook {



    @Override
    public List<Phonebook> getData() {
        File file = new File("file1.csv");
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (file.length() > 0){
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            ObjectInputStream objectInputStream = null;
            try {
                objectInputStream = new ObjectInputStream(fileInputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Object obj = null;
            try {
                obj = objectInputStream.readObject();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            List<Phonebook> accountList = (List<Phonebook>) obj;
            return accountList;
        }
        else return new ArrayList<>();
    }

    @Override
    public void setData(List<Phonebook> phonebooks) {
        File file = new File("file1.csv");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            objectOutputStream.writeObject(phonebooks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
