package controller;
import model.Phonebook;
import storage.filePhonebook;

import java.util.ArrayList;
import java.util.List;


public class Manager {
    List<Phonebook> phonebookList = new ArrayList<>();
    filePhonebook   filePhonebook = new filePhonebook();
    public List<Phonebook> getPhonebookList() {
        return phonebookList;
    }

    public void setPhonebookList(List<Phonebook> phonebookList) {
        this.phonebookList = phonebookList;
    }

    public Manager(List<Phonebook> phonebookList) {
        this.phonebookList = phonebookList;
    }

    public void addNewPhoneBook(Phonebook phonebook){
        phonebookList.add(phonebook);
        filePhonebook.setData(phonebookList);
    }

    public void showAllPhonebook(){
        for (Phonebook p: phonebookList
             ) {
            System.out.println(p);
        }
    }

    public void editPhonebook(String phoneNumber,String name,String address,String email,String facebook){

        for (int i = 0; i < phonebookList.size(); i++) {
            if (phonebookList.get(i).getPhoneNumber().equals(phoneNumber)){
                phonebookList.get(i).setName(name);
                phonebookList.get(i).setAddress(address);
                phonebookList.get(i).setEmail(email);
                phonebookList.get(i).setFacebook(facebook);
            }
        }
        filePhonebook.setData(phonebookList);
    }

    public void deletePhoneBook(String phoneNumber){
        for (int i = 0; i < phonebookList.size(); i++) {
            if (phonebookList.get(i).getPhoneNumber().equals(phoneNumber)){
                phonebookList.remove(phonebookList.get(i));
            }
        }
        filePhonebook.setData(phonebookList);
    }

    public void searchByPhoneNumber(String phoneNumber){
        for (Phonebook pb: phonebookList
             ) {
            if (pb.getPhoneNumber().equals(phoneNumber)){
                System.out.println(pb);
            }
        }
    }


}
