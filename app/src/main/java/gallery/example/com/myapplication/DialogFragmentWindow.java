package gallery.example.com.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import java.util.ArrayList;
import java.util.List;

import gallery.example.com.myapplication.adapters.CustomPagerAdapter;

public class DialogFragmentWindow extends AppCompatActivity {

    String galleryCatSelt = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.popup_window);
        Intent iin= getIntent();
        Bundle b = iin.getExtras();
        if(b != null)
        {
            String category =(String) b.get("GalleryName");
            galleryCatSelt = category;
        }

        ViewPager viewPager = (ViewPager)findViewById(R.id.pager);
        List fragments = getFragments(galleryCatSelt);
        CustomPagerAdapter customPagerAdapter = new CustomPagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(customPagerAdapter);

    }

    private List getFragments(String category){
        List fList = new ArrayList();

        switch (category){
            case "Animals" :
                fList.add(ImageFragment.newInstance(R.drawable.animal_1));
                fList.add(ImageFragment.newInstance(R.drawable.animal_2));
                fList.add(ImageFragment.newInstance(R.drawable.animal_3));
                fList.add(ImageFragment.newInstance(R.drawable.animal_4));
                fList.add(ImageFragment.newInstance(R.drawable.animal_5));
                break;
            case "Architecture" :
                fList.add(ImageFragment.newInstance(R.drawable.archi_1));
                fList.add(ImageFragment.newInstance(R.drawable.archi_2));
                fList.add(ImageFragment.newInstance(R.drawable.archi_3));
                fList.add(ImageFragment.newInstance(R.drawable.archi_4));
                break;
            case "Food":
                fList.add(ImageFragment.newInstance(R.drawable.food_1));
                fList.add(ImageFragment.newInstance(R.drawable.food_2));
                fList.add(ImageFragment.newInstance(R.drawable.food_3));
                fList.add(ImageFragment.newInstance(R.drawable.food_4));
                fList.add(ImageFragment.newInstance(R.drawable.food_5));
                break;
            case "Posters" :
                fList.add(ImageFragment.newInstance(R.drawable.poster_1));
                fList.add(ImageFragment.newInstance(R.drawable.poster_2));
                fList.add(ImageFragment.newInstance(R.drawable.poster_3));
                fList.add(ImageFragment.newInstance(R.drawable.poster_4));
                fList.add(ImageFragment.newInstance(R.drawable.poster_5));
                break;
            case "Scenery":
                fList.add(ImageFragment.newInstance(R.drawable.scenery_1));
                fList.add(ImageFragment.newInstance(R.drawable.scenery_2));
                fList.add(ImageFragment.newInstance(R.drawable.scenery_3));
                fList.add(ImageFragment.newInstance(R.drawable.scenery_4));
                fList.add(ImageFragment.newInstance(R.drawable.scenery_5));
                fList.add(ImageFragment.newInstance(R.drawable.scenery_6));
                break;
            default:
                break;

        }

        return fList;
    }
}