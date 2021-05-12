package controller;

import model.Phonebook;

import java.util.ArrayList;
import java.util.List;

public class Check {
    List<Phonebook> phonebookList = new ArrayList<>();

    public Check(List<Phonebook> phonebookList) {
        this.phonebookList = phonebookList;
    }

    public List<Phonebook> getPhonebookList() {
        return phonebookList;
    }

    public void setPhonebookList(List<Phonebook> phonebookList) {
        this.phonebookList = phonebookList;
    }

    public boolean checkPhoneNumber(String phoneNumber){
        for (Phonebook pb: phonebookList
             ) {
            if (pb.getPhoneNumber().equals(phoneNumber)){
                return true;
            }
        }
        System.out.println("Không tìm được danh bạ với số điện thoại trên. Mời nhập lại:");
        return false;
    }
}
