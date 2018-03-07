package holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.abc.khoaluan.R;

/**
 * Created by ABC on 3/6/2018.
 */

public class MainHorizontalViewHolder extends RecyclerView.ViewHolder {

    public ImageView RestaurentImage;
    public TextView RestaurentName;
    public TextView RestaurentAddress;

    public MainHorizontalViewHolder(View itemView) {
        super(itemView);
        RestaurentImage = itemView.findViewById(R.id.recycle_restaurent_image);
        RestaurentName = itemView.findViewById(R.id.recycle_restaurent_name);
        RestaurentAddress = itemView.findViewById(R.id.recycle_restaurent_address);


    }
}
