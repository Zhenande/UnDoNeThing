package custom.adapter;

import android.content.Context;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.abc.khoaluan.R;

import java.util.ArrayList;

import holder.CategoryViewHolder;
import model.Category;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {

    private ArrayList<Category> list;

    public CategoryAdapter(ArrayList<Category> data) {
        this.list = data;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                            .inflate(R.layout.listview_category_row, parent, false);

        LinearLayout ll = view.findViewById(R.id.category_row_linearlayout);
        ImageView iw = view.findViewById(R.id.listview_category_row_image);
        WindowManager wm = (WindowManager)parent.getContext().getSystemService(Context.WINDOW_SERVICE);
        Point size = new Point();
        wm.getDefaultDisplay().getRealSize(size);
        ll.getLayoutParams().width = size.x/4;
        ll.getLayoutParams().height = size.y/6;
        iw.getLayoutParams().width = size.x/4;
        iw.getLayoutParams().height = size.y/6 - 30;
        CategoryViewHolder holder = new CategoryViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.CategoryImage.setImageResource(list.get(position).getCategoryImageResourceId());
        holder.CategoryName.setText(list.get(position).getCategoryName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
