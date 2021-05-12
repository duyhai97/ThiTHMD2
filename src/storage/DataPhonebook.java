package storage;

import model.Phonebook;

import java.util.List;

public interface DataPhonebook {
    List<Phonebook> getData();
    void setData(List<Phonebook> phonebooks);
}
