package gallery.example.com.myapplication;

import java.util.ArrayList;

public class GalleryList {

    ArrayList<CreateList> imagesList;
    String galleryName;

    public ArrayList<CreateList> getGalleryList() {
        return imagesList;
    }

    public void setGalleryList(ArrayList<CreateList> commercesItemArrayList) {
        this.imagesList = commercesItemArrayList;
    }

    public String getGalleryName() {
        return galleryName;
    }

    public void setGalleryName(String galleryName) {
        this.galleryName = galleryName;
    }

}
