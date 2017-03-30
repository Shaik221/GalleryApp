package gallery.example.com.myapplication.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import gallery.example.com.myapplication.CreateList;
import gallery.example.com.myapplication.ImageUtils;
import gallery.example.com.myapplication.R;

public class ListItemsAdapter extends RecyclerView.Adapter<ListItemsAdapter.ViewHolder> {
    private ArrayList<CreateList> galleryList;
    private Context context;

    public ListItemsAdapter(Context context, ArrayList<CreateList> galleryList) {
        this.galleryList = galleryList;
        this.context = context;
    }

    @Override
    public ListItemsAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_cell_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListItemsAdapter.ViewHolder viewHolder, int i) {
        viewHolder.title.setText(galleryList.get(i).getImage_title());
        Bitmap tempBitmap = ImageUtils.decodeResource(context.getResources(),galleryList.get(i).getImage_ID());
        int height = ImageUtils.dpToPx(context,200);
        int width = viewHolder.img.getMaxWidth();
        Bitmap scaleBitmap = ImageUtils.getResizedBitmap(tempBitmap,width,height);
        viewHolder.img.setImageBitmap(scaleBitmap);
        viewHolder.img.setScaleType(ImageView.ScaleType.FIT_XY);
    }

    @Override
    public int getItemCount() {
        return galleryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private ImageView img;

        public ViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.info_text);
            img = (ImageView) view.findViewById(R.id.imagegallery);
        }

    }
}