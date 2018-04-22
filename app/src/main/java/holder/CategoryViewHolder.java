package holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.abc.khoaluan.R;


public class CategoryViewHolder extends RecyclerView.ViewHolder{

    public ImageView CategoryImage;
    public TextView CategoryName;


    public CategoryViewHolder(View itemView) {
        super(itemView);

        CategoryImage = itemView.findViewById(R.id.listview_category_row_image);
        CategoryName = itemView.findViewById(R.id.listview_category_row_name);

    }
}
