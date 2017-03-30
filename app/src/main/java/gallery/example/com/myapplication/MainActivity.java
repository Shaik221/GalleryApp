package gallery.example.com.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.imagegallery);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<CreateList> createLists = prepareData();
        MyAdapter adapter = new MyAdapter(this, createLists);
        recyclerView.setAdapter(adapter);


    }

    private ArrayList<CreateList> prepareData(){

        ArrayList<CreateList> theimage = new ArrayList<>();
        String image_titles[] = {
                "Animals",
                "Architecture",
                "Food",
                "Posters",
                "Scenery"
        };
        for(int i = 0; i< image_titles.length; i++){
            String img = image_titles[i];
            CreateList createList = new CreateList(img,getImageId(img));

            theimage.add(createList);
        }
        return theimage;
    }

    private int getImageId(String category){

        switch (category){
            case "Animals" :
                return R.drawable.animal_1;
            case "Architecture" :
                return R.drawable.archi_1;
            case "Food" :
                return R.drawable.food_1;
            case "Posters" :
                return R.drawable.poster_1;
            case "Scenery":
                return R.drawable.scenery_1;
            default:
                return R.drawable.animal_1;
        }

    }
}
