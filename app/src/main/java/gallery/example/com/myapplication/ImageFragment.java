package gallery.example.com.myapplication;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class ImageFragment extends Fragment{

    public static final String Msgs = "Message";

    public static ImageFragment newInstance(int imageId)
    {
        ImageFragment fg = new ImageFragment();
        Bundle bl = new Bundle();
        bl.putInt("Image_Id", imageId);
        fg.setArguments(bl);
        return fg;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.image_fragment, container, false);


        ImageView imageView = (ImageView)v.findViewById(R.id.image_popup);
        int imageId = getArguments().getInt("Image_Id");
        Bitmap tempBitmap = ImageUtils.decodeResource(getResources(),imageId);
        int height = imageView.getMaxHeight();
        int width = imageView.getMaxWidth();
        Bitmap scaleBitmap = ImageUtils.getResizedBitmap(tempBitmap,width,height);
        imageView.setImageBitmap(scaleBitmap);


        return v;

    }

}


