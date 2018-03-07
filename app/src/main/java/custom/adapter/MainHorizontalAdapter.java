package custom.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
