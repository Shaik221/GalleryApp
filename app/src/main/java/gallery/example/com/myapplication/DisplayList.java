package gallery.example.com.myapplication;

import java.util.ArrayList;

public class DisplayList {

    public ArrayList<CreateList> getListToDis() {
        return listToDis;
    }

    public void setListToDis(ArrayList<CreateList> listToDis) {
        this.listToDis = listToDis;
    }

    public DisplayList(ArrayList<CreateList> listToDis) {
        this.listToDis = listToDis;
    }

    private ArrayList<CreateList> listToDis;

}