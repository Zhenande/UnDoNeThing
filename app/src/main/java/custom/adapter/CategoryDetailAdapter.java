package custom.adapter;

import android.content.Context;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.abc.khoaluan.R;

import java.util.ArrayList;

import holder.CategoryDetailViewHolder;
import model.CategoryDetail;

/**
 * Created by vpmn-os-quocnb on 3/8/2018.
 */

public class CategoryDetailAdapter extends RecyclerView.Adapter<CategoryDetailViewHolder> {

    private ArrayList<CategoryDetail> list;

    public CategoryDetailAdapter(ArrayList<CategoryDetail> data) {
        this.list = data;
    }

    @NonNull
    @Override
    public CategoryDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listview_category_detail_row,parent,false);
        LinearLayout ll = view.findViewById(R.id.category_detail_row_linear);
        ImageView iw = view.findViewById(R.id.listview_category_detail_row_image);
        WindowManager wm = (WindowManager)parent.getContext().getSystemService(Context.WINDOW_SERVICE);
        Point size = new Point();
        wm.getDefaultDisplay().getRealSize(size);
        ll.getLayoutParams().width = 3*size.x/4;
        ll.getLayoutParams().height = size.y/6;
        iw.getLayoutParams().width = 3*size.x/4-(size.x/2);
        iw.getLayoutParams().height = size.y/6;
        CategoryDetailViewHolder holder = new CategoryDetailViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryDetailViewHolder holder, int position) {
        holder.CategoryDetailName.setText(list.get(position).getCategoryDetailName());
        holder.CategoryDetailAddress.setText(list.get(position).getCategoryDetailAddress());
        holder.CategoryDetailImage.setImageResource(list.get(position).getCategoryDetailImageResourceId());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
