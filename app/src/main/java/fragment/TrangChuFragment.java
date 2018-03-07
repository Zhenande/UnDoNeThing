package fragment;


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

import com.example.abc.khoaluan.R;
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;

import java.util.ArrayList;

import custom.adapter.MainHorizontalAdapter;
import model.CardModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class TrangChuFragment extends Fragment {


    String[] DataTemp = {"Nha Hang 1", "Nha Hang 2", "Nha Hang 3", "Nha Hang 4", "Nha Hang 5"};
    int[] ImageId = {R.drawable.image_res_1,R.drawable.image_res_2,R.drawable.image_res_3,R.drawable.image_res_4,R.drawable.image_res_5};
    String[] AddressTemp = {"Dia Chi 1", "Dia Chi 2", "Dia Chi 3", "Dia Chi 4", "Dia Chi 5"};
    ArrayList<CardModel> listItem = new ArrayList<>();
    RecyclerView MyRecyclerView;

    public TrangChuFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listItem.clear();
        for(int i =0;i<DataTemp.length;i++){
            CardModel item = new CardModel();
            item.setResName(DataTemp[i]);
            item.setResImageResourceId(ImageId[i]);
            item.setAddress(AddressTemp[i]);
            listItem.add(item);
        }
        getActivity().setTitle("Restaurent List");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trang_chu, container, false);
        FragmentManager fm = getFragmentManager();

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
        return view;

    }

}
