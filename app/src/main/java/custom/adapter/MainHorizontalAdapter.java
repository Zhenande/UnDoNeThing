package custom.adapter;

import android.content.Context;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.abc.khoaluan.R;

import java.util.ArrayList;

import holder.MainHorizontalViewHolder;
import model.CardModel;

/**
 * Created by ABC on 3/6/2018.
 */

public class MainHorizontalAdapter extends RecyclerView.Adapter<MainHorizontalViewHolder> {

    private ArrayList<CardModel> list;


    public MainHorizontalAdapter(ArrayList<CardModel> Data){
        list = Data;
    }

    @NonNull
    @Override
    public MainHorizontalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_card_item,parent,false);

        // Set the width of the Card View = Width(The Devices) / 4
        // Set the height of the Card View = Height(The Devices) / 6
        // Start
        LinearLayout ll = view.findViewById(R.id.recycle_card_linearLayout);
        WindowManager wm = (WindowManager) parent.getContext().getSystemService(Context.WINDOW_SERVICE);
        Point size = new Point();
        int width = ll.getLayoutParams().width;
        if(width == 160) {
            wm.getDefaultDisplay().getRealSize(size);
            ll.getLayoutParams().width = size.x / 4;
            ll.getLayoutParams().height = size.y / 6;
            ll.requestLayout(); // Important !!! Need this when change the Layout of item dynamically
        }
        // End
        MainHorizontalViewHolder holder = new MainHorizontalViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainHorizontalViewHolder holder, int position) {

        holder.RestaurentName.setText(list.get(position).getResName());
        holder.RestaurentAddress.setText(list.get(position).getAddress());
        holder.RestaurentImage.setImageResource(list.get(position).getResImageResourceId());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
