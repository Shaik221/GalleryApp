package gallery.example.com.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import gallery.example.com.myapplication.adapters.ListItemsAdapter;

public class ListItemsActivity extends AppCompatActivity implements View.OnClickListener {

    String galleryCatSelt = null;

    int[] animal_images = {R.drawable.animal_1,R.drawable.animal_2,R.drawable.animal_3,R.drawable.animal_4,R.drawable.animal_5};
    int[] foods_images = {R.drawable.food_1,R.drawable.food_2,R.drawable.food_3,R.drawable.food_4,R.drawable.food_5};
    int[] posters_images = {R.drawable.poster_1,R.drawable.poster_2,R.drawable.poster_3,R.drawable.poster_4,R.drawable.poster_5};
    int[] archi_images = {R.drawable.archi_1,R.drawable.archi_2,R.drawable.archi_3,R.drawable.archi_4};
    int[] senery_images = {R.drawable.scenery_1,R.drawable.scenery_2,R.drawable.scenery_3,R.drawable.scenery_4,R.drawable.scenery_5,R.drawable.scenery_6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_gallery);

        Button backButton = (Button) findViewById(R.id.backBtn);
        backButton.setOnClickListener(this);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.galleryList);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        Intent iin= getIntent();
        Bundle b = iin.getExtras();
        if(b != null)
        {
            String category =(String) b.get("GalleryName");
            galleryCatSelt = category;
        }

        ArrayList<CreateList> createLists = prepareData(galleryCatSelt);
        ListItemsAdapter adapter = new ListItemsAdapter(this, createLists);
        recyclerView.setAdapter(adapter);

    }

    private ArrayList<CreateList> prepareData(String selectedGallery){

        ArrayList<CreateList> theimage = new ArrayList<>();

        int[] selectedImages = null;

        switch (selectedGallery){
            case "Animals":
                selectedImages = animal_images;
                break;
            case "Architecture":
                selectedImages = archi_images;
                break;
            case "Food":
                selectedImages = foods_images;
                break;
            case "Posters":
                selectedImages = posters_images;
                break;
            case "Scenery":
                selectedImages = senery_images;
                break;
            default:
                selectedImages = animal_images;
                break;
        }

        for (int i=0;i<selectedImages.length;i++) {
            CreateList createList = new CreateList("Image:"+i,selectedImages[i]);
            createList.setImage_title("Image::"+i);
            theimage.add(createList);
        }

        return theimage;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.backBtn:
                this.finish();
                break;
        }
    }

}
