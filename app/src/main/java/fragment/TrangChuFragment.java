package fragment;


import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.example.abc.khoaluan.R;
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;

import java.util.ArrayList;

import custom.adapter.MainHorizontalAdapter;
import model.CardModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class TrangChuFragment extends Fragment {


    String[] DataTemp = {"Nha Hang 1", "Nha Hang 2", "Nha Hang 3", "Nha Hang 4", "Nha Hang 5"
                        ,"Nha Hang 1", "Nha Hang 2", "Nha Hang 3", "Nha Hang 4", "Nha Hang 5"
                        ,"Nha Hang 1", "Nha Hang 2", "Nha Hang 3", "Nha Hang 4", "Nha Hang 5"};
    int[] ImageId = {R.drawable.image_res_1,R.drawable.image_res_2,R.drawable.image_res_3,R.drawable.image_res_4,R.drawable.image_res_5
                    ,R.drawable.image_res_1,R.drawable.image_res_2,R.drawable.image_res_3,R.drawable.image_res_4,R.drawable.image_res_5
                    ,R.drawable.image_res_1,R.drawable.image_res_2,R.drawable.image_res_3,R.drawable.image_res_4,R.drawable.image_res_5};
    String[] AddressTemp = {"Dia Chi 1", "Dia Chi 2", "Dia Chi 3", "Dia Chi 4", "Dia Chi 5"
                            ,"Dia Chi 1", "Dia Chi 2", "Dia Chi 3", "Dia Chi 4", "Dia Chi 5"
                            ,"Dia Chi 1", "Dia Chi 2", "Dia Chi 3", "Dia Chi 4", "Dia Chi 5"};
    String[] DataTemp2 = {"Nha Hang 5", "Nha Hang 4", "Nha Hang 3", "Nha Hang 2", "Nha Hang 1"
                        ,"Nha Hang 5", "Nha Hang 4", "Nha Hang 3", "Nha Hang 2", "Nha Hang 1"
                        ,"Nha Hang 5", "Nha Hang 4", "Nha Hang 3", "Nha Hang 2", "Nha Hang 1"};

    int[] ImageId2 = {R.drawable.image_res_5,R.drawable.image_res_4,R.drawable.image_res_3,R.drawable.image_res_2,R.drawable.image_res_1
                    ,R.drawable.image_res_5,R.drawable.image_res_4,R.drawable.image_res_3,R.drawable.image_res_2,R.drawable.image_res_1
                    ,R.drawable.image_res_5,R.drawable.image_res_4,R.drawable.image_res_3,R.drawable.image_res_2,R.drawable.image_res_1};

    String[] AddressTemp2 = {"Dia Chi 5", "Dia Chi 4", "Dia Chi 3", "Dia Chi 2", "Dia Chi 1"
                            ,"Dia Chi 5", "Dia Chi 4", "Dia Chi 3", "Dia Chi 2", "Dia Chi 1"
                            ,"Dia Chi 5", "Dia Chi 4", "Dia Chi 3", "Dia Chi 2", "Dia Chi 1"};

    ArrayList<CardModel> listItem = new ArrayList<>();
    ArrayList<CardModel> listItem2 = new ArrayList<>();
    RecyclerView MyRecyclerView;
    RecyclerView MyRecyclerView2;

    public TrangChuFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listItem.clear();
        listItem2.clear();
        // Create Sample Data
        for(int i =0;i<DataTemp.length;i++){
            CardModel item = new CardModel();
            item.setResName(DataTemp[i]);
            item.setResImageResourceId(ImageId[i]);
            item.setAddress(AddressTemp[i]);
            listItem.add(item);
            item.setResName(DataTemp2[i]);
            item.setResImageResourceId(ImageId2[i]);
            item.setAddress(AddressTemp2[i]);
            listItem2.add(item);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trang_chu, container, false);

        // Create Main Top Hot Scroll View
        // Start
        MyRecyclerView = view.findViewById(R.id.main_cardView);
        MyRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.HORIZONTAL, false));
        SnapHelper snapHelperStart = new GravitySnapHelper(Gravity.START);
        snapHelperStart.attachToRecyclerView(MyRecyclerView);
        if (this.listItem.size() > 0 && this.MyRecyclerView != null) {
            this.MyRecyclerView.setAdapter(new MainHorizontalAdapter(this.listItem));
        }
        // End

        MyRecyclerView2 = view.findViewById(R.id.main_cardView_new);
        MyRecyclerView2.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false));
        SnapHelper snapHelperStart2 = new GravitySnapHelper(Gravity.START);
        snapHelperStart2.attachToRecyclerView(MyRecyclerView2);
        if (this.listItem2.size() > 0 && this.MyRecyclerView2 != null) {
            this.MyRecyclerView2.setAdapter(new MainHorizontalAdapter(this.listItem2));
        }

        return view;

    }

}
