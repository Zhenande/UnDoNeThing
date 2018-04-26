package fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.abc.khoaluan.R;
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import adapter.CategoryAdapter;
import adapter.CategoryDetailAdapter;
import butterknife.BindView;
import constants.Constants;
import model.Category;
import model.CategoryDetail;

/**
 * A simple {@link Fragment} subclass.
 */
public class DanhMucFragment extends Fragment {


    String[] DataTemp2 = {"Nha Hang 5", "Nha Hang 4", "Nha Hang 3", "Nha Hang 2", "Nha Hang 1"
            ,"Nha Hang 5", "Nha Hang 4", "Nha Hang 3", "Nha Hang 2", "Nha Hang 1"
            ,"Nha Hang 5", "Nha Hang 4", "Nha Hang 3", "Nha Hang 2", "Nha Hang 1"};

    int[] ImageId2 = {R.drawable.image_res_5,R.drawable.image_res_4,R.drawable.image_res_3,R.drawable.image_res_2,R.drawable.image_res_1
            ,R.drawable.image_res_5,R.drawable.image_res_4,R.drawable.image_res_3,R.drawable.image_res_2,R.drawable.image_res_1
            ,R.drawable.image_res_5,R.drawable.image_res_4,R.drawable.image_res_3,R.drawable.image_res_2,R.drawable.image_res_1};

    String[] AddressTemp2 = {"Dia Chi 5", "Dia Chi 4", "Dia Chi 3", "Dia Chi 2", "Dia Chi 1"
            ,"Dia Chi 5", "Dia Chi 4", "Dia Chi 3", "Dia Chi 2", "Dia Chi 1"
            ,"Dia Chi 5", "Dia Chi 4", "Dia Chi 3", "Dia Chi 2", "Dia Chi 1"};

    ArrayList<String> listDistrict = new ArrayList<>();
    ArrayList<CategoryDetail> listItem2 = new ArrayList<>();
    @BindView(R.id.Category_ReV_Detail_Category)
    RecyclerView rv_detail_category;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listDistrict.addAll(Arrays.asList(Constants.HCM_DISTRICT));
        listItem2.clear();
        // Create Sample Data
//        for(int i =0;i<DataTemp.length;i++){
//            Category item = new Category();
//            item.setCategoryName(DataTemp[i]);
//            item.setCategoryImageResourceId(ImageId[i]);
//            listItem.add(item);
//            CategoryDetail item2 = new CategoryDetail();
//            item2.setCategoryDetailName(DataTemp2[i]);
//            item2.setCategoryDetailImageResourceId(ImageId2[i]);
//            item2.setCategoryDetailAddress(AddressTemp2[i]);
//            listItem2.add(item2);
//        }
    }

    public DanhMucFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_danh_muc, container, false);

//        MyRecyclerView = view.findViewById(R.id.Danhmuc_RecyclerView_Category);
//        MyRecyclerView.setLayoutManager(new LinearLayoutManager(container.getContext(),LinearLayoutManager.VERTICAL,false));
//        SnapHelper snapHelper = new GravitySnapHelper(Gravity.END);
//        snapHelper.attachToRecyclerView(MyRecyclerView);
//        if(this.listItem.size() > 0 && MyRecyclerView != null){
//            this.MyRecyclerView.setAdapter(new CategoryAdapter(listItem));
//        }



        rv_detail_category.setLayoutManager(new LinearLayoutManager(container.getContext(),LinearLayoutManager.VERTICAL, false));
        SnapHelper snapHelper2 = new GravitySnapHelper(Gravity.END);
        snapHelper2.attachToRecyclerView(rv_detail_category);
        if(this.listItem2.size() > 0 && rv_detail_category != null){
            this.rv_detail_category.setAdapter(new CategoryDetailAdapter(listItem2));
        }

        return view;
    }

}
