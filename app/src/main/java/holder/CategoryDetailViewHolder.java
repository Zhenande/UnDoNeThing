package holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.abc.khoaluan.R;

/**
 * Created by vpmn-os-quocnb on 3/8/2018.
 */

public class CategoryDetailViewHolder extends RecyclerView.ViewHolder {

    public ImageView CategoryDetailImage;
    public TextView CategoryDetailName;
    public TextView CategoryDetailAddress;


    public CategoryDetailViewHolder(View itemView) {
        super(itemView);

        CategoryDetailImage = itemView.findViewById(R.id.listview_category_detail_row_image);
        CategoryDetailName = itemView.findViewById(R.id.listview_category_detail_row_name);
        CategoryDetailAddress = itemView.findViewById(R.id.listview_category_detail_row_address);

    }
    
}
