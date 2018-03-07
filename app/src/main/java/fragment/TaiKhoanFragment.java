package fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.abc.khoaluan.DangNhapActivity;
import com.example.abc.khoaluan.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TaiKhoanFragment extends Fragment {


    private Button buttonDangNhap;

    public TaiKhoanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_tai_khoan, container, false);
        buttonDangNhap = rootView.findViewById(R.id.taiKhoan_buttonDangNhap);
        buttonDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), DangNhapActivity.class);
                startActivityForResult(i,10);
            }
        });

        return rootView;
    }

}
